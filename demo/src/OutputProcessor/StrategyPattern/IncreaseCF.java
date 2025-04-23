package OutputProcessor.StrategyPattern;

// Strategy Pattern: Interface for increasing cumulative funds (cf)

import DataStore.*;

/**
 * ------------------------------------------------------------
 * IncreaseCF.java (Strategy Interface)
 * ------------------------------------------------------------
 * Defines the interface for increasing the cumulative fund (cf)
 * as part of a payment transaction.
 *
 * This interface is implemented differently for VM-1 and VM-2
 * depending on whether the data type is float or int.
 */
public interface IncreaseCF {

    /**
     * Gets the associated DataStore.
     * @return the current DataStore object
     */
    public DataStore getDataStore();

    /**
     * Sets the associated DataStore.
     * @param ds the DataStore object to associate with this strategy
     */
    public void setDataStore(DataStore ds);

    /**
     * Increases the cumulative fund (cf) based on the temporary value.
     * The logic for handling the data type is implemented in concrete classes.
     */
    public void IncreaseCF();
}
