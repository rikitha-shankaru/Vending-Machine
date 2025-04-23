package OutputProcessor.StrategyPattern;

import DataStore.*;

// Strategy Pattern: Concrete Strategy for VM-2

/**
 * ------------------------------------------------------------
 * DisposeDrink2.java
 * ------------------------------------------------------------
 * Concrete implementation of the DisposeDrink strategy
 * for Vending Machine 2 (VM-2).
 *
 * Drink ID mapping for VM-2:
 * - 1 → Coffee
 *
 * This class handles output behavior for disposing drinks.
 */
public class DisposeDrink2 implements DisposeDrink {

    /**
     * Disposes the appropriate drink based on the drink ID.
     * Currently supports:
     * - d == 1: Coffee
     *
     * @param d drink ID
     */
    @Override
    public void DisposeDrink(int d) {
        if (d == 1) {
            System.out.println("Dispose Coffee");
        }
    }
}
