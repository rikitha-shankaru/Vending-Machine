package OutputProcessor.StrategyPattern;

// Strategy Pattern: Interface for drink disposal behavior

import DataStore.*;

/**
 * ------------------------------------------------------------
 * DisposeDrink.java (Strategy Interface)
 * ------------------------------------------------------------
 * Defines the interface for the DisposeDrink strategy in the
 * Strategy Pattern.
 *
 * Each concrete implementation will define how drinks are
 * disposed depending on the vending machine's configuration.
 */
public interface DisposeDrink {

    /**
     * Disposes the drink based on the drink ID.
     * The mapping between IDs and drinks is defined in the
     * concrete strategy classes.
     *
     * @param d the ID of the selected drink
     */
    public void DisposeDrink(int d);
}
