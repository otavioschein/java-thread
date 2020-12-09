package entities;

public class Motorcycle extends Vehicle {

    private String cylindres;

    public Motorcycle(String name, String motorModel, String modality, int topSpeed, int time, String cylindres) {
        super(name, motorModel, modality, topSpeed, time);
        this.cylindres = cylindres;
    }

    public String getCylindres() {
        return cylindres;
    }

    public void setCylindres(String cylindres) {
        this.cylindres = cylindres;
    }
}
