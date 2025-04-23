package AbstractFactory;

import DataStore.*;
import OutputProcessor.StrategyPattern.*;

/**
 * -------------------------------------------------
 * Vending2Factory.java
 * -------------------------------------------------
 * ⏹ Design Pattern: Abstract Factory Pattern
 *
 * Concrete factory class for Vending Machine 2 (VM-2).
 * This factory produces all required platform-specific components
 * for VM-2, which works with floating-point (float) values.
 *
 * It supplies the correct DataStore and Strategy Pattern objects
 * to support VM-2 operations like price setting, fund handling,
 * additive and drink disposal, etc.
 */
public class Vending2Factory extends AbstractFactory {

    /**
     * Returns an instance of DataStore2, which supports float-based data.
     * @return DataStore2 object
     */
    @Override
    public DataStore getDataStore() {
        return new DataStore2();
    }

    /**
     * Returns the strategy implementation for storing float price.
     * @return StorePrice2 object
     */
    @Override
    public StorePrice getStorePrice() {
        return new StorePrice2();
    }

    /**
     * Returns the strategy implementation for resetting cumulative funds (cf) to 0.
     * (Same implementation as VM-1)
     * @return ZeroCF1 object
     */
    @Override
    public ZeroCF getZeroCf() {
        return new ZeroCF1();
    }

    /**
     * Returns the strategy for incrementing float-based cumulative funds.
     * @return IncreaseCF2 object
     */
    @Override
    public IncreaseCF getIncreaseCF() {
        return new IncreaseCF2();
    }

    /**
     * Returns the strategy for handling coin return.
     * @return ReturnCoins1 object
     */
    @Override
    public ReturnCoins getReturnCoins() {
        return new ReturnCoins1();
    }

    /**
     * Returns the drink disposal strategy implementation specific to VM-2.
     * @return DisposeDrink2 object
     */
    @Override
    public DisposeDrink getDisposeDrink() {
        return new DisposeDrink2();
    }

    /**
     * Returns the additive disposal strategy implementation specific to VM-2.
     * @return DisposeAdditive2 object
     */
    @Override
    public DisposeAdditive getDisposeAdditive() {
        return new DisposeAdditive2();
    }
}
