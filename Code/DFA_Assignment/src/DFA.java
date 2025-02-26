import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DFA {
    private State[] stateList;
    private char[] alphabet;
    private State startState;

    public DFA(){
        this.intialize();
    }

    public void intialize() {
        // Open File and read
        String DFAConfig = this.getFileContent();
        parseAlphabet(DFAConfig);
        // Get alphabet
    }

    private String getFileContent() {
        StringBuilder temp = new StringBuilder();
        try {
            File inFile = new File("config.yml");
            Scanner fileReader = new Scanner(inFile);
            while(fileReader.hasNext()) {
                temp.append(fileReader.nextLine() + "\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!!");
        }
        return temp.toString();
    }

    private void parseAlphabet(String config) {
        String[] stringList = config.split("\n");
        try {
            System.out.println(stringList[1]);
        }catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid config");
        }
    }
    public State[] getStateList(){
        return this.stateList;
    }

    public char[] getAlphabet() {
        return this.alphabet;
    }

    public State getStartState() {
        return this.startState;
    }

    public void setStateList(State[] stateList) {
        this.stateList = stateList;
    }

    public void setAlphabet(char[] alphabet) {
        this.alphabet = alphabet;
    }

    public void setStartState(State startState) {
        this.startState = startState;
    }

    @Override
    public String toString() {
        return this.getAlphabet().toString();
    }
}
