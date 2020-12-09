package entities;

public class Car extends Vehicle {

    private boolean isOn;

    public Car(String name, String motorModel, String modality, int topSpeed, int time) {
        super(name, motorModel, modality, topSpeed, time);
        this.isOn = false;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public boolean turnOn() {
        return this.isOn = true;
    }

    public boolean turnOff() {
        return this.isOn = false;
    }

}
