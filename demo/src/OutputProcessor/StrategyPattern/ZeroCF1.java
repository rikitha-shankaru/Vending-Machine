package OutputProcessor.StrategyPattern;

import DataStore.*;

// Strategy Pattern: Concrete Strategy for resetting cf (used in both VM-1 and VM-2)

/**
 * ------------------------------------------------------------
 * ZeroCF1.java
 * ------------------------------------------------------------
 * Concrete implementation of the ZeroCF strategy.
 * This class resets the cumulative fund (cf) to zero
 * in the associated DataStore.
 *
 * It is designed to work with both float and int-based
 * DataStore implementations (VM-1 and VM-2).
 */
public class ZeroCF1 implements ZeroCF {

    private DataStore ds;

    /**
     * Returns the associated DataStore instance.
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
     * Resets the cumulative fund (cf) to zero.
     * Uses overloaded setter method that works with both int and float types.
     */
    @Override
    public void ZeroCF() {
        ds.setCf(0);
        // Optional debug: System.out.println("CF set to 0");
    }
}
