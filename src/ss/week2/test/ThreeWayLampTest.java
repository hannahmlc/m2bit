package ss.week2.test;

import ss.week2.ThreeWayLamp;

public class ThreeWayLampTest {

    public static void main( String [] args){
        ThreeWayLampTestClass test = new ThreeWayLampTestClass();
        test.runTest();

    }
}
    class ThreeWayLampTestClass {

        private ThreeWayLamp lamp;

        public void runTest(){
            setUp();
            testInitialState();
            setUp();
            testSequence();
        }

        public void setUp() {
            lamp = new ThreeWayLamp();
        }

        // Test if after being created the lamp is OFF
        public void testInitialState(){
            System.out.println("Initial State testing ");
            System.out.println("Initial State: " + lamp.getState());

        }

        // Test if the sequence OFF → LOW → MEDIUM → HIGH → OFF is properly implemented
        private void testSequence() {
            System.out.println("Test switching: ");
            System.out.println("Start: " + lamp.getState());
            lamp.nextState();
            System.out.println("After 1 change: " + lamp.getState());
            lamp.nextState();
            System.out.println("After 2 change: " + lamp.getState());
            lamp.nextState();
            System.out.println("After 3 change: " + lamp.getState());
            lamp.nextState();
            System.out.println("After 4 change: " + lamp.getState());
        }


    }



