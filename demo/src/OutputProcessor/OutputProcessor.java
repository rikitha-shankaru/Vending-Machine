package OutputProcessor;

// Output Processor for MDA-EFSM using the Strategy Pattern

import AbstractFactory.*;
import DataStore.*;
import OutputProcessor.StrategyPattern.*;

/**
 * ------------------------------------------------------------
 * OutputProcessor.java
 * ------------------------------------------------------------
 * This class serves as the action executor for the MDA-EFSM.
 * It uses the Strategy Pattern to delegate tasks to interchangeable
 * behavior classes such as StorePrice, ReturnCoins, IncreaseCF, etc.
 *
 * These strategy objects are created using the AbstractFactory,
 * and are specific to the currently selected vending machine type.
 */
public class OutputProcessor {

    private DataStore ds;
    private AbstractFactory af;

    private StorePrice StorePrice;
    private ZeroCF ZeroCF;
    private ReturnCoins ReturnCoins;
    private IncreaseCF IncreaseCF;
    private DisposeDrink DisposeDrink;
    private DisposeAdditive DisposeAdditive;

    /**
     * Constructor that initializes all strategy objects from the AbstractFactory.
     * @param af AbstractFactory instance for selected vending machine
     * @param ds DataStore instance for storing platform-specific values
     */
    public OutputProcessor(AbstractFactory af, DataStore ds) {
        this.af = af;
        this.ds = ds;

        // Retrieve concrete strategy objects from Abstract Factory
        StorePrice = af.getStorePrice();
        ZeroCF = af.getZeroCf();
        ReturnCoins = af.getReturnCoins();
        IncreaseCF = af.getIncreaseCF();
        DisposeDrink = af.getDisposeDrink();
        DisposeAdditive = af.getDisposeAdditive();
    }

    /**
     * Executes the StorePrice strategy with the current DataStore.
     */
    public void StorePrice() {
        StorePrice.setDataStore(ds);
        StorePrice.StorePrice();
    }

    /**
     * Executes the ZeroCF strategy with the current DataStore.
     */
    public void ZeroCF() {
        ZeroCF.setDataStore(ds);
        ZeroCF.ZeroCF();
    }

    /**
     * Executes the ReturnCoins strategy.
     */
    public void ReturnCoins() {
        ReturnCoins.ReturnCoins();
    }

    /**
     * Executes the IncreaseCF strategy with the current DataStore.
     */
    public void IncreaseCF() {
        IncreaseCF.setDataStore(ds);
        IncreaseCF.IncreaseCF();
    }

    /**
     * Executes the DisposeDrink strategy.
     * @param d drink ID
     */
    public void DisposeDrink(int d) {
        DisposeDrink.DisposeDrink(d);
    }

    /**
     * Executes the DisposeAdditive strategy.
     * @param A integer array representing selected additives
     */
    public void DisposeAdditive(int[] A) {
        DisposeAdditive.DisposeAdditive(A);
    }

    // Getters and setters for DataStore and AbstractFactory

    public DataStore getDataStore() {
        return ds;
    }

    public void setDataStore(DataStore ds) {
        this.ds = ds;
    }

    public AbstractFactory getAbstractFactory() {
        return af;
    }

    public void setAbstractFactory(AbstractFactory af) {
        this.af = af;
    }
}
