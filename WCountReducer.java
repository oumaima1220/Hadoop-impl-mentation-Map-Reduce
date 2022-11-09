package hadoop.wordcount;
import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class WCountReducer extends Reducer<Text, IntWritable, Text, Text> {
@Override
protected void reduce(Text key, Iterable<IntWritable> values,
    Reducer<Text, IntWritable, Text, Text>.Context context) 
throws IOException, InterruptedException {
int count = 0;
for (IntWritable value : values) {
count++;
}
context.write(key, new Text(count + " occurences"));
}
}

