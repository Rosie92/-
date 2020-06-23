package idf;



import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;




public class IdfDriver extends Configured implements Tool{
   public int run(String[] args) throws Exception {
       
          
         Job job = new Job(getConf());
         job.setJarByClass(IdfDriver.class);
         job.setJobName("IDF Driver");
         
         FileInputFormat.setInputPaths(job, new Path(args[0]));
         FileOutputFormat.setOutputPath(job, new Path(args[1]));
         
         job.setMapperClass(IdfMapper.class);
         job.setReducerClass(IdfReducer.class);
         
         job.setOutputKeyClass(Text.class);
         job.setOutputValueClass(Text.class);
         
         boolean success = job.waitForCompletion(true);
         return success ? 0 : 1;
      }
      
      public static void main(String[] args) throws Exception {
         int exitCode = ToolRunner.run(new Configuration(), new IdfDriver(),args);
         System.exit(exitCode);
      }
}