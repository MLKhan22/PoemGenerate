package dspoetry;

import java.util.*;
import java.util.regex.Pattern;
import java.io.File;

class TemplateMinh{
    //Testing stuff with colors
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    public static final String INVIS = "\u001B[8m";
    
    public static final String BLACK_bg = "\u001B[40m";
    public static final String RED_bg = "\u001B[41m";
    public static final String GREEN_bg = "\u001B[42m";
    public static final String YELLOW_bg = "\u001B[43m";
    public static final String BLUE_bg = "\u001B[44m";
    public static final String PURPLE_bg = "\u001B[45m";
    public static final String CYAN_bg = "\u001B[46m";
    public static final String WHITE_bg = "\u001B[47m";
    
    static String[] txtC = {BLACK,RED,GREEN,YELLOW,BLUE,PURPLE,CYAN};
    static String[] bgC = {BLACK_bg,RED_bg,GREEN_bg,YELLOW_bg,BLUE_bg,PURPLE_bg,CYAN_bg};
    
    static String[][] graph =
    {"1111111111111110000000000000001111111111111111111111111111100000000".split(""),
    "1111111111111111000000000000001111111111111111111111111111100000000".split(""),
    "1100000000000001100000000000000000000111000000000000000000000000000".split(""),
    "1100000000000001100000000000000000000111000000000000000000000000000".split(""),
    "1100000000000001100000000000000000000111000000000000000000000000000".split(""),
    "1100000000000001100000000000000000000111000000000000000000000000000".split(""),
    "1111111111111111000000000000000000000111000000000000000000000000000".split(""),
    "1111111111111100000000000000000000000111000000000000000000000000000".split(""),
    "1100000000000000000000000000000000000111000000000000000000000000000".split(""),
    "1100000000000000000000000000000000000111000000000000000000000000000".split(""),
    "1100000000000000000000000000000000000111000000000000000000000000000".split(""),
    "1100000000000000000000000000000000000111000000000000000000000000000".split(""),
    "1100000000000000000000000000000000000111000000000000000000000000000".split(""),
    "1100001111100111111001000000010000000111000111111010000000101111000".split(""),
    "1100001000100100000001100000110000000111000100000011000001101000100".split(""),
    "1100001000100111111001010001010000000111000111111010100010101111000".split(""),
    "11000010001001000000010010100100000001110001000000100101001010000111".split(""),
    "11000011111001111110010001000100000001110001111110100010001010000111".split(""),};

    //Testing stuff with colors
    
    
    //	receives user inputs
    static Scanner scan = new Scanner(System.in);
    
    //	holds the source text that will be used
    static String text = "";
    
    //	holds the meter for a line
    static String meter = "";
    
    //	holds the rhyme scheme
    static String rScheme = "";
    
    //	holds invalid inputs
    static String falseHolder = "";
    
    //	holds the # of lines/stanza
    static int lines = 0;
    
    //	holds the # of stanzas
    static int stanzas = 0;
    
    //	the folder that will be searched for texts
    static File folder = new File("SourceTexts");
    
    //	an array of all the contents of (folder)
    static File[] listOfFiles = folder.listFiles();
    
    //	an array of literary devices
    static String[] devices = {"None", "Rhyme Scheme", "Alliteration", "Allit.+RS"};
    
    //	the literary device that will be used
    static String device = "None";
    
    //  hold the checkList outputs;
    static int temp = 0;
    
    public static void main(String[] args){
        //////////////////////////////////////////////////
        //	Test
        //////////////////////////////////////////////////
        
        //////////////////////////////////////////////////
        //	Show title
        //////////////////////////////////////////////////
        clearSC();
        printFlash(graph);
        sleeper(3000);
        System.out.print(RESET+GREEN);
        clearSC();
        
        //////////////////////////////////////////////////
        //	Ask user to select a text
        //////////////////////////////////////////////////
        
        System.out.println("Which text would you like to use?");
        sleeper(3000);
        clearSC();
        
        for (int i = 0; i < listOfFiles.length; i++) {
            System.out.println( (i+1) + ") " + listOfFiles[i].getName());
        }
        System.out.print("\nSelect a number from the list: ");
        temp = checkList(listOfFiles, "File");
        text = "" + listOfFiles[temp-1];
        clearSC();
        for (int i = 0; i < listOfFiles.length; i++) {
            if(i == temp-1)
                System.out.println( RED+(i+1) + ") " + listOfFiles[i].getName()+GREEN);
            else
                System.out.println( (i+1) + ") " + listOfFiles[i].getName());
        }
        sleeper(2000);
        Poet.setVocab(text);
        clearSC();
        
        //////////////////////////////////////////////////
        //	Ask user to enter a valid meter
        //////////////////////////////////////////////////
        
        System.out.print("Enter a line of meter\n ");
        System.out.print("(type \"Default\" to select default meter)\n");
        System.out.print("Meter: ");
        checkMeter();
        clearSC();
        
        //////////////////////////////////////////////////
        //	Ask user to enter how many lines
        //	each stanza will be
        //////////////////////////////////////////////////
        
        System.out.println("How many lines?");
        lines = checkInput( "Lines", lines);
        clearSC();
        
        //////////////////////////////////////////////////
        //	Ask user to enter the
        //	number of stanzas to generate
        //////////////////////////////////////////////////
        
        System.out.println("How many stanzas?");
        stanzas = checkInput( "Stanzas", stanzas);
        clearSC();
        
        //////////////////////////////////////////////////
        //	Ask user to select literary devices
        //////////////////////////////////////////////////
        
        System.out.println("Choose a literary device to use\n");
        sleeper(2000);
        clearSC();
        for (int i = 0; i < devices.length; i++) {
            System.out.println( (i+1) + ") " + devices[i]);
        }
        System.out.print("\nSelect a number from the list: ");
        temp = checkList(devices, "String");
        device = "" + devices[temp-1];
        clearSC();
        for(int i = 0; i < devices.length; i++){
            if(i == temp-1)
                System.out.println( RED+(i+1) + ") " + devices[i]+GREEN);
            else
                System.out.println( (i+1) + ") " + devices[i]);
        }
        sleeper(2000);
        clearSC();
        if(device.equals("Rhyme Scheme") || device.equals("Allit.+RS")){
            System.out.println("Enter rhyme scheme that is " + lines + " capital letters long");
            System.out.print("Rhyme Scheme: ");
            checkRhymeScheme();
            clearSC();
        }
        
        //////////////////////////////////////////////////
        //	Ask user whether or not
        //	changes need to be made
        //////////////////////////////////////////////////
        
        modifyVars();
        
    }
    ///////////////////////////////////////////////////
    ///////Methods\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    ///////////////////////////////////////////////////
    
    
    /*
     * @param: No parameters
     * @return: No return value
     *
     *  Repeatedly checks for a valid meter input.
     *  If input is valid, (meter) is set to the input.
     */
    static void checkMeter(){
        System.out.print(RED);
        meter = scan.next();
        System.out.print(GREEN);
        if(!meter.matches("^Default$")){
            while(!meter.matches("^[0-1]{2,10}$")){
                clearSC();
                System.out.print("Please enter a line of \"0\"s and \"1\"s between 2 and 10 chars long \nOr type \"Default\": ");
                System.out.print(RED);
                meter = scan.next();
                System.out.print(GREEN);
                if(meter.matches("^Default$"))
                    break;
            }
        }
    }
    
    /*
     * @param: No parameters
     * @return: No return value
     *
     *  Repeatedly checks for a valid RhymeScheme input.
     *  If input is valid, (rScheme) is set to the input.
     */
    static void checkRhymeScheme(){
        System.out.print(RED);
        rScheme = scan.next();
        System.out.print(GREEN);
        while(!rScheme.matches("^[A-Z]{" + lines + "}$")){
            clearSC();
            System.out.println("Please enter " + lines + " capital letters");
            System.out.print("Rhyme Scheme: ");
            System.out.print(RED);
            rScheme = scan.next();
            System.out.print(GREEN);
        }
        
    }
    
    /*
     * @param arr: The list to check
     * @param type: A String name of the type of array (arr) is
     *
     * @return: An integer corresponding to the desired object's position in (arr)
     *
     *  Repeatedly checks for a integer input that
     *  is between 0 and the length of (arr).
     *  If the input is a valid integer, the input is returned.
     */
    static <T>int checkList( T[] arr, String type){
        int y = 0;
        System.out.print(RED);
        if(scan.hasNextInt()){
            y = scan.nextInt();
            System.out.print(GREEN);
        }
        else{
            scan.next();
            System.out.print(GREEN);
            y = 0;
        }
        
        while( y <= 0 || y > arr.length){
            clearSC();
            
            for (int i = 0; i < arr.length; i++) {
                if(type.equals("File"))
                    System.out.println( (i+1) + ") " + ((File) arr[i]).getName());
                else System.out.println( (i+1) + ") " + arr[i]);
            }
            System.out.print("\nPlease enter a number from 1 to " + arr.length + ": "+RED);
            if (scan.hasNextInt()){
                y = scan.nextInt();
                System.out.print(GREEN);
            }
            else{
                falseHolder = scan.next();
                System.out.print(GREEN);
                y = 0;
            }
        }
        return y;
    }
    
    /*
     * @param x: The name of the variable to change.
     * @param y: The variable that will be changed. (Must be an int type)
     *
     * @return: An integer that the variable will be set to
     *
     *  Mainly used for the (Line) and (Stanza) variables.
     *  Repeatedly checks for an input that
     *  is greater than 0.
     *  If the input is a valid integer, the input is returned.
     */
    
    static int checkInput(String x, int y){
        System.out.print(x + ": "+RED);
        if(scan.hasNextInt()){
            y = scan.nextInt();
            System.out.print(GREEN);
        }
        else{
            scan.next();
            System.out.print(GREEN);
            y = 0;
        }
        
        while( y <= 0 ){
            clearSC();
            System.out.println("Invalid: Please enter a number greater than 0");
            System.out.print(x + ": "+RED);
            if (scan.hasNextInt()){
                y = scan.nextInt();
                System.out.print(GREEN);
            }
            else{
                falseHolder = scan.next();
                System.out.print(GREEN);
                y = 0;
            }
        }
        return y;
    }
    
    /*
     * @param: No parameters
     * @return: No return value
     *
     * (part1){
     *  Prints out all of the variables that
     *  the user has changed.
     *  Then, asks the user if any modifications
     *  would like to be made to any variables.
     *  If no, goes to (part2).
     *  If yes, asks the user which variable,
     *  then allows user to change chosen variable.
     *  Repeats (part1).
     *  }
     *
     *  (part2){
     *  calls the tryGenerate() method.
     *  }
     */
    
    static void modifyVars(){
        
        System.out.println("SourceText: " + RED+ text.substring(text.indexOf("/")+1,text.indexOf(".")) +GREEN);
        System.out.println("Meter: " + RED+meter+GREEN);
        System.out.println("Lines: " + RED+lines+GREEN);
        System.out.println("Stanzas: " + RED+stanzas+GREEN);
        System.out.println("Device: " + RED+device+GREEN + "\n");
        System.out.print("Would you like to change any variables?(y/n): "+RED);
        String choose = scan.next();
        System.out.print(GREEN);
        while(!choose.equals("n") && !choose.equals("y")){
            clearSC();
            System.out.println("SourceText: " + RED+ text.substring(text.indexOf("/")+1,text.indexOf(".")) +GREEN);
            System.out.println("Meter: " + RED+meter+GREEN);
            System.out.println("Lines: " + RED+lines+GREEN);
            System.out.println("Stanzas: " + RED+stanzas+GREEN);
            System.out.println("Device: " + RED+device+GREEN + "\n");
            System.out.print("Please type y or n: "+RED);
            choose = scan.next();
            System.out.print(GREEN);
        }
        clearSC();
        if(choose.equals("n")){
            tryGenerate();
        }
        else{
            String[] choices = {"SourceText", "Meter", "Lines", "Stanzas", "Device"};
            for(int i = 0; i < choices.length; i++){
                System.out.println(i+1+") " + choices[i]);
            }
            System.out.print("\nSelect a variable to change: ");
            choose = "n";
            int x = checkList(choices, "String");
            clearSC();
            for(int i = 0; i < choices.length; i++){
                if( i == x-1)
                    System.out.println(RED+(i+1)+") " + choices[i]+GREEN);
                else
                    System.out.println(i+1+") " + choices[i]);
            }
            sleeper(2000);
            clearSC();
            while(choose.equals("n")){
                if(x == 1){
                    System.out.println("Which text would you like to use?");
                    sleeper(2000);
                    clearSC();
                    folder = new File("SourceTexts");
                    listOfFiles = folder.listFiles();
                    
                    for (int i = 0; i < listOfFiles.length; i++) {
                        System.out.println( (i+1) + ") " + listOfFiles[i].getName());
                    }
                    System.out.print("\nSelect a number from the list: ");
                    temp = checkList(listOfFiles, "File");
                    text = "" + listOfFiles[temp-1];
                    clearSC();
                    for (int i = 0; i < listOfFiles.length; i++) {
                        if(i == temp-1)
                            System.out.println( RED+(i+1) + ") " + listOfFiles[i].getName()+GREEN);
                        else
                            System.out.println( (i+1) + ") " + listOfFiles[i].getName());
                    }
                    sleeper(2000);
                    Poet.setVocab(text);
                    clearSC();
                }
                if(x == 2){
                    System.out.print("Enter a line of meter\n ");
                    System.out.print("(type \"Default\" to select default meter)\n");
                    System.out.print("Meter: ");
                    checkMeter();
                    clearSC();
                }
                if(x == 3){
                    System.out.println("How many lines?");
                    lines = checkInput( "Lines", lines);
                    clearSC();
                    if(rScheme.length() != lines && (device.equals("Allit.+RS") || device.equals("Rhyme Scheme"))){
                        System.out.println("Enter rhyme scheme that is " + lines + " capital letters long");
                        System.out.print("Rhyme Scheme: ");
                        checkRhymeScheme();
                        clearSC();
                    }
                }
                if(x == 4){
                    System.out.println("How many stanzas?");
                    stanzas = checkInput( "Stanzas", stanzas);
                    clearSC();
                }
                if(x == 5){
                    System.out.println("Choose a literary device to use\n");
                    sleeper(2000);
                    clearSC();
                    for (int i = 0; i < devices.length; i++) {
                        System.out.println( (i+1) + ") " + devices[i]);
                    }
                    System.out.print("\nSelect a number from the list: ");
                    temp = checkList(devices, "String");
                    device = "" + devices[temp-1];
                    clearSC();
                    for(int i = 0; i < devices.length; i++){
                        if(i == temp-1)
                            System.out.println( RED+(i+1) + ") " + devices[i]+GREEN);
                        else
                            System.out.println( (i+1) + ") " + devices[i]);
                    }
                    sleeper(2000);
                    clearSC();
                    if(device.equals("Rhyme Scheme") || device.equals("Allit.+RS")){
                        System.out.println("Enter rhyme scheme that is " + lines + " capital letters long");
                        System.out.print("Rhyme Scheme: ");
                        checkRhymeScheme();
                        clearSC();
                    }
                }
                modifyVars();
            }
        }
    }
    
    /*
     * @param devType: The type of literary device to be used
     * @return: No return value
     *
     * Checks which literary device the user has selected.
     * Then, generates a poem, prints it out,
     * and exits the program.
     */
    static void generatePoem(String devType) {
        System.out.print(RED);
        DumbPoem dp = new DumbPoem();
        Alliteration ap = new Alliteration();
        
        if(devType.equals("None")){
            for(int a = 0; a < stanzas; a++){
                for(int b = 0; b < lines; b++){
                    if(!meter.equals("Default")){
                        String p = Poet.writeLineWithMeter(meter);
                        String print = p.substring(0, 2).toUpperCase() + p.substring(2).toLowerCase();
                        System.out.println(print);
                    }
                    else{
                        String p = dp.generatePoem();
                        String[] sentence = p.split(" ");
                        while(sentence.length < 3 || sentence.length > 10){
                            p = dp.generatePoem();
                            sentence = p.split(" ");
                        }
                        String print = p.substring(0, 2).toUpperCase() + p.substring(2).toLowerCase();
                        System.out.println(print);
                    }
                }
                System.out.print("\n");
            }
            System.exit(0);
        }
        if(devType.equals("Alliteration")){
            for(int a = 0; a < stanzas; a++){
                for(int b = 0; b < lines; b++){
                    if(!meter.equals("Default")){
                        String cMeter = meter;
                        String p = Poet.writeLineWithMeter(cMeter);
                        String lastWord = p.substring(p.lastIndexOf(" ")+1);
                        cMeter = cMeter.substring(0,cMeter.length()-Poet.numSyllables(lastWord));
                        p = Poet.writeLineWithMeterAndAlliteration(cMeter, lastWord);
                        String print = p.substring(0, 2).toUpperCase() + p.substring(2).toLowerCase();
                        System.out.println(print);
                    }
                    else{
                        String p = ap.generatePoem();
                        ap.phoneme = ap.rndPhone();
                        String[] sentence = p.split(" ");
                        while(sentence.length < 3 || sentence.length > 10){
                            p = ap.generatePoem();
                            sentence = p.split(" ");
                        }
                        String print = p.substring(0, 2).toUpperCase() + p.substring(2).toLowerCase();
                        System.out.println(print);
                    }
                }
                System.out.print("\n");
            }
            System.exit(0);
        }
        
        String[] rhymeLines = rScheme.split("");
        String[] rhymeScheme = rhymeLines;
        rhymeLines = new HashSet<String>(Arrays.asList(rhymeLines)).toArray(new String[0]);
        Hashtable<String, String> rTable = new Hashtable<String, String>();
        
        for(int i = 0; i < rhymeLines.length; i++){
            if(!meter.equals("Default"))
                rTable.put(rhymeLines[i], Poet.writeLineWithMeter(meter));
            else
                rTable.put(rhymeLines[i], Poet.writeLineWithMeter("0101010101"));
        }
        if(devType.equals("Rhyme Scheme")){
            for(int a = 0; a < stanzas; a++){
                for(int b = 0; b < lines; b++){
                    if(!meter.equals("Default")){
                        String p = Poet.writeLineWithMeterAndRhymeswith(meter, rTable.get(rhymeScheme[b]));
                        rTable.put(rhymeScheme[b], p);
                        String print = p.substring(0, 2).toUpperCase() + p.substring(2).toLowerCase();
                        System.out.println(print);
                    }
                    else{
                        String p = Poet.writeLineWithMeterAndRhymeswith("0101010101", rTable.get(rhymeScheme[b]));
                        rTable.put(rhymeScheme[b], p);
                        String p2 = dp.generatePoem();
                        String[] sentence = p2.split(" ");
                        while(sentence.length < 3 || sentence.length > 10){
                            p2 = dp.generatePoem();
                            sentence = p2.split(" ");
                        }
                        String print = p2.substring(0, 2).toUpperCase()
                        +  p2.substring(2, p2.lastIndexOf(" ")).toLowerCase()
                        + " " + p.substring(p.lastIndexOf(" ")+1).toLowerCase();
                        System.out.println(print);
                    }
                }
                System.out.print("\n");
            }
            System.exit(0);
        }
        if(devType.equals("Allit.+RS")){
            for(int a = 0; a < stanzas; a++){
                for(int b = 0; b < lines; b++){
                    if(!meter.equals("Default")){
                        String cMeter = meter;
                        String p = Poet.writeLineWithMeterAndRhymeswith(cMeter, rTable.get(rhymeScheme[b]));
                        String lastWord = p.substring(p.lastIndexOf(" ")+1);
                        cMeter = cMeter.substring(0,cMeter.length()-Poet.numSyllables(lastWord));
                        rTable.put(rhymeScheme[b], p);
                        p = Poet.writeLineWithMeterAndAlliteration(cMeter, lastWord);
                        String print = p.substring(0, 2).toUpperCase() + p.substring(2).toLowerCase();
                        System.out.println(print);
                    }
                    else{
                        String p = Poet.writeLineWithMeterAndRhymeswith("0101010101", rTable.get(rhymeScheme[b]));
                        rTable.put(rhymeScheme[b], p);
                        String lastWord = p.substring(p.lastIndexOf(" ")+1);
                        String[] phones = Poet.wordMap.get(lastWord).phonemes;
                        ap.phoneme = phones[0];
                        String p2 = ap.generatePoem();
                        String[] sentence = p2.split(" ");
                        while(sentence.length < 3 || sentence.length > 10){
                            p2 = ap.generatePoem();
                            sentence = p2.split(" ");
                        }
                        String print = p2.substring(0, 2).toUpperCase() 
                        +  p2.substring(2, p2.lastIndexOf(" ")).toLowerCase()
                        + " " + p.substring(p.lastIndexOf(" ")+1).toLowerCase();
                        System.out.println(print);
                    }
                }
                System.out.print("\n");
            }
            System.exit(0);
        }
        
    }
    
    /*
     * @param: No parameters
     * @return: No return value
     *
     * Trys to generate a poem again if it 
     * fails the first time.
     */
    static void tryGenerate(){
        boolean goodPoem = false;
        while(!goodPoem){
            try{
                goodPoem = true;
                generatePoem(device);
            }
            catch(NullPointerException ex) {
                clearSC();
                goodPoem = false;
            }
            catch(IndexOutOfBoundsException ex){
                clearSC();
                goodPoem = false;
            }
        }
    }
    
    /*
     * @param microsecs: The number of microseconds to sleep
     * @return: No return value
     *
     * Sleep for a # of microseconds
     */
    static void sleeper(int microsecs){
        try {
            Thread.sleep(microsecs);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    
    /*
     * @param: No parameters
     * @return: No return value
     *
     * Clears the terminal
     */
    static void clearSC(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    /*
     * @param graph: String matrix to be printed
     * @param color: Color to be used
     * @param speed: Speed the matrix is printed
     *
     * @return: No return value
     *
     * Prints out the String matrix
     * (for "0"s and "1"s)
     */
    public static void printGraph(String[][] graph, String color, int speed)
    {
        System.out.print(color);
        for(int i = 0 ; i < graph.length; i++)
        {
            for (int j = 0 ; j < graph[i].length ; j++)
            {
                if(graph[i][j].equals("1"))
                    System.out.print("*");
                else
                    System.out.print(" ");
                
            }
            System.out.println();
            sleeper(speed);
        }
        sleeper(3000);
    }
    
    /*
     * @param graph: String matrix to be inverted
     * @return: No return value
     *
     * Inverts the values of the String matrix
     * (for "0"s and "1"s)
     */
    public static void invGraph(String[][] graph){
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[i].length; j++){
                if(graph[i][j].equals("0"))
                    graph[i][j] = "1";
                else
                    graph[i][j] = "0";
            }
        }
    }
    
    /*
     * @param graph: String matrix to be printed
     * @return: No return value
     *
     * Prints the matrix with flashing colors
     * (for "0"s and "1"s)
     */
    public static void printFlash(String[][] graph){
        for(int a = 0; a < 25; a++){
            for(int i = 0 ; i < graph.length; i++)
            {
                for (int j = 0 ; j < graph[i].length ; j++)
                {
                    if(graph[i][j].equals("1"))
                        System.out.print("*");
                    else
                        System.out.print(" ");
                    
                }
                System.out.println();
            }
            sleeper(250);
            int N = (int)(Math.random()*txtC.length);
            System.out.print(txtC[N]);
            clearSC();
            sleeper(1);
        }
    }
}
