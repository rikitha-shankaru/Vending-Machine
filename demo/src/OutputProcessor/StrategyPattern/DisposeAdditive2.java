package OutputProcessor.StrategyPattern;

// Strategy Pattern: Concrete Strategy for VM-2

import DataStore.*;

/**
 * ------------------------------------------------------------
 * DisposeAdditive2.java
 * ------------------------------------------------------------
 * Concrete implementation of the DisposeAdditive strategy
 * for Vending Machine 2 (VM-2).
 *
 * In VM-2:
 * - array[1] == 1 corresponds to Sugar
 * - array[2] == 1 corresponds to Cream
 *
 * This class handles the disposal of selected additives
 * based on the provided array of flags.
 */
public class DisposeAdditive2 implements DisposeAdditive {

    /**
     * Disposes selected additives for VM-2.
     * Prints output for each additive that is selected (value 1).
     *
     * @param array an integer array where array[i] == 1 indicates additive i is selected
     */
    @Override
    public void DisposeAdditive(int[] array) {
        if (array[1] == 1) {
            System.out.println("Sugar Added");
        }
        if (array[2] == 1) {
            System.out.println("Cream Added");
        }
    }
}
