package InputProcessor;

// Input Processor for Vending Machine 2

import DataStore.*;
import MDAEFSM.*;
import AbstractFactory.AbstractFactory;

/**
 * ---------------------------------------------------------
 * VendingMachine2.java
 * ---------------------------------------------------------
 * This class serves as the Input Processor for Vending Machine 2 (VM-2).
 * It acts as an interface between user commands and internal EFSM logic.
 *
 * VM-2 operates on integer-based values for price, coins, and cumulative funds.
 * It uses additive options like sugar and cream, and provides a coffee drink.
 */
public class VendingMachine2 {

	private MDAEFSM mda;
	private DataStore ds;
	AbstractFactory af;

	// Constructor to initialize EFSM and data store references
	public VendingMachine2(MDAEFSM mda, DataStore ds) {
		this.mda = mda;
		this.ds = ds;
	}

	// Sets the Abstract Factory instance (if needed externally)
	public void setAf(AbstractFactory af) {
		this.af = af;
	}

	/**
	 * Initializes the vending machine and sets the temporary price.
	 * @param p the price to store temporarily
	 */
	public void CREATE(int p) {
		ds.setTemp_p(p);
		mda.create();
	}

	/**
	 * Handles coin-based payment.
	 * If total funds (cf + coin) >= price, triggers sufficient funds flow.
	 * Otherwise, triggers insufficient funds flow.
	 * @param v the coin value inserted
	 */
	public void COIN(int v) {
		ds.setTemp_v(v);
		if (ds.getIntCf() + v >= ds.getIntPrice()) {
			mda.coin(1); // sufficient funds
		} else {
			mda.coin(0); // insufficient funds
		}
	}

	/**
	 * Adds sugar as an additive.
	 */
	public void SUGAR() {
		mda.additive(1); // 1 = sugar
	}

	/**
	 * Adds cream as an additive.
	 */
	public void CREAM() {
		mda.additive(2); // 2 = cream
	}

	/**
	 * Dispenses coffee.
	 */
	public void COFFEE() {
		mda.dispose_drink(1); // 1 = coffee
	}

	/**
	 * Inserts the specified number of cups into the machine.
	 * @param n number of cups to insert
	 */
	public void InsertCups(int n) {
		mda.insert_cups(n);
	}

	/**
	 * Updates the drink price using the provided value.
	 * @param p new price to set
	 */
	public void SetPrice(int p) {
		ds.setTemp_p(p);
		mda.set_price();
	}

	/**
	 * Cancels the current transaction and returns any inserted coins.
	 */
	public void CANCEL() {
		mda.cancel();
	}
}
