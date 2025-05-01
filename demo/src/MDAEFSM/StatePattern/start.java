package MDAEFSM.StatePattern;

// State Pattern: This class represents the "start" state

import MDAEFSM.*;
import OutputProcessor.*;

/**
 * ------------------------------------------------------------
 * start.java
 * ------------------------------------------------------------
 * Represents the initial "start" state in the MDA-EFSM.
 * This is the first state entered after system initialization.
 *
 * Valid operation:
 * - create(): Initializes the system by storing the price and
 *             transitioning to the next logical state.
 */
public class start extends State {

    /**
     * Constructor to initialize references to EFSM controller and OutputProcessor.
     * @param mda Reference to the EFSM controller
     * @param op Reference to the OutputProcessor
     */
    public start(MDAEFSM mda, OutputProcessor op) {
        this.mda = mda;
        this.op = op;
    }

    /**
     * Initializes the vending machine:
     * - Stores the configured price using OutputProcessor
     * - Transitions the state to "no_cups"
     */
    public void create() {
        op.StorePrice();
        mda.ChangeState(1); // transition to no_cups state
        System.out.println("Machine created and ready");
    }
    
    /**
     * Invalid operation: Coins can't be inserted before machine is created.
     */
    public void coin(int f) {
        System.out.println("ERROR: Insert coins not allowed in start state. Create machine first.");
    }

    /**
     * Invalid operation: Cannot insert cups before creating machine.
     */
    public void insert_cups(int n) {
        System.out.println("ERROR: Insert cups not allowed in start state. Create machine first.");
    }

    /**
     * Invalid operation: Cannot update price before machine is created.
     */
    public void set_price() {
        System.out.println("ERROR: Set price not allowed in start state. Create machine first.");
    }

    /**
     * Invalid operation: Card payment not allowed before initialization.
     */
    public void card() {
        System.out.println("ERROR: Card payment not allowed in start state. Create machine first.");
    }

    /**
     * Invalid operation: Nothing to cancel before machine is initialized.
     */
    public void cancel() {
        System.out.println("ERROR: Cancel not allowed in start state. Create machine first.");
    }

    /**
     * Invalid operation: Cannot serve drink before machine is created.
     */
    public void dispose_drink(int d) {
        System.out.println("ERROR: Cannot dispose drink in start state. Create machine first.");
    }

    /**
     * Invalid operation: Cannot add additives before starting the machine.
     */
    public void additive(int a) {
        System.out.println("ERROR: Cannot add additives in start state. Create machine first.");
    }
}

