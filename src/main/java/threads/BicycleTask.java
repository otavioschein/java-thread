package threads;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import database.services;
import entities.Bicycle;

import java.util.List;
import java.util.concurrent.Callable;

public class BicycleTask implements Callable<String> {

    private List<Bicycle> bicycleList;
    private DBCollection bicycleCollection;

    public BicycleTask (List<Bicycle> bicycleList, DBCollection bibcycleCollection) {
        this.bicycleList = bicycleList;
        this.bicycleCollection = bibcycleCollection;
    }

    public String call() {
        bicycleList.stream()
                .forEach(obj -> {
                    BasicDBObject document = new BasicDBObject();
                    document = services.getBicycleDocument(obj);
                    bicycleCollection.insert(document);
                });
        return "Inserted a BICYCLE";
    }
}
