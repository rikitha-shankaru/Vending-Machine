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
    }
}
