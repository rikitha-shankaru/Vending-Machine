package DataStore;

/**
 * -----------------------------------------------------
 * DataStore.java (Abstract Class)
 * -----------------------------------------------------
 * ⏹ Design Pattern Role: Base class used by Abstract Factory
 *
 * This abstract class defines a flexible data model to store
 * platform-dependent variables used by different vending machine types.
 * 
 * Both VM-1 (int-based) and VM-2 (float-based) data stores extend this class
 * and override methods based on their data format needs.
 */
public abstract class DataStore {

    // ------- Temporary Price (temp_p) Getters & Setters -------

    /** @return the temporary price as an integer (used in VM-1) */
    public abstract int getIntTemp_p();

    /** Sets the temporary price (int). Used for VM-1 */
    public abstract void setTemp_p(int p);

    /** @return the temporary price as a float (used in VM-2) */
    public abstract float getFloatTemp_p();

    /** Sets the temporary price (float). Used for VM-2 */
    public abstract void setTemp_p(float p);

    // ------- Temporary Value (temp_v) Getters & Setters -------

    /** @return the temporary value (e.g., coin) as an int */
    public abstract int getIntTemp_v();

    /** Sets the temporary value as an int (used in VM-1) */
    public abstract void setTemp_v(int v);

    /** @return the temporary value as a float */
    public abstract float getFloatTemp_v();

    /** Sets the temporary value as a float (used in VM-2) */
    public abstract void setTemp_v(float v);

    // ------- Cumulative Fund (cf) Getters & Setters -------

    /** @return the cumulative fund (cf) as a float */
    public abstract float getFloatCf();

    /** Sets the cumulative fund (cf) as a float */
    public abstract void setCf(float c);

    /** Sets the cumulative fund (cf) as an int */
    public abstract void setCf(int c);

    /** @return the cumulative fund (cf) as an int */
    public abstract int getIntCf();

    // ------- Price Getters & Setters -------

    /** @return the price as a float */
    public abstract float getFloatPrice();

    /** Sets the price as a float */
    public abstract void setPrice(float p);

    /** @return the price as an int */
    public abstract int getIntPrice();

    /** Sets the price as an int */
    public abstract void setPrice(int p);
}
