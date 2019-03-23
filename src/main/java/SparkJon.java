import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.SparkSession;

@SuppressWarnings("unused")
public class SparkJon extends ShortcutsJon {
	
	static SparkSession getSS(String... appname) throws IOException {
//		Logger.getLogger("org").setLevel(Level.WARN);
//		Logger.getLogger("akka").setLevel(Level.WARN);
		SparkSession ss = SparkSession.builder().appName(appname.length > 0 ? appname[0] : "")
				.config("spark.master", "local").config("spark.eventlog.enabled","true")
				.config("spark.executor.cores", "2").getOrCreate();
//		ss.sparkContext().setLogLevel("WARN");
		FileUtils.deleteDirectory(new File("output"));
		return ss;
	}

	static JavaRDD<String> read(SparkSession ss, String file) {
		return ss.read().textFile(file).javaRDD();
	}
	
	static JavaRDD<String> read(String file) throws IOException {
		return getSS("").read().textFile(file).javaRDD();
	}
	
	static JavaRDD<String> read(String file, String appname) throws IOException {
		return getSS(appname).read().textFile(file).javaRDD();
	}
	
	static JavaRDD<String[]> readRegex(String file, String regex, String appname) throws IOException {
		return getSS(appname).read().textFile(file).javaRDD().map(x->x.split(regex));
	}
	
	static JavaRDD<String[]> read(SparkSession ss, String file, String regex) {
		return ss.read().textFile(file).javaRDD().map(ln->ln.split(regex));
	}
	
	/* DEEP COPY R */
	static List<Double> copy(List<Double> orig) {
		return IntStream.range(0, orig.size()).mapToDouble(x->orig.get(x)).boxed().collect(Collectors.toList());
	}
	

}
