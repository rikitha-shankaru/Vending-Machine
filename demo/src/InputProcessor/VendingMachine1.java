package InputProcessor;

// Input Processor for Vending Machine 1

import DataStore.*;
import MDAEFSM.*;
import AbstractFactory.AbstractFactory;

/**
 * ---------------------------------------------------------
 * VendingMachine1.java
 * ---------------------------------------------------------
 * This class serves as the Input Processor for Vending Machine 1 (VM-1).
 * It captures user operations and coordinates between the DataStore (VM-specific)
 * and the MDA-EFSM, allowing execution of actions such as payment, drink selection,
 * and additive handling.
 *
 * VM-1 supports two drinks: cappuccino and chocolate.
 * Additives: only sugar is available.
 * Currency values and balances are handled using float types.
 * 
 * This class follows the principle of separating input handling from internal logic.
 */

public class VendingMachine1 {

	private MDAEFSM mda;       // EFSM controller to manage state transitions
	private DataStore ds;      // Platform-specific data storage (float-based)
	AbstractFactory af;        // Abstract Factory to generate strategies and data store

	// Constructor to initialize EFSM controller and data store
	public VendingMachine1(MDAEFSM mda, DataStore ds) {
		this.mda = mda;
		this.ds = ds;
	}

	// Sets the Abstract Factory instance (optional if used elsewhere)
	public void setAf(AbstractFactory af) {
		this.af = af;
	}

	/**
	 * Creates the vending machine and stores the initial price temporarily.
	 * @param p the initial price to store
	 */
	public void create(float p) {
		ds.setTemp_p(p);
		mda.create();
	}

	/**
	 * Handles coin-based payment.
	 * If inserted value + current fund >= price, it triggers sufficient funds flow.
	 * Otherwise, insufficient fund flow is triggered.
	 * @param v the inserted coin value
	 */
	public void coin(float v) {
		ds.setTemp_v(v);
		if (ds.getFloatCf() + v >= ds.getFloatPrice()) {
			mda.coin(1); // sufficient funds
		} else {
			mda.coin(0); // insufficient funds
		}
	}

	/**
	 * Adds sugar as an additive to the current drink selection.
	 */
	public void sugar() {
		mda.additive(1); // 1 represents sugar
	}

	/**
	 * Disposes cappuccino.
	 */
	public void cappuccino() {
		mda.dispose_drink(1); // 1 represents cappuccino
	}

	/**
	 * Disposes chocolate.
	 */
	public void chocolate() {
		mda.dispose_drink(2); // 2 represents chocolate
	}

	/**
	 * Inserts cups into the machine.
	 * @param n number of cups to insert
	 */
	public void insert_cups(int n) {
		mda.insert_cups(n);
	}

	/**
	 * Updates the drink price by storing the new temporary price.
	 * @param p new price to be set
	 */
	public void set_price(float p) {
		ds.setTemp_p(p);
		mda.set_price();
	}

	/**
	 * Cancels the current transaction and returns any inserted coins.
	 */
	public void cancel() {
		mda.cancel();
	}

	/**
	 * Handles card-based payment.
	 * If the card balance is greater than or equal to price, proceed with payment.
	 * Otherwise, displays a decline message.
	 * @param x card balance or amount entered
	 */
	public void card(float x) {
		if (x >= ds.getFloatPrice()) {
			mda.card();
		}
		else
		{
			System.out.printf("DECLINED: $%.2f entered for $%.2f item.",
						x, ds.getFloatPrice());
			System.out.println("\nCard transaction failed. Please try again.");
		}
	}
}
