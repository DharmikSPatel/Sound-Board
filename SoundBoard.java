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
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;


public class SoundBoard extends JFrame implements Runnable, ActionListener, AdjustmentListener {

	Color normalColor = new Color(238, 238, 238);
	Color selectedColor = new Color(255, 0, 64);
	Color colColor = new Color(171, 155, 142);

	final File notesDir = new File("MusicBox Notes");
	int ROWS = notesDir.list().length;
	int COLS = 100;
	int TEMPO = 200;

	JScrollPane srcollPane;
	JPanel buttonPanel, topPanel, bottomPanel, topButtonPanel;
	JToggleButton button[][];
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

	public SoundBoard() {
		UIManager.put("ToggleButton.background", normalColor);
		UIManager.put("ToggleButton.select", selectedColor);
		setUpAudioFiles();

		buttonPanel = new JPanel();
		setUpButtonPanel();
		srcollPane = new JScrollPane(buttonPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		topPanel = new JPanel(new BorderLayout());

		menuBar = new JMenuBar();
		loadSongsMenu = new JMenu("Pre-Loaded Songs");
		menuItemsSongs = new JMenuItem[3];
		preLoadedSongs = new String[] { "Harry Potter.txt", "Imperial March.txt", "s.txt" };
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
		topButtonPanel.add(randomButton);

		clearButton = new JButton("Clear");
		clearButton.addActionListener(this);
		topButtonPanel.add(clearButton);

		playPauseButton = new JButton("Stop");
		playPauseButton.addActionListener(this);
		topButtonPanel.add(playPauseButton);

		topPanel.add(menuBar, BorderLayout.WEST);
		topPanel.add(topButtonPanel, BorderLayout.EAST);

		bottomPanel = new JPanel(new BorderLayout());
		tempoBar = new JScrollBar(JScrollBar.HORIZONTAL, TEMPO, 0, 0, 2000);
		tempoBar.addAdjustmentListener(this);
		tempoLabel = new JLabel(String.format("Tempo: %-6d", TEMPO));
		tempoLabel.setFont(new Font("Consolas", Font.BOLD, 13));
		bottomPanel.add(tempoLabel, BorderLayout.WEST);
		bottomPanel.add(tempoBar, BorderLayout.CENTER);

		setLayout(new BorderLayout());
		add(srcollPane, BorderLayout.CENTER);
		add(topPanel, BorderLayout.NORTH);
		add(bottomPanel, BorderLayout.SOUTH);

		setTitle("Sound Board");
		setSize(1000, 1000);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Thread timing = new Thread(this);
		timing.start();
	}

	public void run() {

		do {
			for (int x = 0; x < COLS && notStopped; x++) {
				for (int y = 0; y < ROWS && notStopped; y++) {
					if (button[y][x] != null && button[y][x].isSelected()) {
						clip[y][x % 5].start();
					} else if (button[y][x] != null) {
						button[y][x].setBackground(colColor);
					}
				}
				try {
					Thread.sleep(TEMPO);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				for (int y = 0; y < ROWS; y++) {
					if(button[y][x] != null)
						button[y][x].setBackground(normalColor);
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
				playPauseButton.setText("Stop");
				notStopped = true;
				Thread timing = new Thread(this);
				timing.start();
			}
		} else if (e.getSource() == randomButton) {
			stopPlaying();
			for (int y = 0; y < ROWS; y++) {
				for (int x = 0; x < COLS; x++) {
					button[y][x].setSelected(((int)(Math.random()*30)) == 0 ? true : false);
				}
			}
		} else if (e.getSource() == clearButton) {
			stopPlaying();
			for (int y = 0; y < ROWS; y++) {
				for (int x = 0; x < COLS; x++) {
					button[y][x].setSelected(false);
				}
			}
		} else if (e.getSource() == fileMenuItems[1]) {
			stopPlaying();
			saveFile();
		} else if (e.getSource() == fileMenuItems[0]) {
			stopPlaying();
			readFile(openFile());
		} else {
			for (int i = 0; i < menuItemsSongs.length; i++) {
				if (e.getSource() == menuItemsSongs[i]) {
					stopPlaying();
					readFile(new File(preLoadedSongs[i]));
				}
			}
		}
	}

	public void adjustmentValueChanged(AdjustmentEvent e) {
		if (e.getSource() == tempoBar) {
			TEMPO = tempoBar.getValue();
			tempoLabel.setText(String.format("Tempo: %-6d", TEMPO));
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
						if(button[y][x].isSelected())
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
		playPauseButton.setText("Play");
		notStopped = false;
	}

	public void readFile(File file) {
		String[] sheet = new String[ROWS];
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String[] firstLineParts = br.readLine().split(" ");
			COLS = Integer.parseInt(firstLineParts[1]);
			TEMPO = Integer.parseInt(firstLineParts[3]);
			tempoBar.setValue(TEMPO);

			setUpButtonPanel();

			String line = "";
			int i = 0;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				sheet[i] = line;
				i++;
			}
			br.close();
		} catch (Exception e) {
			System.out.println("FILE ERROR " + e);
		}

		for (int y = 0; y < ROWS; y++) {
			for (int x = 0; x < COLS; x++) {
				if ((sheet[y].charAt(x) + "").equals("x"))
					button[y][x].setSelected(true);
				else
					button[y][x].setSelected(false);
			}
		}

		revalidate();
		repaint();
	}

	public void setUpButtonPanel() {
		buttonPanel.removeAll();
		buttonPanel.setLayout(new GridLayout(ROWS, COLS, 2, 2));
		button = new JToggleButton[ROWS][COLS];
		for (int y = 0; y < ROWS; y++) {
			for (int x = 0; x < COLS; x++) {
				button[y][x] = new JToggleButton();
				button[y][x].setPreferredSize(new Dimension(30, 30));
				button[y][x].setFont(new Font("Arial", Font.BOLD, 10));
				button[y][x].setMargin(new Insets(0, 0, 0, 0));
				button[y][x].setText(clipNames[y].toUpperCase());
				buttonPanel.add(button[y][x]);
			}
		}
	}

	public void setUpAudioFiles() {
		clip = new Clip[ROWS][5];
		clipNames = new String[] { "c3", "c#3", "d3", "d#3", "e3", "f3", "f#3", "g3", "g#3", "a3", "a#3", "b3", "c4",
				"c#4", "d4", "d#4", "e4", "f4", "f#4", "g4", "g#4", "a4", "a#4", "b4", "c5", "c#5", "d5", "d#5", "e5",
				"f5", "f#5", "g5", "g#5", "a5", "a#5", "b5", "c6" };
		try {
			for (int y = 0; y < ROWS; y++) {
				for (int x = 0; x < clip[y].length; x++) {
					URL url = this.getClass().getClassLoader().getResource("MusicBox Notes\\" + clipNames[y] + ".wav");
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