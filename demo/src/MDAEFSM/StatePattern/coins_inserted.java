package MDAEFSM.StatePattern;

// State Pattern: This class represents the "coins_inserted" state

import MDAEFSM.*;
import OutputProcessor.*;
import DataStore.*;
import DataStore.DataStore1;
import DataStore.DataStore2;
import OutputProcessor.StrategyPattern.ReturnCoins; 
import OutputProcessor.StrategyPattern.ReturnCoins1;

/**
 * ------------------------------------------------------------
 * coins_inserted.java
 * ------------------------------------------------------------
 * Part of the State Pattern implementation for the MDA-EFSM.
 * This class models the behavior of the system when the user
 * has inserted sufficient funds (via coins or card).
 *
 * Valid operations in this state:
 * - cancel(): cancel the transaction and refund
 * - coin(): reject additional coins and return them
 * - dispose_drink(): serve the selected drink
 * - additive(): toggle selected additives
 */
public class coins_inserted extends State {

    /**
     * Constructor to initialize references to EFSM and OutputProcessor.
     * @param mda Reference to the EFSM controller
     * @param op Reference to the OutputProcessor
     */
    public coins_inserted(MDAEFSM mda, OutputProcessor op) {
        this.mda = mda;
        this.op = op;
    }

    /**
     * If coin is inserted again in this state, return it.
     * This is to prevent overpayment.
     */
    public void coin(int f) {
        System.out.println("ERROR: Already paid.");
       //System.out.println("[DEBUG] Entered coin() with value: " + f); // Debug 1
        
        DataStore ds = op.getDataStore();
        
        // Return all accumulated coins (use CF instead of f)
        if (ds instanceof DataStore1) {
            ((DataStore1)ds).setTemp_v(f); // For VM-1
        } 
        else if (ds instanceof DataStore2) {
            //((DataStore2)ds).setTemp_v(f); // For VM-2
        }
        
        ReturnCoins returnCoins = new ReturnCoins1();
        returnCoins.setDataStore(ds);
        returnCoins.ReturnCoins();

        // Debug output to verify values
        // if (ds instanceof DataStore1) {
        //     System.out.printf("[DEBUG] CF: %.2f, Temp_v: %.2f\n", 
        //                     ds.getFloatCf(), ds.getFloatTemp_v());
        // } else {
        //     System.out.printf("[DEBUG] CF: %d, Temp_v: %d\n",
        //                     ds.getIntCf(), ds.getIntTemp_v());
        // }
    }

    /**
     * Cancels the transaction:
     * - Increases cumulative fund for refund calculation
     * - Returns inserted coins
     * - Resets cumulative fund
     * - Transitions back to idle state
     */
    public void cancel() {
        // Get DataStore from OutputProcessor
        DataStore ds = op.getDataStore();
        
        // Return all accumulated coins (use CF instead of f)
        if (ds instanceof DataStore1) {
            ((DataStore1)ds).setTemp_v(ds.getFloatCf()); // For VM-1
        } 
        else if (ds instanceof DataStore2) {
            ((DataStore2)ds).setTemp_v(ds.getIntCf()); // For VM-2
        }
        System.out.println("Transaction cancelled.");
        
        ReturnCoins returnCoins = new ReturnCoins1();
        returnCoins.setDataStore(ds);
        returnCoins.ReturnCoins();

        op.ZeroCF();
        mda.ChangeState(2); // transition to idle
    }

    /**
     * Serves the selected drink along with the selected additives.
     * Updates cup count and transitions state accordingly.
     * @param d drink ID
     */
    public void dispose_drink(int d) {
        if (mda.k > 1) {
            op.DisposeDrink(d);
            op.DisposeAdditive(mda.A);
            mda.k = mda.k - 1;
            op.ZeroCF();
            System.out.println("\nRemaining cups: " + mda.k);
            mda.ChangeState(2); // remain in idle
        } else if (mda.k <= 1) {
            op.DisposeDrink(d);
            op.DisposeAdditive(mda.A);
            op.ZeroCF();
            System.out.println("\nNo cups remaining!");
            mda.ChangeState(1); // transition to no_cups
        }
    }

    /**
     * Toggles the specified additive.
     * @param a index of additive in the array
     */
    public void additive(int a) {
        if (mda.A[a] == 0) {
            mda.A[a] = 1; // select additive
            System.out.println("Additive added");
        } else {
            mda.A[a] = 0; // deselect additive
            System.out.println("Additive removed");
        }
    }

    public void create() {
        System.out.println("ERROR: Machine already created. Complete current transaction first.");
    }
    
    public void insert_cups(int n) {
        System.out.println("ERROR: Cannot insert cups during transaction. Cancel or complete first.");
    }
    
    public void set_price() {
        System.out.println("ERROR: Cannot change price during transaction. Cancel or complete first.");
    }
    
    public void card() {        
        System.out.printf("DECLINED: Transaction in progress.");
        System.out.println("\nPlease complete or cancel current transaction");
    }
}
