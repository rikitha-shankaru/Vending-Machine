package OutputProcessor.StrategyPattern;

// Strategy Pattern: Interface for storing price configuration

import DataStore.*;

/**
 * ------------------------------------------------------------
 * StorePrice.java (Strategy Interface)
 * ------------------------------------------------------------
 * This interface defines the strategy for storing the price
 * of a drink in the vending machine. The logic for storing
 * prices differs between VM-1 and VM-2 based on data types.
 *
 * This interface is implemented by:
 * - StorePrice1 (for int prices - VM-2)
 * - StorePrice2 (for float prices - VM-1)
 */
public interface StorePrice {

    /**
     * Gets the associated DataStore.
     * @return DataStore object
     */
    public DataStore getDataStore();

    /**
     * Sets the associated DataStore.
     * @param ds DataStore object to associate
     */
    public void setDataStore(DataStore ds);

    /**
     * Stores the price from the temporary value field to the actual price field.
     * Implementation is data-type specific (float for VM-1, int for VM-2).
     */
    public void StorePrice();
}
