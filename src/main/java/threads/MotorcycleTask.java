package threads;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import database.services;
import entities.Motorcycle;

import java.util.List;
import java.util.concurrent.Callable;

public class MotorcycleTask implements Callable<String> {

    private List<Motorcycle> motorcycleList;
    private DBCollection motorcycleCollection;

    public MotorcycleTask (List<Motorcycle> motorcycleList, DBCollection motorcycleCollection) {
        this.motorcycleList = motorcycleList;
        this.motorcycleCollection = motorcycleCollection;
    }

    public String call() {
        motorcycleList.stream()
                .forEach(obj -> {
                    BasicDBObject document = new BasicDBObject();
                    document = services.getMotorcycleDocument(obj);
                    motorcycleCollection.insert(document);
                });
        return "Inserted a MOTORCYCLE";
    }
}
