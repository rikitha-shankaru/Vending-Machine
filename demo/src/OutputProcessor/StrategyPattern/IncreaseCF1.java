package OutputProcessor.StrategyPattern;

import DataStore.*;

// Strategy Pattern: Concrete Strategy for VM-1 (float-based funds)

/**
 * ------------------------------------------------------------
 * IncreaseCF1.java
 * ------------------------------------------------------------
 * Concrete implementation of the IncreaseCF strategy for
 * Vending Machine 1 (VM-1), which uses float values to track
 * the cumulative funds (cf).
 */
public class IncreaseCF1 implements IncreaseCF {

    private DataStore ds;

    /**
     * Returns the associated DataStore object.
     * @return DataStore instance
     */
    @Override
    public DataStore getDataStore() {
        return ds;
    }

    /**
     * Sets the associated DataStore object.
     * @param ds DataStore instance to use
     */
    @Override
    public void setDataStore(DataStore ds) {
        this.ds = ds;
    }

    /**
     * Increases the cumulative fund by adding the temporary value.
     * This implementation assumes float-based cf and temp_v.
     */
    @Override
    public void IncreaseCF() {
        float cf = ds.getFloatCf();
        float v = ds.getFloatTemp_v();
        float total = cf + v;
        ds.setCf(total);
        System.out.printf("Total coins: %.2f%n", ds.getFloatCf());
    }
}
