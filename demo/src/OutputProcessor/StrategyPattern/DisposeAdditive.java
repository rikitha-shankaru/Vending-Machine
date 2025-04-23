package OutputProcessor.StrategyPattern;

// Strategy Pattern: Interface for additive disposal behavior

import DataStore.*;

/**
 * ------------------------------------------------------------
 * DisposeAdditive.java (Strategy Interface)
 * ------------------------------------------------------------
 * Part of the Strategy Pattern implementation.
 *
 * This interface defines the contract for disposing additives
 * (e.g., sugar, cream) based on a selection array. Each concrete
 * implementation will define the specific disposal behavior
 * appropriate for a particular vending machine type.
 */
public interface DisposeAdditive {

    /**
     * Disposes selected additives based on the input array.
     * Each index in the array corresponds to an additive.
     * A value of 1 indicates that the additive should be disposed.
     *
     * @param array an integer array representing selected additives
     */
    public void DisposeAdditive(int[] array);
}
