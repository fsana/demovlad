package server;

public class House {
    private String id;
    private String location;
    private String adminCompany;
    private Water water;
    private Waste waste;
    private double sharedElectricity;    

    // constructor
    public House(String id, String location, String adminCompany, Water water, Waste waste, double sharedElectricity) {
        this.id = id;
        this.location = location;
        this.adminCompany = adminCompany;
        this.waste = waste;
        this.water = water;
        this.sharedElectricity = sharedElectricity;
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


}
