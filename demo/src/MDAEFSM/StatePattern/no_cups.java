package MDAEFSM.StatePattern;

import MDAEFSM.*;
import OutputProcessor.*;

// State Pattern: This class represents the "no_cups" state

/**
 * ------------------------------------------------------------
 * no_cups.java
 * ------------------------------------------------------------
 * Represents the "no_cups" state in the MDA-EFSM state machine.
 * This state occurs when a transaction is initiated (coin/card inserted)
 * but the vending machine has no cups available to serve the drink.
 *
 * Only valid transition from this state is inserting cups.
 */
public class no_cups extends State {

    /**
     * Constructor to initialize EFSM and OutputProcessor references.
     * @param mda Reference to the EFSM controller
     * @param op Reference to the OutputProcessor
     */
    public no_cups(MDAEFSM mda, OutputProcessor op) {
        this.mda = mda;
        this.op = op;
    }

    /**
     * Handles coin insertion in the no_cups state.
     * - Accepts the coin
     * - Informs user that cups are missing
     * - Refunds the coins and resets the cumulative fund
     * @param f flag for sufficient funds (not used in this state)
     */
    public void coin(int f) {
        op.IncreaseCF();
        op.ReturnCoins();
        System.out.println("No Cups in the Vending Machine, PLEASE INSERT CUPS FIRST!");
        op.ZeroCF();
    }

    /**
     * Inserts cups into the vending machine.
     * - Updates the internal cup counter
     * - Resets the cumulative fund
     * - Transitions to the idle state
     * @param n number of cups to insert
     */
    public void insert_cups(int n) {
        if (n > 0) {
            mda.k = n;
            op.ZeroCF();
            mda.ChangeState(2); // transition to idle state
            System.out.println("Cups Inserted " + mda.k);
        } else {
            System.out.println("Insert cups");
        }
    }
}
