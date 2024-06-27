package server;

public class House {
    private String id;
    private String location;
    private String adminCompany;
    private Water water;
    private Waste waste;
    private double sharedElectricity; 
    private UnitPrices prices;   

    // constructor
    public House(String id, String location, String adminCompany, Water water, Waste waste, double sharedElectricity, UnitPrices prices) {
        this.id = id;
        this.location = location;
        this.adminCompany = adminCompany;
        this.waste = waste;
        this.water = water;
        this.sharedElectricity = sharedElectricity;
        this.prices = prices;
    }

    // getters and setters 
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAdminCompany() {
        return this.adminCompany;
    }

    public void setAdminCompany(String adminCompany) {
        this.adminCompany = adminCompany;
    }

    public Water getWater() {
        return this.water;
    }

    public void setWater(Water water) {
        this.water = water;
    }

    public Waste getWaste(){
        return this.waste;
    }

    public void setWaste(Waste waste) {
        this.waste = waste;
    }

    public double getSharedElectricity() {
        return sharedElectricity;
    }

    public void setSharedElectricity(double sharedElectricity) {
        this.sharedElectricity = sharedElectricity;
    }

    public UnitPrices getPrices() {
        return this.prices;
    }

    public void setPrices(UnitPrices prices) {
        this.prices = prices;
    }

    public double getTotalExpenses() {
        double result = water.getWaterInConsumption() * prices.getUpWaterIn();
        result += water.getWaterOutConsumption() * prices.getUpWaterOut();
        result += waste.getRecycledWasteGarbageWeight() * prices.getUpRecycledWaste();
        result += waste.getWasteGarbageWeight() * prices.getUpWaste();
        result += getSharedElectricity() * prices.getUpSharedElectricity();

        return result;
    }

    public String toString() {
        return "Id: " + getId() + ", Location: " + getLocation() + ", Expenses: " + getTotalExpenses();
     }

}
