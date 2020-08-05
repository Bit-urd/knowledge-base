package com.biturd.mongo.primary;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BSON;
import org.bson.BSONObject;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Program: knowledge-base
 * @Description: MongoTest
 * @Author: BitterGourd
 * @Date: 2020-05-11 15:13
 */
public class MongoTest {
    public static String toHexString(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            int ch = (int) s.charAt(i);
            String s4 = Integer.toHexString(ch);
            str = str + s4;
        }
        return str;
    }
    public static void main(String[] args) {
        MongoClient client = new MongoClient("ubuntu");
        MongoDatabase testdb = client.getDatabase("test");
        MongoCollection<Document> persons = testdb.getCollection("person");
        Map<String,Object> insertData = new HashMap<>();
        insertData.put("generateTime", new Date());
        insertData.put("content", "123");
        persons.insertOne(new Document(insertData));
//        persons.insertOne(new Document("content","abc"));
//        BasicDBObject bson = new BasicDBObject("_id",new ObjectId(toHexString("5eb9057682ac2723009e55a1")));
        BasicDBObject bson = new BasicDBObject("content",new BasicDBObject("$ne","abc"));
        FindIterable<Document> documents = persons.find(bson);
        for (Document document : documents) {
            System.out.println("内容 =" + document.getString("content"));
            System.out.println("id =" + document.getObjectId("_id"));
            System.out.println("generateTime="+document.getDate("generateTime"));
        }
        client.close();
    }
}
