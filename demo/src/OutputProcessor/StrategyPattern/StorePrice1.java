package OutputProcessor.StrategyPattern;

import DataStore.*;

// Strategy Pattern: Concrete Strategy for VM-1 (float price)

/**
 * ------------------------------------------------------------
 * StorePrice1.java
 * ------------------------------------------------------------
 * Concrete implementation of the StorePrice strategy for
 * Vending Machine 1 (VM-1), which uses float values to store
 * the drink price.
 */
public class StorePrice1 implements StorePrice {

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
     * Stores the float-based price from the temporary field
     * into the permanent price field in the DataStore.
     */
    @Override
    public void StorePrice() {
        float price = ds.getFloatTemp_p();
        ds.setPrice(price);
        System.out.println("Price of item " + ds.getFloatTemp_p());
    }
}
