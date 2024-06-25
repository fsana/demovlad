package server;

public class Waste {
    private double recycledWasteGarbageWeight;
    private double wasteGarbageWeight;

    // constructor
    public Waste(double recycledWasteGarbageWeight, double wasteGarbageWeight) {
        this.recycledWasteGarbageWeight = recycledWasteGarbageWeight;
        this.wasteGarbageWeight = wasteGarbageWeight;
    }

    // getters and setters
    public double getRecycledWasteGarbageWeight() {
        return this.recycledWasteGarbageWeight;
    }

    public void setRecycledWasteGarbageWeight(double weight) {
        this.recycledWasteGarbageWeight = weight;
    }

    public double getWasteGarbageWeight() {
        return this.wasteGarbageWeight;
    }

    public void setWasteGarbageWeight(double weight) {
        this.wasteGarbageWeight = weight;
    } 

}
