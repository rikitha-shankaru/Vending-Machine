package OutputProcessor.StrategyPattern;

import DataStore.*;

// Strategy Pattern: Concrete Strategy for VM-2 (int-based funds)

/**
 * ------------------------------------------------------------
 * IncreaseCF2.java
 * ------------------------------------------------------------
 * Concrete implementation of the IncreaseCF strategy for
 * Vending Machine 2 (VM-2), which uses integer values to track
 * the cumulative funds (cf).
 */
public class IncreaseCF2 implements IncreaseCF {

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
     * Increases the cumulative fund by adding the temporary value.
     * This implementation works with integer values only.
     */
    @Override
    public void IncreaseCF() {
        int cf = ds.getIntCf();
        int v = ds.getIntTemp_v();
        int total = cf + v;
        ds.setCf(total);
        System.out.println("coins: " + ds.getIntCf());
    }
}
