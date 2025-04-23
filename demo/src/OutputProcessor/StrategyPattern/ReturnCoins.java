package OutputProcessor.StrategyPattern;

// Strategy Pattern: Interface for returning inserted coins

import DataStore.*;

/**
 * ------------------------------------------------------------
 * ReturnCoins.java (Strategy Interface)
 * ------------------------------------------------------------
 * This interface defines the strategy for returning coins
 * when a transaction is canceled or cannot proceed.
 *
 * Different vending machines may implement this behavior
 * based on their data types and internal structure.
 */
public interface ReturnCoins {

    /**
     * Gets the associated DataStore instance.
     * @return DataStore object
     */
    public DataStore getDataStore();

    /**
     * Sets the associated DataStore instance.
     * @param ds DataStore object to associate
     */
    public void setDataStore(DataStore ds);

    /**
     * Returns the inserted coins.
     * Actual implementation may vary depending on the vending machine type.
     */
    public void ReturnCoins();
}
