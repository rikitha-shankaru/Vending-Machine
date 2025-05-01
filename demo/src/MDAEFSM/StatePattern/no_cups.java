package MDAEFSM.StatePattern;

import MDAEFSM.*;
import OutputProcessor.*;
import DataStore.*;
import DataStore.DataStore1;
import DataStore.DataStore2;
import OutputProcessor.StrategyPattern.ReturnCoins; 
import OutputProcessor.StrategyPattern.ReturnCoins1;

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
        DataStore ds = op.getDataStore();
        
        // Store coin value to temp_v for refund
        if (op.getDataStore() instanceof DataStore1) {
            DataStore1 ds1 = (DataStore1) op.getDataStore();
            ds1.setTemp_v(f); // Store the actual coin value
        } 
        // Skipping setTemp_v for VM2 as coin value may not matter here
        else if (ds instanceof DataStore2) {
            //DataStore2 ds2 = (DataStore2) ds;
            //ds2.setTemp_v(f); // Store as int for VM2
            //System.out.println("[VM2] Stored: " + ds2.getIntTemp_v());
        }

        // Refund coin using strategy
        ReturnCoins returnCoins = new ReturnCoins1();
        returnCoins.setDataStore(op.getDataStore());
        returnCoins.ReturnCoins();

        // Reset cumulative fund
        op.ZeroCF();
        
        System.out.println("No cups available! Please insert cups first.");
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
            mda.k = n; // update cup count
            op.ZeroCF(); // clear previous balance
            mda.ChangeState(2); // transition to idle state
            System.out.println(n + " cups inserted. Machine ready.");
        } else {
            System.out.println("ERROR: Must insert at least 1 cup");
        }
    }
    
    /**
     * Invalid: Machine is already initialized.
     */
    public void create() {
        System.out.println("ERROR: Machine already created. Insert cups instead.");
    }
    
    /**
     * Invalid: Cannot change price when no cups are present.
     */
    public void set_price() {
        System.out.println("ERROR: Cannot set price while no cups available.");
    }
    
    /**
     * Invalid: Card transactions are not allowed without cups.
     */
    public void card() {
        System.out.println("ERROR: Card payment not allowed while no cups available.");
    }
    
    /**
     * Invalid: No active transaction to cancel.
     */
    public void cancel() {
        System.out.println("ERROR: Nothing to cancel - no transaction in progress.");
    }
    
    /**
     * Invalid: Cannot serve a drink without cups.
     */
    public void dispose_drink(int d) {
        System.out.println("ERROR: Cannot dispense drink - no cups available.");
    }
    
    /**
     * Invalid: Cannot add additives when no cups are available.
     */
    public void additive(int a) {
        System.out.println("ERROR: Cannot add additives - no cups available.");
    }
}