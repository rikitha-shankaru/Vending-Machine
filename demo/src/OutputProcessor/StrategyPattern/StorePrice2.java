package OutputProcessor.StrategyPattern;

import DataStore.*;

// Strategy Pattern: Concrete Strategy for VM-2 (int price)

/**
 * ------------------------------------------------------------
 * StorePrice2.java
 * ------------------------------------------------------------
 * Concrete implementation of the StorePrice strategy for
 * Vending Machine 2 (VM-2), which uses integer values to
 * represent and store the drink price.
 */
public class StorePrice2 implements StorePrice {

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
     * Stores the integer-based price from the temporary field
     * into the permanent price field in the DataStore.
     */
    @Override
    public void StorePrice() {
        int price = ds.getIntTemp_p();
        ds.setPrice(price);
        System.out.println("Price of item " + ds.getIntPrice());
    }
}
