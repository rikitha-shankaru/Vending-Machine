package MDAEFSM.StatePattern;

// State Pattern: Abstract base class for all state classes

import MDAEFSM.*;
import OutputProcessor.*;

/**
 * ------------------------------------------------------------
 * State.java (Abstract Class)
 * ------------------------------------------------------------
 * This abstract class defines the interface for all concrete states
 * used in the MDA-EFSM. Each method represents an operation that
 * may or may not be valid in a given state. Concrete state classes
 * override the relevant methods to provide state-specific behavior.
 *
 * Design Pattern Role: State (Abstract base)
 */
public abstract class State {

    protected MDAEFSM mda;
    protected OutputProcessor op;

    /**
     * Creates the vending machine and stores the price.
     * Default implementation: no action (overridden by 'start' state).
     */
    public void create() { }

    /**
     * Handles coin insertion.
     * @param f flag indicating sufficient or insufficient funds
     */
    public void coin(int f) { }

    /**
     * Inserts cups into the vending machine.
     * @param n number of cups
     */
    public void insert_cups(int n) { }

    /**
     * Handles card-based payment.
     */
    public void card() { }

    /**
     * Cancels the transaction and returns funds.
     */
    public void cancel() { }

    /**
     * Sets or updates the drink price.
     */
    public void set_price() { }

    /**
     * Disposes the selected drink.
     * @param d drink ID
     */
    public void dispose_drink(int d) { }

    /**
     * Toggles or selects an additive.
     * @param a additive index
     */
    public void additive(int a) { }

    /**
     * Gets the reference to the MDA-EFSM controller.
     * @return the MDAEFSM instance
     */
    public MDAEFSM getMDAEFSM() {
        return mda;
    }

    /**
     * Sets the MDA-EFSM controller reference.
     * @param mda the MDAEFSM instance
     */
    public void setMDAEFSM(MDAEFSM mda) {
        this.mda = mda;
    }

    /**
     * Gets the OutputProcessor reference.
     * @return the OutputProcessor instance
     */
    public OutputProcessor getOp() {
        return op;
    }

    /**
     * Sets the OutputProcessor reference.
     * @param op the OutputProcessor instance
     */
    public void setOP(OutputProcessor op) {
        this.op = op;
    }
}
