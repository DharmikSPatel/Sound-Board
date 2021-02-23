import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SoundBoard extends JFrame implements Runnable, ActionListener, AdjustmentListener {

	Color normalColor1 = Color.WHITE;
	Color normalColor2 = Color.decode("#e0f7fa");
	Color selectedColor = Color.decode("#e06666");
	Color columnsColor = Color.decode("#4dd0e1");

	final File notesDir = new File("Piano Notes");
	int ROWS = notesDir.list().length;
	int COLS = 100;
	int TEMPO = 200;

	JScrollPane scrollPane;
	JPanel buttonPanel, topPanel, bottomPanel, topButtonPanel, columnsInputPanel;
	JToggleButton buttons[][];
	boolean notStopped = true;
	String[] clipNames = new String[ROWS];
	Clip[][] clip;

	JButton playPauseButton, clearButton, randomButton;

	JScrollBar tempoBar;
	JLabel tempoLabel;

	JMenuBar menuBar;
	JMenu loadSongsMenu;
	JMenuItem[] menuItemsSongs;
	String[] preLoadedSongs;

	JMenu fileMenu;
	JMenuItem[] fileMenuItems;
	String[] fileMenuItemNames;

	JLabel columnsInputLabel;
	JTextField columnsInput;
	JButton columnsInpuButton;
	public SoundBoard() {
		UIManager.put("ToggleButton.select", selectedColor);

		setUpAudioFiles();

		buttonPanel = new JPanel();
		setUpButtonPanel("init");
		scrollPane = new JScrollPane(buttonPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		topPanel = new JPanel(new BorderLayout());
		columnsInputPanel = new JPanel();
		columnsInputLabel = new JLabel("Columns: ");
		columnsInput = new JTextField(""+COLS);
		columnsInpuButton = new JButton("ENTER");
		columnsInpuButton.addActionListener(this);
		columnsInputPanel.add(columnsInputLabel);
		columnsInputPanel.add(columnsInput);
		columnsInputPanel.add(columnsInpuButton);
		menuBar = new JMenuBar();
		loadSongsMenu = new JMenu("Pre-Loaded Songs");
		preLoadedSongs = new String[] { "Let It Go.txt", "Harry Potter.txt", "Imperial March.txt", "Game Of Thrones.txt", "Pirates Of The Caribbean.txt", "Senorita.txt", "Havana.txt", "Memories.txt", "Mission Impossible.txt", "Animals.txt", "Shape Of You.txt", "Cantina Band.txt"};
		menuItemsSongs = new JMenuItem[preLoadedSongs.length];
		for (int i = 0; i < menuItemsSongs.length; i++) {
			menuItemsSongs[i] = new JMenuItem(preLoadedSongs[i].substring(0, preLoadedSongs[i].length() - 4));
			menuItemsSongs[i].addActionListener(this);
			loadSongsMenu.add(menuItemsSongs[i]);
		}
		fileMenu = new JMenu("File");
		fileMenuItems = new JMenuItem[2];
		fileMenuItemNames = new String[] {"Open", "Save"};
		for (int i = 0; i < fileMenuItems.length; i++){
			fileMenuItems[i] = new JMenuItem(fileMenuItemNames[i]);
			fileMenuItems[i].addActionListener(this);
			fileMenu.add(fileMenuItems[i]);
		}
		menuBar.add(fileMenu);
		menuBar.add(loadSongsMenu);
		topButtonPanel = new JPanel();
		randomButton = new JButton("Random");
		randomButton.addActionListener(this);
		randomButton.setFocusPainted(false);
		topButtonPanel.add(randomButton);
		clearButton = new JButton("Clear");
		clearButton.addActionListener(this);
		clearButton.setFocusPainted(false);
		topButtonPanel.add(clearButton);
		playPauseButton = new JButton(new ImageIcon("stop.png"));
		playPauseButton.setPreferredSize(new Dimension(26, 26));
		playPauseButton.setMargin(new Insets(0, 0, 0, 0));
		playPauseButton.addActionListener(this);
		//playPauseButton.setFocusPainted(false);
		topButtonPanel.add(playPauseButton);
		topPanel.add(menuBar, BorderLayout.WEST);
		topPanel.add(topButtonPanel, BorderLayout.EAST);
		topPanel.add(columnsInputPanel, BorderLayout.CENTER);

		bottomPanel = new JPanel(new BorderLayout());
		tempoBar = new JScrollBar(JScrollBar.HORIZONTAL, TEMPO, 0, 0, 2000);
		tempoBar.addAdjustmentListener(this);
		tempoLabel = new JLabel(String.format("%s%-6d","Tempo: ", TEMPO));
		tempoLabel.setFont(new Font("Consolas", Font.BOLD, 13));
		bottomPanel.add(tempoLabel, BorderLayout.WEST);
		bottomPanel.add(tempoBar, BorderLayout.CENTER);

		setLayout(new BorderLayout());
		add(scrollPane, BorderLayout.CENTER);
		add(topPanel, BorderLayout.NORTH);
		add(bottomPanel, BorderLayout.SOUTH);


		setTitle("Sound Board");
		setSize(1000, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Thread timing = new Thread(this);
		timing.start();
	}

	public void run() {

		do {
			for (int x = 0; x < COLS && notStopped; x++) {
				for (int y = 0; y < ROWS && notStopped; y++) {
					if (buttons[y][x] != null && buttons[y][x].isSelected()) {
						clip[y][x % clip[y].length].start();
					} else if (buttons[y][x] != null) {
						buttons[y][x].setBackground(columnsColor);
					}
				}
				try {
					Thread.sleep(TEMPO);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				for (int y = 0; y < ROWS; y++) {
					if(buttons[y][x] != null)
						buttons[y][x].setBackground(y % 2==0 ? normalColor1 : normalColor2);
				}
				for (int r = 0; r < ROWS; r++) {
					for (int c = 0; c < clip[r].length; c++) {
						if (!clip[r][c].isRunning() || !notStopped) {
							clip[r][c].stop();
							clip[r][c].setFramePosition(0);
						}
					}
				}
			}
		} while (notStopped);
	}

	public static void main(String args[]) {
		SoundBoard app = new SoundBoard();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == playPauseButton) {
			if (notStopped) {
				stopPlaying();
			} else {
				playPauseButton.setIcon(new ImageIcon("stop.png"));;
				notStopped = true;
				Thread timing = new Thread(this);
				timing.start();
			}
		} else if (e.getSource() == randomButton) {
			stopPlaying();
			for (int y = 0; y < ROWS; y++) {
				for (int x = 0; x < COLS; x++) {
					buttons[y][x].setSelected(((int)(Math.random()*30)) == 0 ? true : false);
				}
			}
		} else if (e.getSource() == clearButton) {
			stopPlaying();
			for (int y = 0; y < ROWS; y++) {
				for (int x = 0; x < COLS; x++) {
					buttons[y][x].setSelected(false);
				}
			}
		} else if (e.getSource() == fileMenuItems[1]) {
			stopPlaying();
			saveFile();
		} else if (e.getSource() == fileMenuItems[0]) {
			stopPlaying();
			File file = openFile();
			if(file != null)
				readFile(file);
		} else if (e.getSource() == columnsInpuButton) {
			stopPlaying();
			COLS = Integer.parseInt(columnsInput.getText());
			setUpButtonPanel("chaning cols");
		} else {
			for (int i = 0; i < menuItemsSongs.length; i++) {
				if (e.getSource() == menuItemsSongs[i]) {
					stopPlaying();
					readFile(new File("Pre Loaded Songs\\"+preLoadedSongs[i]));
				}
			}
		}
	}

	public void adjustmentValueChanged(AdjustmentEvent e) {
		if (e.getSource() == tempoBar) {
			TEMPO = tempoBar.getValue();
			tempoLabel.setText(String.format("%s%-6d","Tempo: ", TEMPO));
		}
	}
	private void saveFile() {
		JFileChooser fc = new JFileChooser(".");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.txt", "txt");
		fc.setFileFilter(filter);
		if(fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
			File file = fc.getSelectedFile();
			try{
				String st = file.getAbsolutePath();
				if(!st.contains(".txt"))
					st+=".txt";

				String output = "COLS: "+COLS+" TEMPO: "+TEMPO+"\n";
				for(int y = 0; y < ROWS; y++){
					for(int x = 0; x < COLS; x++){
						if(buttons[y][x].isSelected())
							output += "x";
						else
							output += "-";
					}
					output += "\n";
				}
				BufferedWriter bw = new BufferedWriter(new FileWriter(st));
				bw.write(output);
				bw.close();
			}catch(IOException err){
				err.printStackTrace();
			}
		}
	}
	public File openFile(){
		JFileChooser fc = new JFileChooser(".");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.txt", "txt");
		fc.setFileFilter(filter);
		int result = fc.showOpenDialog(null);
		if(result == JFileChooser.APPROVE_OPTION){
			return fc.getSelectedFile();
		}
		else{
			return null;
		}
	}
	private void stopPlaying() {
		playPauseButton.setIcon(new ImageIcon("play.jpg"));
		notStopped = false;
	}

	public void readFile(File file) {
		String[] sheet = new String[ROWS];
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String[] firstLineParts = br.readLine().split(" ");
			COLS = Integer.parseInt(firstLineParts[1]);
			columnsInput.setText(""+COLS);
			TEMPO = Integer.parseInt(firstLineParts[3]);
			tempoBar.setValue(TEMPO);

			setUpButtonPanel("reading file");

			String line = "";
			int i = 0;
			while ((line = br.readLine()) != null) {
				sheet[i] = line;
				i++;
			}
			br.close();
		} catch (Exception e) {
			System.out.println("====================");
			e.printStackTrace();
		}

		for (int y = 0; y < ROWS; y++) {
			for (int x = 0; x < COLS; x++) {
				if ((sheet[y].charAt(x) + "").equals("x"))
					buttons[y][x].setSelected(true);
				else
					buttons[y][x].setSelected(false);
			}
		}
	}

	public void setUpButtonPanel(String doing) {
		buttonPanel.removeAll();
		buttonPanel.setLayout(new GridLayout(ROWS, COLS, 2, 2));
		if(buttons == null)
			buttons = new JToggleButton[ROWS][COLS];
		JToggleButton[][] temp = new JToggleButton[ROWS][COLS];
		for (int y = 0; y < ROWS; y++) {
			for (int x = 0; x < COLS; x++) {
				temp[y][x] = new JToggleButton();
				temp[y][x].setPreferredSize(new Dimension(20, 20));
				temp[y][x].setFont(new Font("Arial", Font.BOLD, 7));
				temp[y][x].setMargin(new Insets(0, 0, 0, 0));
				temp[y][x].setText(clipNames[y].toUpperCase());
				temp[y][x].setFocusPainted(false);
				temp[y][x].setBackground(y % 2==0 ? normalColor1 : normalColor2);
				if(!(doing.contains("read") || doing.contains("init")) && y < buttons.length && x < buttons[y].length && buttons[y][x] != null && buttons[y][x].isSelected())
					temp[y][x].setSelected(true);
				buttonPanel.add(temp[y][x]);
			}
		}
		buttons = temp;
		revalidate();
		repaint();
	}

	public void setUpAudioFiles() {
		clip = new Clip[ROWS][5];
		clipNames = new String[] { "c3", "c#3", "d3", "d#3", "e3", "f3", "f#3", "g3", "g#3", "a3", "a#3", "b3", "c4",
				"c#4", "d4", "d#4", "e4", "f4", "f#4", "g4", "g#4", "a4", "a#4", "b4", "c5", "c#5", "d5", "d#5", "e5",
				"f5", "f#5", "g5", "g#5", "a5", "a#5", "b5", "c6" };
		try {
			for (int y = 0; y < ROWS; y++) {
				for (int x = 0; x < clip[y].length; x++) {
					URL url = this.getClass().getClassLoader().getResource("Piano Notes\\" + clipNames[y] + ".wav");
					AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
					clip[y][x] = AudioSystem.getClip();
					clip[y][x].open(audioIn);
				}
			}
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
}