package server;

public class Water {
    private double waterInConsumption;
    private double waterOutConsumption;

    // constructor
    public Water(double waterInConsumption, double waterOutConsumption) {
        this.waterInConsumption = waterInConsumption;
        this.waterOutConsumption = waterInConsumption;
    }

    // getters and setters
    public double getWaterInConsumption() {
        return this.waterInConsumption;
    }

    public void setWaterInConsumption(double consumption) {
        this.waterInConsumption = consumption;
    }

    public double getWaterOutConsumption() {
        return this.waterOutConsumption;
    }

    public void setWaterOutConsumption(double consumption) {
        this.waterOutConsumption = consumption;
    }
}