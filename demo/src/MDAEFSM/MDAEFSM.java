package MDAEFSM;

// State Pattern: EFSM Controller

// This class is responsible for managing states and delegating method calls 
// to the current active state based on user input from the input processors.

import MDAEFSM.StatePattern.*;
import OutputProcessor.*;

/**
 * ------------------------------------------------------------
 * MDAEFSM.java
 * ------------------------------------------------------------
 * Main EFSM controller that maintains the current state and transitions
 * between states. This class acts as the context in the State Pattern.
 * All high-level vending machine operations are delegated to the current
 * active state object.
 *
 * This structure ensures extensibility and clean separation of behaviors.
 */
public class MDAEFSM {

	private State S;        // Current active state
	private State[] LS;     // State lookup table (start, no_cups, idle, coins_inserted)
	public int k = 0;       // Number of cups available
	public int[] A;         // Array to track additive selections

	/**
	 * Constructor initializes all concrete states and sets the initial state to 'start'.
	 * @param op reference to the OutputProcessor used by all states
	 */
	public MDAEFSM(OutputProcessor op) {
		LS = new State[4];

		LS[0] = new start(this, op);
		LS[1] = new no_cups(this, op);
		LS[2] = new idle(this, op);
		LS[3] = new coins_inserted(this, op);

		S = LS[0]; // Initial state: start

		// Initialize additives array (size - 3 for sugar/cream)
    	this.A = new int[3]; // Initialize with all 0s (no additives selected)
	}

	/**
	 * Changes the current active state.
	 * @param State index of the next state in LS
	 */
	public void ChangeState(int State) {
		S = LS[State];

		String stateName;
		switch(State) {
			case 0: stateName = "start"; break;
			case 1: stateName = "no_cups"; break;
			case 2: stateName = "idle"; break;
			case 3: stateName = "coins_inserted"; break;
			default: stateName = "unknown"; break;
		}
		System.out.println("State changed to: " + stateName);
	}

	// Delegated Operations — Each method calls the corresponding method in the current state

	/** Triggers creation/setup of the vending machine */
	public void create() {
		S.create();
	}

	/** Handles coin insertion and related transitions */
	public void coin(int f) {
		S.coin(f);
	}

	/** Inserts cups into the machine */
	public void insert_cups(int n) {
		S.insert_cups(n);
	}

	/** Processes card-based payment */
	public void card() {
		S.card();
	}

	/** Cancels the transaction */
	public void cancel() {
		S.cancel();
	}

	/** Updates the drink price */
	public void set_price() {
		S.set_price();
	}

	/** Disposes the selected drink */
	public void dispose_drink(int d) {
		S.dispose_drink(d);
	}

	/** Toggles or selects an additive */
	public void additive(int a) {
		S.additive(a);
	}
}
