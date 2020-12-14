package database;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import entities.Bicycle;
import entities.Car;
import entities.Motorcycle;
import org.bson.types.ObjectId;

public class services {

    private static BasicDBObject carDocument = new BasicDBObject();
    private static BasicDBObject motorcycleDocument = new BasicDBObject();
    private static BasicDBObject bicycleDocument = new BasicDBObject();

    public static DB getDatabase() {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB database = mongoClient.getDB("vehicles_db");
        return database;
    }

    public static BasicDBObject getCarDocument(Car carObj) throws NullPointerException {
        carDocument.put("_id", ObjectId.get());
        carDocument.put("Name", carObj.getName());
        carDocument.put("Motor", carObj.getMotorModel());
        carDocument.put("Modality", carObj.getModality());
        carDocument.put("Acceleration", carObj.getAcceleration());
        carDocument.put("On", carObj.isOn());
        return carDocument;
    }

    public static BasicDBObject getMotorcycleDocument(Motorcycle motorcycleObj) throws NullPointerException {
        motorcycleDocument.put("_id", ObjectId.get());
        motorcycleDocument.put("Name", motorcycleObj.getName());
        motorcycleDocument.put("Motor", motorcycleObj.getMotorModel());
        motorcycleDocument.put("Modality", motorcycleObj.getModality());
        motorcycleDocument.put("Acceleration", motorcycleObj.getAcceleration());
        motorcycleDocument.put("Cylindres", motorcycleObj.getCylindres());
        return motorcycleDocument;
    }

    public static BasicDBObject getBicycleDocument(Bicycle bicycleObj) throws NullPointerException {
        bicycleDocument.put("_id", ObjectId.get());
        bicycleDocument.put("Name", bicycleObj.getName());
        bicycleDocument.put("Motor", bicycleObj.getMotorModel());
        bicycleDocument.put("Modality", bicycleObj.getModality());
        bicycleDocument.put("Acceleration", bicycleObj.getAcceleration());
        bicycleDocument.put("Rim", bicycleObj.getBikeRim());
        return bicycleDocument;
    }

}
