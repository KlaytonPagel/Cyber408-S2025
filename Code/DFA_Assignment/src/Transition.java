public class Transition {
    private State nextState;
    private char transChar;

    public Transition(State nextState, char transChar) {
        this.setNextState(nextState);
        this.setTransChar(transChar);
    }

    public State getNextState() {
        return this.nextState;
    }

    public void setNextState(State nextState) {
        this.nextState = nextState;
    }

    public char getTransChar() {
        return this.transChar;
    }

    public void setTransChar(char transChar) {
        this.transChar = transChar;
    }

    @Override
    public String toString() {
        return this.getTransChar() + " -> " + this.getNextState().toString();
    }
}
