package AbstractFactory;

// Abstract Factory Concrete Class for VM-1

import DataStore.*;
import OutputProcessor.StrategyPattern.*;

/**
 * -----------------------------------------------
 *  Vending1Factory.java
 * -----------------------------------------------
 * ⏹ Design Pattern: Abstract Factory Pattern
 *
 * Concrete factory class for Vending Machine 1 (VM-1).
 * Creates platform-specific DataStore and Strategy objects
 * appropriate for the VM-1 configuration (which uses integers).
 *
 * This factory provides the necessary component implementations
 * for VM-1 to interact with the EFSM and OutputProcessor layers.
 */
public class Vending1Factory extends AbstractFactory {

    /**
     * Returns an instance of DataStore1, used for integer-based storage.
     * @return DataStore1 object
     */
    @Override
    public DataStore getDataStore() {
        return new DataStore1();
    }

    /**
     * Returns the strategy implementation for storing integer price.
     * @return StorePrice1 object
     */
    @Override
    public StorePrice getStorePrice() {
        return new StorePrice1();
    }

    /**
     * Returns the strategy implementation for resetting cumulative funds (cf) to 0.
     * @return ZeroCF1 object
     */
    @Override
    public ZeroCF getZeroCf() {
        return new ZeroCF1();
    }

    /**
     * Returns the strategy implementation for incrementing integer-based cf.
     * @return IncreaseCF1 object
     */
    @Override
    public IncreaseCF getIncreaseCF() {
        return new IncreaseCF1();
    }

    /**
     * Returns the strategy for handling coin return operation.
     * @return ReturnCoins1 object
     */
    @Override
    public ReturnCoins getReturnCoins() {
        return new ReturnCoins1();
    }

    /**
     * Returns the drink disposal strategy implementation.
     * @return DisposeDrink1 object
     */
    @Override
    public DisposeDrink getDisposeDrink() {
        return new DisposeDrink1();
    }

    /**
     * Returns the additive disposal strategy implementation.
     * @return DisposeAdditive1 object
     */
    @Override
    public DisposeAdditive getDisposeAdditive() {
        return new DisposeAdditive1();
    }
}
