public class Main {
    public static void main(String[] args) {

        State s0 = new State(0, false);
        State s1 = new State(1, false);
        s0.addTransition(s1, 'a');
        for (int i = 0; i < s0.getTransList().length; i++) {
            System.out.println(s0.getTransList()[i]);
        }
        System.out.println(s0 + " " + s1);

        DFA newDFA = new DFA();

    }

}
