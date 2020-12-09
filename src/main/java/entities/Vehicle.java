package entities;

public class Vehicle {

    private String name;
    private String motorModel;
    private String modality;
    private int topSpeed;
    private float acceleration;
    private int time;

    public Vehicle(String name, String motorModel, String modality, int topSpeed, int time) {
        this.name = name;
        this.motorModel = motorModel;
        this.modality = modality;
        this.topSpeed = topSpeed;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMotorModel() {
        return motorModel;
    }

    public void setMotorModel(String motorModel) {
        this.motorModel = motorModel;
    }

    public String getModality() {
        return modality;
    }

    public void setModality(String modality) {
        this.modality = modality;
    }

    public float getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public float getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(float topSpeed, float time) {
        this.acceleration = topSpeed/time;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

}
