package application;

import com.mongodb.*;
import database.services;
import entities.Bicycle;
import entities.Car;
import entities.Motorcycle;
import service.makeObj;
import threads.BicycleTask;
import threads.CarTask;
import threads.MotorcycleTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Main {

    // tranformar em springboot
    // threads com future
    // utilizar stream

    public static void main(String[] args) {
        List<Car> carList = makeObj.getCarList();
        List<Motorcycle> motorcycleList = makeObj.getMotorcycleList();
        List<Bicycle> bicycleList = makeObj.getBicycleList();

        List<String> results = new ArrayList<>();

        DB database = services.getDatabase();

        DBCollection carCollection = database.getCollection("cars");
        DBCollection motorcycleCollection = database.getCollection("motorcycles");
        DBCollection bicycleCollection = database.getCollection("bicycles");

        CarTask carTask = new CarTask(carList, carCollection);
        MotorcycleTask motorcycleTask = new MotorcycleTask(motorcycleList, motorcycleCollection);
        BicycleTask bicycleTask = new BicycleTask(bicycleList, bicycleCollection);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Future<String> futureCar = executorService.submit(carTask);
        Future<String> futureMotorcycle = executorService.submit(motorcycleTask);
        Future<String> futureBicycle = executorService.submit(bicycleTask);

        //completableFuture

        try{
            results.add(futureCar.get());
            results.add(futureMotorcycle.get());
            results.add(futureBicycle.get());
            results.stream()
                    .forEach(System.out::println);
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }



//        AtomicReference<BasicDBObject> document = new AtomicReference<>(new BasicDBObject());
//
//        Runnable carRunnable = new Runnable() {
//            @Override
//            public void run() {
//                carList.stream()
//                        .forEach(obj -> {
//                            document.set(services.getCarDocument(obj));
//                            carCollection.insert(document.get());
//                            System.out.println("Inserted a CAR");
//                        });
//            }
//        };
//
//
//
//        Runnable motorcycleRunnable = new Runnable() {
//            @Override
//            public void run() {
//                motorcycleList.stream()
//                        .forEach(obj -> {
//                            document.set(services.getMotorcycleDocument(obj));
//                            motorcycleCollection.insert(document.get());
//                            System.out.println("Inserted a MOTORCYCLE");
//                        });
//            }
//        };
//
//        Runnable bicycleRunnable = new Runnable() {
//            @Override
//            public void run() {
//                bicycleList.stream()
//                        .forEach(obj -> {
//                            document.set(services.getBicycleDocument(obj));
//                            bicycleCollection.insert(document.get());
//                            System.out.println("Inserted a BICYCLE");
//                        });
//            }
//        };
//
//        new Thread(carRunnable).start();
//        new Thread(motorcycleRunnable).start();
//        new Thread(bicycleRunnable).start();

    }

}
