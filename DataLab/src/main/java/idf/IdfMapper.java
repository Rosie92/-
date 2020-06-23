package idf;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

public class IdfMapper extends Mapper<LongWritable, Text, Text, Text>{
   
   @Override
   public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException{
      
      FileSplit fileSplit = (FileSplit) context.getInputSplit();
      Path path = fileSplit.getPath();
      
      Text location = new Text(path.getName());
      
      String line = value.toString();
      
      for(String word : line.split("\\W+")){
         if(word.length() > 0){
            context.write(new Text(word), location);
         }
      }
   }
}