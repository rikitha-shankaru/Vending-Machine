package DataStore;

/**
 * ---------------------------------------------------------
 * DataStore1.java
 * ---------------------------------------------------------
 * ⏹ Design Pattern Role: Concrete Product (Abstract Factory)
 *
 * This class provides the platform-specific implementation of
 * the DataStore for Vending Machine 1 (VM-1), which internally
 * uses `float` values for price, temp_p, temp_v, and cf.
 *
 * Although VM-1 conceptually uses integers, it stores values
 * in float fields for compatibility. Methods expecting `int`
 * return default placeholder values since they are not used.
 */
public class DataStore1 extends DataStore {

    private float Temp_p, Temp_v;  // Temporary storage for price and value
    private float cf;              // Cumulative funds
    private float price;           // Price of the selected drink

    // VM-1 does not use integer-based temp_p, returns default value
    @Override
    public int getIntTemp_p() {
        return 0;
    }

    // VM-1 does not use integer-based temp_p, no-op
    @Override
    public void setTemp_p(int p) {
        // Not applicable for VM-1
    }

    /**
     * @return temporary price (float)
     */
    @Override
    public float getFloatTemp_p() {
        return Temp_p;
    }

    /**
     * Sets temporary price (float)
     */
    @Override
    public void setTemp_p(float p) {
        this.Temp_p = p;
    }

    // VM-1 does not use integer-based temp_v, returns default value
    @Override
    public int getIntTemp_v() {
        return 0;
    }

    // VM-1 does not use integer-based temp_v, no-op
    @Override
    public void setTemp_v(int v) {
        // Not applicable for VM-1
    }

    /**
     * @return temporary value (float), such as coin/card input
     */
    @Override
    public float getFloatTemp_v() {
        return Temp_v;
    }

    /**
     * Sets temporary value (float)
     */
    @Override
    public void setTemp_v(float v) {
        Temp_v = v;
    }

    /**
     * @return current cumulative fund (cf)
     */
    @Override
    public float getFloatCf() {
        return cf;
    }

    /**
     * Sets cumulative fund using a float value
     */
    @Override
    public void setCf(float c) {
        cf = c;
    }

    /**
     * Sets cumulative fund using an int value (converted)
     */
    @Override
    public void setCf(int c) {
        cf = c;
    }

    // VM-1 does not use integer-based cf, returns default
    @Override
    public int getIntCf() {
        return 0;
    }

    /**
     * @return current drink price (float)
     */
    @Override
    public float getFloatPrice() {
        return price;
    }

    /**
     * Sets the drink price (float)
     */
    @Override
    public void setPrice(float p) {
        price = p;
    }

    // VM-1 does not use integer-based price, returns default
    @Override
    public int getIntPrice() {
        return 0;
    }

    // VM-1 does not use integer-based price, no-op
    @Override
    public void setPrice(int p) {
        // Not applicable for VM-1
    }
}
