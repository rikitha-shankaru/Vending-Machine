package OutputProcessor.StrategyPattern;

// Strategy Pattern: Concrete Strategy for VM-1

import DataStore.*;

/**
 * ------------------------------------------------------------
 * DisposeAdditive1.java
 * ------------------------------------------------------------
 * Concrete implementation of the DisposeAdditive strategy
 * for Vending Machine 1 (VM-1).
 *
 * In VM-1, additive ID 1 corresponds to Sugar.
 * This class checks the additive array and performs
 * output behavior accordingly.
 */
public class DisposeAdditive1 implements DisposeAdditive {

    private DataStore ds;

    /**
     * Disposes selected additives for VM-1.
     * Currently supports:
     * - array[1] == 1: Add sugar
     *
     * @param array an integer array where array[i] == 1 indicates additive i is selected
     */
    @Override
    public void DisposeAdditive(int[] array) {
        if (array[1] == 1) {
            System.out.println("Sugar Added");
        }
    }
}
