package entities;

public class Bicycle extends Vehicle {

    private float bikeRim;

    public Bicycle (String name, String motorModel, String modality, int topSpeed, int time, float bikeRim) {
        super(name, motorModel, modality, topSpeed, time);
        this.bikeRim = bikeRim;
    }

    public float getBikeRim() {
        return bikeRim;
    }

    public void setBikeRim(float bikeRim) {
        this.bikeRim = bikeRim;
    }
}
