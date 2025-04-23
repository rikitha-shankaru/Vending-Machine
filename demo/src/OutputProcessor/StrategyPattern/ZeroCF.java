package OutputProcessor.StrategyPattern;

// Strategy Pattern: Interface for zeroing cumulative funds (cf)

import DataStore.*;

/**
 * ------------------------------------------------------------
 * ZeroCF.java (Strategy Interface)
 * ------------------------------------------------------------
 * This interface defines the contract for resetting the
 * cumulative fund (cf) to zero. Different implementations
 * handle float or int data depending on the vending machine.
 */
public interface ZeroCF {

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
     * Resets the cumulative fund (cf) to zero.
     * Implementation varies depending on data type.
     */
    public void ZeroCF();
}
