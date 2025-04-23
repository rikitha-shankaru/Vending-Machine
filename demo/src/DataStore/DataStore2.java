package DataStore;

/**
 * ---------------------------------------------------------
 * DataStore2.java
 * ---------------------------------------------------------
 * ⏹ Design Pattern Role: Concrete Product (Abstract Factory)
 *
 * This class provides the platform-specific implementation of
 * the DataStore for Vending Machine 2 (VM-2), which uses `int`
 * values for price, coin/card input, and cumulative funds (cf).
 *
 * Methods related to float values are not used in VM-2 and return
 * default values or are left as no-ops.
 */
public class DataStore2 extends DataStore {

    private int Temp_p, Temp_v;   // Temporary price and value storage (integer)
    private int cf;               // Cumulative funds
    private int price;           // Price of the selected drink

    // -------- Temporary Price (temp_p) Handling --------

    /** @return temporary price (int) */
    @Override
    public int getIntTemp_p() {
        return Temp_p;
    }

    /** Sets temporary price (int) */
    @Override
    public void setTemp_p(int p) {
        this.Temp_p = p;
    }

    /** @return default value (not used in VM-2) */
    @Override
    public float getFloatTemp_p() {
        return 0;
    }

    /** No-op: not used in VM-2 */
    @Override
    public void setTemp_p(float p) {
        // Not applicable for VM-2
    }

    // -------- Temporary Value (temp_v) Handling --------

    /** @return temporary value (int), e.g., coin value */
    @Override
    public int getIntTemp_v() {
        return Temp_v;
    }

    /** Sets temporary value (int) */
    @Override
    public void setTemp_v(int v) {
        Temp_v = v;
    }

    /** @return default value (not used in VM-2) */
    @Override
    public float getFloatTemp_v() {
        return 0;
    }

    /** No-op: not used in VM-2 */
    @Override
    public void setTemp_v(float v) {
        // Not applicable for VM-2
    }

    // -------- Cumulative Fund (cf) Handling --------

    /** Sets cumulative fund using an int */
    @Override
    public void setCf(int c) {
        cf = c;
    }

    /** @return cumulative fund (int) */
    @Override
    public int getIntCf() {
        return cf;
    }

    /** @return default value (not used in VM-2) */
    @Override
    public float getFloatCf() {
        return 0;
    }

    /** No-op: not used in VM-2 */
    @Override
    public void setCf(float c) {
        // Not applicable for VM-2
    }

    // -------- Price Handling --------

    /** @return default value (not used in VM-2) */
    @Override
    public float getFloatPrice() {
        return 0;
    }

    /** No-op: not used in VM-2 */
    @Override
    public void setPrice(float p) {
        // Not applicable for VM-2
    }

    /** @return drink price (int) */
    @Override
    public int getIntPrice() {
        return price;
    }

    /** Sets drink price (int) */
    @Override
    public void setPrice(int p) {
        price = p;
    }
}
