package OutputProcessor.StrategyPattern;

import DataStore.*;

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
        return ds;
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
        System.out.println("Returning Coin/s Back");
        // Optional: System.out.println(ds.getIntCf());
    }
}
