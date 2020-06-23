package wc;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import wc.mongo.MongoConn;

public class WordCountReducer  extends Reducer<Text, IntWritable, Text, IntWritable> {
	
	//MongoDB 데이터베이스
	MongoDatabase database = null;
	
	@Override
	protected void setup(Reducer<Text, IntWritable, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		
		//MongoDB 접속과 동시에 메모리에 올리기
		database = new MongoConn().getDatabase();
	}
	
	@Override
	public void reduce(Text key, Iterable<IntWritable> values, Context context)
				throws IOException, InterruptedException {
		int wordCount = 0;
		for (IntWritable value : values) {
			wordCount += value.get();
		}
		context.write(key, new IntWritable(wordCount));
		
		MongoCollection<Document> col = database.getCollection("MyTestCollection");
		
		Document doc = new Document();
		doc.append("word", key.toString());
		doc.append("cnt", wordCount);
		
		col.insertOne(doc);
		
		doc = null;
	}
	
	@Override
	protected void cleanup(Reducer<Text, IntWritable, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		
		// MongoDB 데이터베이스 객체 비우기
		database = null;
	}

}
