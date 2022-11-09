package hadoop.wordcount;
import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class WCountMapper extends Mapper<Object, Text, Text, 
	IntWritable> {
	private static final IntWritable ONE = new IntWritable(1);
	protected void map(Object key, Text value, Mapper<Object, Text, 
			Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
			String ourValue = value.toString();
			if (ourValue != null) {
			String[] words = ourValue.split(" ");
			for (String word : words) {
			Text currentWord = new Text(word);
			context.write(currentWord, ONE);
			}
			}
	}}



