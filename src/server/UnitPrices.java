package server;

public class UnitPrices {
    private double upWaterIn;
    private double upWaterOut;
    private double upRecycledWaste;
    private double upWaste;
    private double upSharedElectricity;

    // constructor
    public UnitPrices(double upWaterIn, double upWaterOut, double upRecycledWaste, double upWaste, double upSharedElectricity) {
        this.upWaterIn = upWaterIn;
        this.upWaterOut = upWaterOut;
        this.upRecycledWaste = upRecycledWaste;
        this.upWaste = upWaste;
        this.upSharedElectricity = upSharedElectricity;
    }

    // getters and setters
    public double getUpWaterIn() {
        return this.upWaterIn;
    }

    public void setUpWaterIn(double price) {
        this.upWaterIn = price;
    }

    public double getUpWaterOut() {
        return this.upWaterOut;
    }

    public void setUpWaterOut(double price) {
        this.upWaterOut = price;
    }

    public double getUpRecycledWaste() {
        return this.upRecycledWaste;
    }

    public void setUpRecycledWaste(double price) {
        this.upRecycledWaste = price;
    }

    public double getUpWaste() {
        return this.upWaste;
    }

    public void setUpWaste(double price) {
        this.upWaste = price;
    }
    
    public double getUpSharedElectricity() {
        return this.upSharedElectricity;
    }

    public void setUpSharedElectricity(double price) {
        this.upSharedElectricity = price;
    }

}
