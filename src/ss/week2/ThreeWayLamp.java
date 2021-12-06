package ss.week2;

enum States{
    OFF,
    LOW,
    MEDIUM,
    HIGH,
    STATE,
    NEXT,
    HELP,
    EXIT
}

public class ThreeWayLamp {

    private States state;

    /**
     * class constructor
     * @requires default value OFF
     * @ensures default value is OFF
     */
    public ThreeWayLamp() {
        state = States.OFF;
        assert state == States.OFF;
    }


    /**
     * Get current lamp state
     * @ensures return current state of lamp
     * @return current state
     */
    public States getState(){
        return state;
    }


    /**
     * change lamp state
     * @param newState state
     * @requires one of the existing states OFF, LOW, MEDIUM, HIGH
     * @ensures lamp state is changed to given input
     */
    public void setState(States newState){
        assert( newState.equals(States.OFF) ||
                newState.equals(States.LOW) ||
                newState.equals(States.MEDIUM) ||
                newState.equals(States.HIGH) ): "state doesnt exist";
        this.state = newState;
    }


    /**
     * change lamp state to next state
     * @requires one of the existing states OFF, LOW, MEDIUM, HIGH
     * @ensures lamp state is changed to next state according to order OFF>LOW>MEDIUM>HIGH>OFF
     */
    public void nextState(){
        switch (state) {
            case OFF:
                state = States.LOW;
                break;
            case LOW:
                state = States.MEDIUM;
                break;
            case MEDIUM:
                state = States.HIGH;
                break;
            case HIGH:
                state = States.OFF;
                break;
        }


    }



}
