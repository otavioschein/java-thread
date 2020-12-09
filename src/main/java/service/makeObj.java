package service;

import entities.Bicycle;
import entities.Car;
import entities.Motorcycle;

import java.util.ArrayList;

public class makeObj {

    public static ArrayList<Car> getCarList() {
        ArrayList<Car> carList = new ArrayList<>();
        Car carObj1 = new Car("Uno", "InLine 1.0", "Casual", 150, 10);
        carObj1.setAcceleration(carObj1.getTopSpeed(), carObj1.getTime());
        Car carObj2 = new Car("Mustang", "V10 4.0", "Sporting", 300, 12);
        carObj2.setAcceleration(carObj2.getTopSpeed(), carObj2.getTime());
        Car carObj3 = new Car("Porsche", "V6 3.0", "Sporting", 330, 11);
        carObj3.setAcceleration(carObj3.getTopSpeed(), carObj3.getTime());
        Car carObj4 = new Car("Mclaren Senna", "V8 4.0", "Sporting", 300, 17);
        carObj4.setAcceleration(carObj4.getTopSpeed(), carObj4.getTime());
        Car carObj5 = new Car("Fusca", "Box Engine 1.3", "Casual", 140, 25);
        carObj5.setAcceleration(carObj5.getTopSpeed(), carObj5.getTime());

        carList.add(carObj1);
        carList.add(carObj2);
        carList.add(carObj3);
        carList.add(carObj4);
        carList.add(carObj5);

        return carList;
    }

    public static ArrayList<Motorcycle> getMotorcycleList() {
        ArrayList<Motorcycle> motorcycleList = new ArrayList<>();
        Motorcycle motorcycleObj1 = new Motorcycle("xj6", "Combustion", "sporting", 217, 8, "600");
        motorcycleObj1.setAcceleration(motorcycleObj1.getTopSpeed(), motorcycleObj1.getTime());
        Motorcycle motorcycleObj2 = new Motorcycle("CBR 650R", "Combustion", "sporting", 227, 8, "650");
        motorcycleObj2.setAcceleration(motorcycleObj2.getTopSpeed(), motorcycleObj2.getTime());
        Motorcycle motorcycleObj3 = new Motorcycle("R3 Monster", "Combustion", "sporting", 200, 10, "310");
        motorcycleObj3.setAcceleration(motorcycleObj3.getTopSpeed(), motorcycleObj3.getTime());
        Motorcycle motorcycleObj4 = new Motorcycle("Harley Iron 883", "Combustion", "Trip", 180, 10, "883");
        motorcycleObj4.setAcceleration(motorcycleObj4.getTopSpeed(), motorcycleObj4.getTime());
        Motorcycle motorcycleObj5 = new Motorcycle("CB 300", "Combustion", "Casual", 180, 10, "291");
        motorcycleObj5.setAcceleration(motorcycleObj5.getTopSpeed(), motorcycleObj5.getTime());

        motorcycleList.add(motorcycleObj1);
        motorcycleList.add(motorcycleObj2);
        motorcycleList.add(motorcycleObj3);
        motorcycleList.add(motorcycleObj4);
        motorcycleList.add(motorcycleObj5);

        return motorcycleList;
    }

    public static ArrayList<Bicycle> getBicycleList() {
        ArrayList<Bicycle> bicycleList = new ArrayList<>();

        Bicycle bicycleObj1 = new Bicycle("Santa Cruz V10", "human-power", "Downhill", 39, 7, (float) 26);
        bicycleObj1.setAcceleration(bicycleObj1.getTopSpeed(), bicycleObj1.getTime());
        Bicycle bicycleObj2 = new Bicycle("Trek Session 9.9", "human-power", "Downhill", 47, 7, (float) 26);
        bicycleObj2.setAcceleration(bicycleObj2.getTopSpeed(), bicycleObj2.getTime());
        Bicycle bicycleObj3 = new Bicycle("Canyon Sender CF 8.0", "human-power", "Downhill", 44, 7, (float) 26);
        bicycleObj3.setAcceleration(bicycleObj3.getTopSpeed(), bicycleObj3.getTime());
        Bicycle bicycleObj4 = new Bicycle("Scott Gambler 710", "human-power", "Downhill", 42, 7, (float) 26);
        bicycleObj4.setAcceleration(bicycleObj4.getTopSpeed(), bicycleObj4.getTime());
        Bicycle bicycleObj5 = new Bicycle("YT Tues CF Pro", "human-power", "Downhill", 48, 7, (float) 26);
        bicycleObj5.setAcceleration(bicycleObj5.getTopSpeed(), bicycleObj5.getTime());

        bicycleList.add(bicycleObj1);
        bicycleList.add(bicycleObj2);
        bicycleList.add(bicycleObj3);
        bicycleList.add(bicycleObj4);
        bicycleList.add(bicycleObj5);

        return bicycleList;
    }

}
