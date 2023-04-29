
package quiz.application;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author heman
 */
public class DbConnectivity {
    
    DbConnectivity(String name,String option,int score){
        // connecting string
        String uri="mongodb+srv://bonalahit21:mintu123@quizapplication.brlfdta.mongodb.net/?retryWrites=true&w=majority";
        MongoCollection<Document> collection;
      try{
        MongoClient mongoclient = MongoClients.create(uri);
        MongoDatabase mongodb=mongoclient.getDatabase("QuizApplication");
        try{
        collection =mongodb.getCollection("test");
        }
        catch(Exception e){
            mongodb.createCollection("test");
            collection =mongodb.getCollection("test");
        }
        LocalDateTime curr=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy/mm/dd HH:mm:ss");
        Document data=new Document("name",name);
        data.append("Topic",option);
        data.append("Score",score);
        data.append("Time of submission ",dtf.format(curr));
        collection.insertOne(data);
    }
    
    catch(Exception e){
    System.out.println("Data is not inserted into Database check for internet connectivity ");
}
    }


}
