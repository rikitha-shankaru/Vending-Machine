package OutputProcessor.StrategyPattern;

import DataStore.*;

// Strategy Pattern: Concrete Strategy for VM-1

/**
 * ------------------------------------------------------------
 * DisposeDrink1.java
 * ------------------------------------------------------------
 * Concrete implementation of the DisposeDrink strategy
 * for Vending Machine 1 (VM-1).
 *
 * Drink ID mappings for VM-1:
 * - 1 → Cappuccino
 * - 2 → Chocolate
 *
 * This class handles the disposal output for each drink.
 */
public class DisposeDrink1 implements DisposeDrink {

    /**
     * Disposes the appropriate drink based on the drink ID.
     * @param d drink ID
     */
    @Override
    public void DisposeDrink(int d) {
        if (d == 1) {
            System.out.print("Dispose Cappuccino");
        } else if (d == 2) {
            System.out.print("Dispose Chocolate");
        }
    }
}
