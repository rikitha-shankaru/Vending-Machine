package MDAEFSM.StatePattern;

// State Pattern: This class represents the "coins_inserted" state

import MDAEFSM.*;
import OutputProcessor.*;

/**
 * ------------------------------------------------------------
 * coins_inserted.java
 * ------------------------------------------------------------
 * Part of the State Pattern implementation for the MDA-EFSM.
 * This class models the behavior of the system when the user
 * has inserted sufficient funds (via coins or card).
 *
 * Valid operations in this state:
 * - cancel(): cancel the transaction and refund
 * - coin(): reject additional coins and return them
 * - dispose_drink(): serve the selected drink
 * - additive(): toggle selected additives
 */
public class coins_inserted extends State {

    /**
     * Constructor to initialize references to EFSM and OutputProcessor.
     * @param mda Reference to the EFSM controller
     * @param op Reference to the OutputProcessor
     */
    public coins_inserted(MDAEFSM mda, OutputProcessor op) {
        this.mda = mda;
        this.op = op;
    }

    /**
     * If coin is inserted again in this state, return it.
     * This is to prevent overpayment.
     */
    public void coin(float f) {
        op.ReturnCoins();
    }

    /**
     * Cancels the transaction:
     * - Increases cumulative fund for refund calculation
     * - Returns inserted coins
     * - Resets cumulative fund
     * - Transitions back to idle state
     */
    public void cancel() {
        op.IncreaseCF();
        op.ReturnCoins();
        op.ZeroCF();
        mda.ChangeState(2); // transition to idle
    }

    /**
     * Serves the selected drink along with the selected additives.
     * Updates cup count and transitions state accordingly.
     * @param d drink ID
     */
    public void dispose_drink(int d) {
        if (mda.k > 1) {
            op.DisposeDrink(d);
            op.DisposeAdditive(mda.A);
            mda.k = mda.k - 1;
            op.ZeroCF();
            mda.ChangeState(2); // remain in idle
        } else if (mda.k <= 1) {
            op.DisposeDrink(d);
            op.DisposeAdditive(mda.A);
            op.ZeroCF();
            mda.ChangeState(1); // transition to no_cups
        }
    }

    /**
     * Toggles the specified additive.
     * @param a index of additive in the array
     */
    public void additive(int a) {
        if (mda.A[a] == 0) {
            mda.A[a] = 1; // select additive
        } else {
            mda.A[a] = 0; // deselect additive
        }
    }
}
