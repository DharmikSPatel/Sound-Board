console.log("Here");
let starWarsNotes = {
    0: "G4,C5,C4",
    4: "G4,C5,C4",
    8: "G4,C5,C4",
    12: "Ab4,B3",
    15: "Eb5",
    16: "G4,C5,C4",
    20: "Ab4,B3",
    23: "Eb5",
    24: "G4,C5,C4",
    28: "C4",
    32: "Eb5,G5,C5,C4",
    36: "Eb5,G5,C5,C4",
    40: "Eb5,G5,C5,C4",
    44: "B4,Eb5,Ab4,Ab5",
    47: "Eb5",
    48: "B4,Ab4",
    52: "Ab4,B3",
    55: "Eb5",
    56: "G4,C5,C4",
    60: "C4",
    64: "G5,C6,C5,C4",
    68: "C5,C4",
    71: "C5",
    72: "G5,C6,C5,C4",
    76: "B5,G5,C5,C4",
    79: "Bb5",
    80: "Db5,Gb4,Gb5,A5",
    81: "Ab5",
    82: "Db5,Gb5,A5",
    84: "Gb4",
    86: "Db5",
    88: "Gb4,Gb5,Db5",
    92: "Gb4,Db5,F5",
    95: "E5",
    96: "B4,Eb5,Ab4",
    97: "D5",
    98: "B4,Eb5,Ab4",
    102: "Ab4",
    104: "B4,Ab4",
    108: "Gb4,Ab4,B3",
    111: "B4",
    112: "Eb5,G4,C5,C4",
    116: "Gb4,C5",
    119: "Eb5",
    120: "Eb5,G5,C5,C4",
    124: "C4",
    128: "C6,C5,Ab5",
    132: "C5",
    135: "C5",
    136: "G5,C6,C5,C4",
    140: "B5,G5,C5,C4",
    143: "Bb5",
    144: "Db5,Gb4,Gb5,A5",
    145: "Ab5",
    146: "Db5,Gb4,Gb5,A5",
    150: "Gb4,Db5",
    152: "Gb4,Gb5,Db5",
    154: "Gb4",
    156: "Gb4,Db5,F5",
    158: "Gb4",
    159: "E5",
    160: "B4,Eb5,Ab4",
    161: "D5",
    162: "B4,Eb5,Ab4",
    166: "Ab4",
    168: "B4,Ab4",
    170: "Ab4",
    172: "Ab4,B3",
    174: "Ab4",
    175: "B4",
    176: "G4,C5,C4",
    180: "F4,Ab4,B3",
    183: "Eb5",
    184: "G4,C5,C4",
    188: "C4",
    192: "G4,C5,C4",
    196: "G4,C5,C4",
    200: "G4,C5,C4",
    204: "Ab4,B3",
    207: "Eb5",
    208: "G4,C5,C4",
    212: "Ab4,B3",
    215: "Eb5",
    216: "G4,C5,C4",
    220: "C4",
    224: "Eb5,G5,C5,C4",
    228: "Eb5,G5,C5,C4",
    232: "Eb5,G5,C5,C4",
    236: "B4,Eb5,Ab4,Ab5",
    239: "Eb5",
    240: "B4,Ab4",
    244: "Ab4,B3",
    247: "Eb5",
    248: "G4,C5,C4",
    252: "C4",
    256: "G5,C6,C5,C4",
    260: "C5,C4",
    263: "C5",
    264: "G5,C6,C5,C4",
    268: "B5,G5,C5,C4",
    271: "Bb5",
    272: "Db5,Gb4,Gb5,A5",
    273: "Ab5",
    274: "Db5,G,b5,A5",
    276: "Gb4",
    278: "Db5",
    280: "Gb4,Gb5,Db5",
    284: "Gb4,Db5,F5",
    287: "E5",
    288: "B4,Eb,5,Ab4",
    289: "D5",
    290: "B4,Eb,5,Ab4",
    294: "Ab4",
    296: "B4,Ab4,",
    300: "Ab4,B3",
    303: "B4",
    304: "G4,C5,C4",
    308: "Ab4,B3",
    311: "Eb5"
}

let piartes = {
    2: "E4",
    3: "G4",
    4: "A4,E4,C4",
    6: "A4,E4,C4",
    8: "A4",
    9: "B4",
    10: "C5,A4,F4",
    12: "C5,A4,F4",
    14: "C5",
    15: "D5",
    16: "B4,G4,D4",
    18: "B4,G4,D4",
    20: "A4",
    21: "G4",
    22: "G4",
    23: "A4,E4,C4",
    26: "E4",
    27: "G4",
    28: "A4,C4,F4",
    30: "A4,C4,F4",
    32: "A4",
    33: "B4",
    34: "C5,G4,E4",
    36: "C5,G4,E4",
    38: "C5",
    39: "D5",
    40: "B4,G4,D4",
    42: "B4,G4,D4",
    44: "A4",
    45: "G4",
    46: "A4,E4,C4",
    50: "E4",
    51: "G4",
    52: "A4,E4,C4",
    54: "A4,E4,C4",
    56: "A4",
    57: "C5",
    58: "D5,A4,F4",
    60: "D5,A4,F4",
    62: "D5",
    63: "E5",
    64: "F5,D5,A4",
    66: "F5,D5,A4",
    68: "E5",
    69: "D5",
    70: "E5,C5,A4",
    71: "A4",
    74: "A4",
    75: "B4",
    76: "C5,A4,F4",
    78: "C5,A4,F4",
    80: "D5",
    82: "E5,C5,A4",
    83: "A4",
    86: "A4",
    87: "C5",
    88: "B4,E4,A4",
    90: "B4,E4,A4",
    92: "C5",
    93: "A4",
    94: "B4,A4,E4",
    98: "E4,E5",
    99: "G4,G5",
    100: "A4,E4,C4",
    102: "C4,E4,A4",
    104: "A4,E4,C4",
    105: "B4,B5",
    106: "C5,A4,F4,C4",
    108: "F4,A4,C5,C4",
    110: "C5,C4,F4,A4",
    111: "D5,D4",
    112: "B4,G4,D4",
    114: "D4,G4,B4",
    116: "A4,A5",
    117: "G4,G5",
    118: "G4,G5",
    119: "A4,E4,C4,A5",
    122: "E4,E5",
    123: "G4,G5",
    124: "A4,F4,C4",
    126: "A4,F4,C4",
    128: "A4,F4,C4",
    129: "B4,B5",
    130: "C5,G4,E4,C4",
    132: "E4,G4,C5,C4",
    134: "C5,C4",
    135: "D5,D4",
    136: "B4,G4,D4",
    138: "D4,G4,B4",
    140: "A4,A5",
    141: "G4,G5",
    142: "A4,E4,C4,A5",
    146: "E4,E5",
    147: "G4,G5",
    148: "A4,E4,C4",
    150: "A4,E4,C4",
    152: "A4,A5",
    153: "C5,C6",
    154: "D5,A4,F4",
    156: "D5,A4,F4",
    158: "D5,D4",
    159: "E5,E4",
    160: "D5,A4,F4,F5",
    162: "A4,D5,F5,F4",
    164: "E5,E4",
    165: "D5,D4",
    166: "E5,C5,A4,E4",
    167: "A4,E4",
    170: "A4,A5,E4",
    171: "B4,B5,F4",
    172: "A4,F4,D5,D4",
    174: "F4,A4,C5",
    176: "C5,C4",
    177: "D5,D4",
    178: "E5,C5,A4",
    179: "A4",
    182: "A4,A5",
    183: "C5,C6",
    184: "B4,A4,E4",
    186: "E4,A4,B4",
    188: "C5,C6",
    189: "A4,A5",
    190: "A4,E4,C4,A5",
    192: "C4,E4,A4,A5",
    194: "E4,C4,B4,A4",
    196: "C5,A4,E4,C4",
    198: "C4,E4,A4,C5",
    200: "D5,A4,F4,D4",
    202: "E4,A4,C5,E5",
    206: "C5,E4",
    207: "A4,E4",
    208: "E4",
    214: "F5,C5,A4,F4",
    218: "F4,C5",
    219: "F4,A4",
    220: "F4",
    224: "F4",
    226: "A4,E4",
    227: "E4",
    228: "C5,A4,E4",
    230: "G4,D4,D5",
    232: "E4,A4,C5,E5",
    234: "E5,C5,A4,E4",
    236: "A4,C5,E5,E4",
    238: "F4,A4,C5,F5",
    239: "E5,C5,A4,E4",
    244: "D4,G4,B4,D5",
    246: "D5,B4,G4,D4",
    248: "D5,B4,G4,D4",
    250: "D5,B4,G4,D4",
    251: "E4,A4,C5,E5",
    255: "E4",
    256: "E5,C5,A4,E4",
    258: "E4,A4,C5,E5",
    260: "E5,C5,A4,E4",
    262: "F5,C5,A4,F4",
    263: "E4,A4,C5,E5",
    265: "E4",
    266: "A4",
    267: "C5",
    268: "D5,A4,F4,D4",
    270: "C4,F4,A4,C5",
    272: "B4,E4",
    274: "A4,E4,C4"
}

let gotNotes = {0: "D5",2: "D4",4: "F4",5: "A4",6: "D5",8: "D4",10: "F4",11: "A4",12: "D5",14: "D4",16: "F4",17: "A4",18: "D5",20: "D4",22: "F4",23: "A4",24: "D5,A5",26: "D4",28: "F4",29: "A4",30: "D5",32: "D4",34: "F4",35: "A4",36: "D5,F5",37: "G5",38: "D4,A5",40: "F4",41: "A4",42: "D5",44: "D4",46: "F4,F5",47: "G5,A4",48: "E5,G4",50: "E4",52: "C4",53: "E4",54: "A4",56: "E4",58: "C4",59: "E4",60: "A4",62: "E4",64: "C4",65: "E4",66: "A4",68: "E4",70: "C4",71: "E4",72: "G5,C5",74: "C4",76: "E4",77: "G4",78: "C5",80: "C4",82: "E4",83: "G4",84: "E5,C5",85: "F5",86: "G5,C4",88: "E4",89: "G4",90: "C5",92: "C4",94: "E4",95: "G4",96: "B4,F5",97: "E5",98: "G4,D5",100: "D4",101: "G4",102: "B4",104: "G4",106: "D4",107: "G4",108: "B4",110: "G4",112: "D4",113: "G4",114: "B4",116: "G4",118: "D4",119: "G4",120: "D5,A5",122: "D4",124: "F4",125: "A4",126: "D5",128: "D4",130: "F4",131: "A4",132: "B4,D5,F5",133: "G5,C5",134: "D4,D5,A5",136: "F4",137: "A4",138: "D5",140: "D4",142: "F4,F5",143: "G5,A4",144: "E5,G4",146: "E4",148: "C4",149: "E4",150: "A4",152: "E4",154: "C4",155: "E4",156: "A4",158: "E4",160: "C4",161: "E4",162: "A4",164: "E4",166: "C4",167: "E4",168: "G5,C5",170: "C4",172: "E4",173: "G4",174: "C5",176: "C4",178: "E4",179: "G4",180: "E5,A4,C5",181: "B4,F5",182: "G5,C5,C4",184: "E4",185: "G4",186: "C5",188: "C4",190: "E4",191: "G4",192: "D5,F5",193: "E5",194: "D4,D5",196: "F4",197: "A4",198: "D5",200: "D4",202: "F4",203: "A4",204: "D5",206: "D4",208: "F4",209: "A4",210: "D4"}

let forzenNotes = {0: "E5,B5,A4",1: "C6",2: "E5",3: "B5",5: "C6",8: "B5,F4,C5",9: "C6",10: "E5",11: "C6",13: "B5",15: "D5",16: "G4,A5,D5",17: "B5",18: "D5",19: "A5",21: "B5",23: "D5",24: "G5,D5,A4",28: "F5",32: "E5,B5,A4",33: "C6",34: "E5",35: "B5",37: "C6",40: "F4,C6,C5",41: "B5",42: "E5",43: "C6",45: "B5",47: "D5",48: "G4,A5,D5",49: "B5",50: "D5",51: "A5",53: "B5",55: "D5",56: "G5,D5,A4",60: "F5",63: "A4",64: "E5",66: "E5,E4",68: "E5,A4",70: "E5",71: "E5",72: "E5,F4",73: "D5",74: "C5,C4",75: "C5",76: "F4",78: "C5,C4",79: "C5",80: "G4,D5",81: "D5",82: "D4",84: "G4",85: "D5",86: "C5",87: "A4",88: "D4,A4",92: "F4",95: "A4",96: "E5",97: "E5",98: "E5",99: "E5",100: "A4",102: "G5",103: "G5",104: "F4",105: "E5",106: "C4",108: "G4",110: "A4,C4",111: "C5",112: "G4,D5",113: "E5",114: "D4",116: "G4",117: "D5",118: "C5",119: "D5",120: "D4,G4",122: "A4",124: "D4,A4",128: "A4",130: "E5",131: "E5",132: "A4",133: "G5",134: "E5",135: "A5",136: "F4",137: "G5",138: "C5",139: "E5",140: "F4",141: "G5",142: "C5",143: "G5",144: "G4",145: "G5",146: "D4",147: "F5",148: "G4",149: "E5",150: "D4,G4",151: "F5",152: "E5,D4",153: "G4",154: "A4",155: "B4",156: "G4,C5",157: "D5",158: "E5",159: "F5",160: "E5,A4,C5",162: "D5",163: "E5",164: "D5",165: "C5",167: "B4,G4,D5",170: "D5",171: "E5",172: "D5",174: "C5",176: "D4",177: "A4",178: "A5",180: "D5",182: "E5",184: "G5,D5",186: "E5",188: "A5",192: "B5,G5,G4,D5",194: "D5",195: "D5",197: "G5",199: "G5",200: "G4,D5",202: "D5",203: "D5",205: "A5",207: "A5",208: "F4,C5",210: "A5",211: "G5",212: "A5",213: "A5",215: "G5",216: "A5,F4,F5,C5",217: "B5",219: "C6",221: "B5",223: "B5,G5",224: "G4,D5",226: "D5",227: "D5",229: "G5",231: "G5,D5",232: "G4",234: "D5",235: "D5",237: "A5",239: "A5,F5",240: "F4,C5",242: "F4,F5,C5",244: "F4,F5,C5",246: "F4,F5,C5",248: "F4,F5,C5",250: "F4,F5,C5",252: "F4,F5,C5",254: "G5,F4,C5",255: "A5,F5",256: "F4,C5",257: "B5,G5",258: "F4,F5,C5",259: "A5,C6",260: "F4,F5,C5",262: "F4,F5,C5",264: "F4,C5",266: "F4,C5",268: "F4,C5",269: "A4",270: "B4",271: "C5",272: "E4,C4",274: "E4,C4",276: "E4,C4",277: "G4",278: "E4,G4,C4",279: "D5",280: "D4",281: "G4",282: "B4,D4",283: "G4",284: "B4,D4",285: "G4",286: "B4,D4,C6",287: "G4",288: "E5,A5,C4",289: "E5,A5,A4",290: "E5,A5,C4",291: "A4",292: "E5,A5,C4",293: "B5,A4",294: "E5,C4",295: "A4,C6",296: "F4,C4",298: "F4,C4",300: "F4,C4",301: "A4",302: "B4,F4,C4",303: "C5",304: "E4,C4",306: "E4,C4",308: "E4,C4",309: "G4",310: "E5,E4,C4",311: "B4,G4,D5",312: "B4,D4",313: "G4",314: "B4,D4",315: "G4",316: "B4,D4",317: "G4,C5",318: "B4,D4,D5",319: "E5,G4,C4",320: "A4,C4",321: "E5,E4",322: "A4,C4",323: "E4,F5",324: "E5,A4,C4",325: "E4",326: "D5,A4,C4",327: "E4,C5",328: "D5,A4,C4",329: "F4,C5",330: "A4,C4",331: "F4",332: "C4,F5,A4",334: "F4,A4,F5",336: "E5,G5,G4,C5,C4",337: "G4",338: "C4",339: "E5,G4",340: "C4",341: "G4",342: "B4,D5,C4",343: "G4",344: "G4",345: "D4",346: "G4",347: "D4",348: "G4,C5",349: "D4",350: "G4,C5",351: "D4",352: "E5,G5,G4,A4,C5",353: "E4",354: "A4",355: "E5,E4",356: "A4",357: "E4",358: "A4,C5",359: "E4",360: "F4",361: "C4",362: "F4",363: "C4",364: "F4",365: "C4",366: "F4,C5",367: "C5,C4",368: "B4,E4,G4",369: "B4",370: "E4",371: "G4,F4",373: "G4",374: "E4",375: "C4",376: "E4",377: "F4",378: "E4",379: "F4",380: "G4",381: "F4",382: "E4",383: "C5",384: "C4,F4,F5,A4",386: "F5",387: "E5",388: "F5",389: "E5",390: "F5",391: "F5",392: "E5",393: "C5"}

let senoNotes= {0: "B5,Ab4",4: "Ab4,Ab5",8: "Eb5",10: "Ab4",12: "B5",14: "Bb5,Ab4",18: "Gb5,Ab4",22: "Gb5,Ab4",24: "B5,Ab4",26: "Gb4,Bb5",28: "Ab5",30: "Bb5",32: "B5,B3",36: "B4,Gb5",38: "Gb4",40: "Eb5,Gb4",42: "B4",44: "B5",46: "Bb5,B3",50: "B4,Gb5",54: "Gb5,B3",56: "B5,G4",57: "Gb4,Bb5",59: "Ab5",61: "Gb5",63: "E5,E4",66: "B5",67: "E4",69: "B5,B3",71: "B5,B3",73: "E4",77: "E5,E4",79: "E5",81: "E4",82: "B5",85: "B5,E4",87: "B5,E4",91: "B3",93: "Bb5,B3",97: "B5",99: "Bb5",101: "B5",103: "Bb5",105: "Gb5",109: "Bb5",113: "B5,Gb4",115: "Bb5",117: "B5",119: "Bb5",121: "Bb5,B3",123: "Ab5",125: "Bb5",127: "B5",131: "Ab4,Ab5",135: "Eb5",137: "Ab4",139: "B5",141: "Bb5",145: "Gb5,Ab4",149: "Gb5",151: "B5,Ab4",153: "Gb4,Bb5",155: "Ab5",157: "Bb5",159: "B5,B3",163: "B4,Gb5",165: "Gb4",167: "Eb5,Gb4",169: "B4",171: "B5",173: "Bb5,B3",177: "B4,Gb5",181: "Gb5,B3",183: "B5,G4",184: "Gb4,Bb5",186: "Ab5",188: "Gb5",190: "E5,E4",193: "B5",194: "E4",196: "B5,B3",198: "B5,B3",200: "E4",204: "E5,E4",206: "E5",208: "E4",209: "B5",212: "B5,E4",214: "B5,E4",218: "B3",220: "Bb5,B3",224: "B5",226: "Bb5",228: "B5",230: "Bb5",232: "Gb5",236: "Bb5",240: "B5,Gb4",242: "Bb5",244: "B5",246: "Bb5",248: "B3",249: "Ab5",252: "Gb5",254: "Ab5",256: "Eb5"}

let havanaNotes = {8: "B5,E4",9: "B5",10: "B4,E4,G5",11: "G5",12: "E5,C4",13: "C4",14: "G4,C5",15: "B3",17: "B5,Gb4",18: "B4,Eb5,A5",19: "B5",20: "C6",21: "B5,Gb4",22: "B4,Eb5,A5",23: "G5",24: "B5,E4",25: "B5",26: "B4,E4,G5",27: "G5",28: "E5,C4",29: "C4",30: "G4,C5",31: "B3",33: "B5,Gb4",34: "B4,Eb5,A5",35: "B5",36: "C6",37: "B5,Gb4",38: "B4,Eb5,A5",39: "G5",40: "B5,E4",41: "B5",42: "B4,E4,G5",43: "G5",44: "E5,C4",45: "C4",46: "G4,C5",47: "B3",49: "B5,Gb4",50: "B4,Eb5,A5",51: "B5",52: "C6",53: "B5,Gb4",54: "B4,Eb5,A5",55: "G5",56: "B5,E4",57: "G5",58: "B4,E4",59: "B5",60: "A5,C4",61: "B5,C4",62: "G4,A5,C5",63: "G5,B3",64: "B5",65: "Gb5",67: "G5",68: "Gb5",69: "G5",70: "Gb5",71: "G5",72: "E5"}
let havanMusic = makeMusic(havanaNotes, 74)



function makeMusic(notes, COLS){
    let completN = ["c3",
    "c#3",
    "d3",
    "d#3",
    "e3",
    "f3",
    "f#3",
    "g3",
    "g#3",
    "a3",
    "a#3",
    "b3",
    "c4",
    "c#4",
    "d4",
    "d#4",
    "e4",
    "f4",
    "f#4",
    "g4",
    "g#4",
    "a4",
    "a#4",
    "b4",
    "c5",
    "c#5",
    "d5",
    "d#5",
    "e5",
    "f5",
    "f#5",
    "g5",
    "g#5",
    "a5",
    "a#5",
    "b5",
    "c6"];
    let output = "";
    for (let i = 0; i < completN.length; i++) {
        for (let j = 0; j < COLS; j++) {
            if (j in notes) {
                notes[j] = notes[j].replace("Ab", "G#");
                notes[j] = notes[j].replace("Bb", "A#");
                notes[j] = notes[j].replace("Db", "C#");
                notes[j] = notes[j].replace("Eb", "D#");
                notes[j] = notes[j].replace("Gb", "F#");
                if (notes[j].includes(completN[i].toUpperCase())) {
                    output += "x";
                }
                else {
                    output += "-";
                }
            }
            else {
                output += "-";
            }
        }
        output += "\n";
        console.log("New Collum")
    }
    return output;
}
