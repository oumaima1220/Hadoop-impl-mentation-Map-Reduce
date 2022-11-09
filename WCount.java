package hadoop.wordcount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class WCount {
	
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		GenericOptionsParser parser = new GenericOptionsParser(conf, args);
		String[] ourArg = parser.getRemainingArgs();
		Job job =Job.getInstance(conf, "Compteur du mot v1.0");
		job.setJarByClass(WCount.class);
		job.setMapperClass(WCountMapper.class);
		job.setReducerClass(WCountReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		FileInputFormat.addInputPath(job, new Path(ourArg[0]));
		FileOutputFormat.setOutputPath(job, new Path(ourArg[1]));
		



	}


}
