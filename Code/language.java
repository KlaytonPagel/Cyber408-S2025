import java.util.Scanner;

public class language {
    public static void main(String[] args) {
        String alpha = getUI("Enter alphabet (like dis: abc): ");
        char[] alphabet = parseAlphabet(alpha);
        String[][] language = parseLanguage(alphabet);
    }

    public static char[] parseAlphabet(String input) {
        char[] aphla = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            aphla[i] = input.charAt(i);
        }
        return aphla;
    }

    public static String getUI(String prompt) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print(prompt);
        return keyboard.nextLine();
    }

    public static String[][] parseLanguage(char[] alphabet) {
        String[][] language = new String[20][2];
        String ui = getUI("Enter language format string: ");
        StringBuilder[] substrings = parseSubstring(alphabet, ui);
        int counter = 0;
        for (int i = 0; i < substrings.length; i++) {
            if (substrings[i] != null) { //wes needs tos parses
                language[counter][0] = substrings[i].substring(0, 1);//alphabet
                language[counter][1] = substrings[i].substring(2, substrings[i].length());//definition
                counter++;
            }
        }
        for (int i = 0; i < language.length; i++) {
            for (int j = 0; j < language[i].length; j++) {
                System.out.print(language[i][j]+" ");
            }
            System.out.println();
        }
        return language;
    }

    public static StringBuilder[] parseSubstring(char[] alphabet, String ui) {
        StringBuilder[] substrings = new StringBuilder[ui.length()];
        int builderIndex = -1;
        for (int i = 0; i < ui.length(); i++) {
            if (inAphla(alphabet, ui.charAt(i))) {
                builderIndex++;
                substrings[builderIndex] = new StringBuilder();
            }
            substrings[builderIndex].append(ui.charAt(i));
        }
        return substrings;
    }

    public static boolean inAphla(char[] aphla, char test) {
        boolean in = false;
        for (int i = 0; i < aphla.length; i++) {
            if (aphla[i] == test) {
                in = true;
            }
        }
        return in;
    }
}
