package application;

import com.mongodb.*;
import database.services;
import entities.Bicycle;
import entities.Car;
import entities.Motorcycle;
import service.makeObj;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;


public class Main {

    // tranformar em springboot
    // threads com future
    // utilizar stream

    public static void main(String[] args) {
        ArrayList<Car> carList = makeObj.getCarList();
        ArrayList<Motorcycle> motorcycleList = makeObj.getMotorcycleList();
        ArrayList<Bicycle> bicycleList = makeObj.getBicycleList();

        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB database = mongoClient.getDB("vehicles_db");

        DBCollection carCollection = database.getCollection("cars");
        DBCollection motorcycleCollection = database.getCollection("motorcycles");
        DBCollection bicycleCollection = database.getCollection("bicycles");


//        Runnable carRunnable = new Runnable(){
//            public void run() {
//                for (Car obj : carList) {
//                    BasicDBObject carDocument = new BasicDBObject();
//                    carDocument = services.getCarDocument(obj);
//                    carCollection.insert(carDocument);
//                    System.out.println("Inserted a CAR");
//                }
//            }
//        };

        AtomicReference<BasicDBObject> document = new AtomicReference<>(new BasicDBObject());

        Runnable carRunnable = new Runnable() {
            @Override
            public void run() {
                carList.stream()
                        .forEach(obj -> {
                            document.set(services.getCarDocument(obj));
                            carCollection.insert(document.get());
                            System.out.println("Inserted a CAR");
                        });

            }
        };

        Runnable motorcycleRunnable = new Runnable() {
            @Override
            public void run() {
                motorcycleList.stream()
                        .forEach(obj -> {
                            document.set(services.getMotorcycleDocument(obj));
                            motorcycleCollection.insert(document.get());
                            System.out.println("Inserted a MOTORCYCLE");
                        });
            }
        };

        Runnable bicycleRunnable = new Runnable() {
            @Override
            public void run() {
                bicycleList.stream()
                        .forEach(obj -> {
                            document.set(services.getBicycleDocument(obj));
                            bicycleCollection.insert(document.get());
                            System.out.println("Inserted a BICYCLE");
                        });
            }
        };

//        Runnable motorcycleRunnable = new Runnable() {
//            public void run() {
//                for (Motorcycle obj : motorcycleList) {
//                    BasicDBObject motorcycleDocument = new BasicDBObject();
//                    motorcycleDocument = services.getMotorcycleDocument(obj);
//                    motorcycleCollection.insert(motorcycleDocument);
//                    System.out.println("Inserted a MOTORCYCLE");
//                }
//            }
//        };

//        Runnable bicycleRunnable = new Runnable() {
//            public void run() {
//                for (Bicycle obj : bicycleList) {
//                    BasicDBObject bicycleDocument = new BasicDBObject();
//                    bicycleDocument = services.getBicycleDocument(obj);
//                    bicycleCollection.insert(bicycleDocument);
//                    System.out.println("Inserted a BICYCLE");
//                }
//            }
//        };

        new Thread(carRunnable).start();
        new Thread(motorcycleRunnable).start();
        new Thread(bicycleRunnable).start();

    }

}
