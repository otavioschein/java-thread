package threads;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import database.services;
import entities.Car;

import java.util.List;
import java.util.concurrent.Callable;

public class CarTask implements Callable<String> {

    private List<Car> carList;
    private DBCollection carCollection;

    public CarTask(List carList, DBCollection carCollection) {
        this.carList = carList;
        this.carCollection = carCollection;
    }

    public String call() throws Exception {
        Thread.sleep(3000);
        carList.stream()
                .forEach(obj -> {
                    BasicDBObject document = new BasicDBObject();
                    document = services.getCarDocument(obj);
                    carCollection.insert(document);
                });
        return "Inserted a CAR";
    }
}
