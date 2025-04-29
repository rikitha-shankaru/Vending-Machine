package OutputProcessor.StrategyPattern;

import DataStore.*;
import DataStore.DataStore1;
import DataStore.DataStore2;

// Strategy Pattern: Concrete Strategy for returning coins (shared by VM-1 and VM-2)

/**
 * ------------------------------------------------------------
 * ReturnCoins1.java
 * ------------------------------------------------------------
 * Concrete implementation of the ReturnCoins strategy
 * for both Vending Machine 1 and Vending Machine 2.
 *
 * This class performs a simple operation: printing a message
 * to indicate that inserted coins are being returned.
 * No calculations are performed here.
 */
public class ReturnCoins1 implements ReturnCoins {

    private DataStore ds;

    /**
     * Gets the associated DataStore instance.
     * @return DataStore object
     */
    @Override
    public DataStore getDataStore() {
        return this.ds;
    }

    /**
     * Sets the associated DataStore instance.
     * @param ds DataStore object to associate
     */
    @Override
    public void setDataStore(DataStore ds) {
        this.ds = ds;
    }

    /**
     * Executes the action of returning inserted coins.
     * Currently implemented as a print statement only.
     */
    @Override
    public void ReturnCoins() {
        if (ds == null) {
            System.out.println("ERROR: DataStore not set in ReturnCoins1!");
            return;
        }

        /**
         * VM-1 Implementation (float-based):
         * - Retrieves coin value as float from DataStore1
         * - Resets the temporary value storage after return
         */

        //System.out.println("[DEBUG] Current DataStore: " + ds.getClass().getSimpleName());

        if (ds instanceof DataStore1) {
            DataStore1 ds1 = (DataStore1)ds;
            System.out.printf("Returning %.2f Coin(s) Back%n", ds1.getFloatTemp_v());
            ds1.setTemp_v(0.0f); // Use float literal
        } 
        /**
         * VM-2 Implementation (int-based):
         * - Retrieves coin value as integer from DataStore2
         * - Resets the temporary value storage after return
         */
        else if (ds instanceof DataStore2) {
            DataStore2 ds2 = (DataStore2)ds;
            System.out.println("Returning " + ds2.getIntTemp_v() + " Coin(s) Back");
            ds2.setTemp_v(0); // Use int
        }
        else {
            System.out.println("ERROR: Unknown DataStore type");
        }
    }
}
