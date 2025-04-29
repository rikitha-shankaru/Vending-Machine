package MDAEFSM.StatePattern;

// State Pattern: This class represents the "idle" state

import MDAEFSM.*;
import OutputProcessor.*;
import DataStore.*;
import DataStore.DataStore1;
import DataStore.DataStore2;

/**
 * ------------------------------------------------------------
 * idle.java
 * ------------------------------------------------------------
 * Represents the "idle" state in the MDA-EFSM state machine.
 * This state occurs after cups have been inserted, but before
 * a drink has been selected or sufficient funds have been provided.
 *
 * Valid transitions from this state include inserting more cups,
 * updating the drink price, or inserting coins/card to proceed to
 * drink selection.
 */
public class idle extends State {

    /**
     * Constructor to initialize EFSM and OutputProcessor references.
     * @param mda Reference to the EFSM controller
     * @param op Reference to the OutputProcessor
     */
    public idle(MDAEFSM mda, OutputProcessor op) {
        this.mda = mda;
        this.op = op;
    }

    /**
     * Stores the drink price using the OutputProcessor.
     */
    public void set_price() {
        op.StorePrice();
        DataStore ds = op.getDataStore();
    
        // VM-1 (float) implementation
        if (ds instanceof DataStore1) {
            float currentCF = ds.getFloatCf();
            float newPrice = ds.getFloatPrice();
            
            if (currentCF >= newPrice) {
                mda.ChangeState(3);
                System.out.println("Sufficient funds. Please select your drink.");
            } else {
                System.out.printf("Price updated to $%.2f. Current funds: $%.2f%n", 
                            newPrice, currentCF);
            }
        } 
        // VM-2 (int) implementation
        else if (ds instanceof DataStore2) {
            int currentCF = ds.getIntCf();
            int newPrice = ds.getIntPrice();
            
            if (currentCF >= newPrice) {
                mda.ChangeState(3);
                System.out.println("Sufficient funds. Please select your drink.");
            } else {
                System.out.printf("Price updated to %d¢. Current funds: %d¢%n", 
                            newPrice, currentCF);
            }
        }
    }

    /**
     * Adds the specified number of cups to the machine.
     * Remains in the idle state.
     * @param n number of cups to insert
     */
    public void insert_cups(int n) {
        if (n > 0) {
            mda.k = mda.k + n;
            System.out.println(n + " cup(s) added. Total cups: " + mda.k);
        } else {
            System.out.println("ERROR: Must insert at least 1 cup");
        }
    }

    /**
     * Handles card-based payment.
     * Resets cumulative funds and transitions to coins_inserted state.
     */
    public void card() {
        op.ZeroCF();
        mda.A = new int[5]; // reset additive selection
        System.out.println("Card payment accepted. Ready to select drink.");
        mda.ChangeState(3); // transition to coins_inserted
    }

    /**
     * Handles coin-based payment.
     * If sufficient funds (f == 1), moves to coins_inserted state.
     * Otherwise, just increases cf and stays in idle.
     * @param f flag indicating sufficient (1) or insufficient (0) funds
     */
    public void coin(int f) {
        if (f == 1) {
            op.IncreaseCF();
            mda.A = new int[5]; // reset additive selection
            mda.ChangeState(3); // transition to coins_inserted
        } else if (f == 0) {
            op.IncreaseCF();
        }
    }

    public void create() {
        System.out.println("ERROR: Machine already created.");
    }
    
    public void cancel() {
        System.out.println("ERROR: No transaction to cancel in idle state.");
    }
    
    public void dispose_drink(int d) {
        System.out.println("ERROR: Insert coins/card first before selecting drink.");
    }
    
    public void additive(int a) {
        System.out.println("ERROR: Select drink first before adding additives.");
    }
}
