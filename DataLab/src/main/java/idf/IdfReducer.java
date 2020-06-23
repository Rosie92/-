package idf;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import wc.mongo.MongoConn;

public class IdfReducer extends Reducer<Text, Text, Text, DoubleWritable> {
   
   //MongoDB 데이터베이스
   MongoDatabase database = null;
   
   @Override
   protected void setup(Reducer<Text, Text, Text, DoubleWritable>.Context context)
      throws IOException, InterruptedException{
      
      // MongoDB 접속과 동시에 메모리 올리기
      database = new MongoConn().getDatabase();
   }
   @Override
   public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException{
      
      int totCnt = 0;
      
      Set<String> rSet = new HashSet<String>();
      
      for(Text value : values) {
         rSet.add(value.toString());
         totCnt++;
      }
      
      double docCnt = rSet.size();
      
      double idf = (totCnt / docCnt);
      
      context.write(key,  new DoubleWritable(idf));
      
      MongoCollection<Document> col = database.getCollection("IdfCol");
      
      Document doc = new Document();
      doc.append("word", key.toString());
      doc.append("idf", idf);
      
      col.insertOne(doc);
      
      doc = null;
   }

   @Override
   protected void cleanup(Reducer<Text, Text, Text, DoubleWritable>.Context context)
      throws IOException, InterruptedException{
      
      database = null;
   }
}