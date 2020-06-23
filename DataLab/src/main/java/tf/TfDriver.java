package tf;

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


public class TfDriver extends Configured implements Tool {
   
   public int run(String[] args) throws Exception {
      
      
      Job job = new Job(getConf());
      job.setJarByClass(TfDriver.class);
      job.setJobName("TfDriver");
      
      FileInputFormat.setInputPaths(job, new Path(args[0]));
      FileOutputFormat.setOutputPath(job, new Path(args[1]));
      
      job.setMapperClass(TfMapper.class);
      job.setReducerClass(TfReducer.class);
      
      job.setOutputKeyClass(Text.class);
      job.setOutputValueClass(IntWritable.class);
      
      boolean success = job.waitForCompletion(true);
      return success ? 0 : 1;
      
   }
   
   public static void main(String[] args) throws Exception {
      int exitCode = ToolRunner.run(new Configuration(), new TfDriver(), args);
      System.exit(exitCode);
   }

}