package AbstractFactory;

import DataStore.*;
import OutputProcessor.StrategyPattern.*;

/**
 * ------------------------------------------
 * AbstractFactory.java
 * ------------------------------------------
 * ⏹ Design Pattern: Abstract Factory Pattern
 * 
 * This abstract class defines a family of factory methods to produce related objects
 * without specifying their concrete classes. It acts as the superclass for concrete
 * factories like VM1Factory and VM2Factory.
 *
 * Purpose:
 * - To encapsulate the creation of related strategy objects and platform-specific data stores.
 * - Supports easy extension for multiple VM types.
 */
public abstract class AbstractFactory {

    /**
     * Creates and returns a platform-specific DataStore object.
     * @return a subclass of DataStore
     */
    public abstract DataStore getDataStore();

    /**
     * Creates and returns the StorePrice strategy object.
     * @return an implementation of StorePrice
     */
    public abstract StorePrice getStorePrice();

    /**
     * Creates and returns the ZeroCF strategy object.
     * @return an implementation of ZeroCF
     */
    public abstract ZeroCF getZeroCf();

    /**
     * Creates and returns the IncreaseCF strategy object.
     * @return an implementation of IncreaseCF
     */
    public abstract IncreaseCF getIncreaseCF();

    /**
     * Creates and returns the ReturnCoins strategy object.
     * @return an implementation of ReturnCoins
     */
    public abstract ReturnCoins getReturnCoins();

    /**
     * Creates and returns the DisposeDrink strategy object.
     * @return an implementation of DisposeDrink
     */
    public abstract DisposeDrink getDisposeDrink();

    /**
     * Creates and returns the DisposeAdditive strategy object.
     * @return an implementation of DisposeAdditive
     */
    public abstract DisposeAdditive getDisposeAdditive();
}
