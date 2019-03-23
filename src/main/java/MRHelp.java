import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;

public class MRHelp extends Configured {
	
	static void clearOutput(Configuration conf) throws IllegalArgumentException, IOException {
		List<String> outDirs = Files.list(Paths.get("")).map(x->x.toString()).filter(x->x.startsWith("output")).collect(Collectors.toList());
		for(String folder : outDirs)
			new Path(folder).getFileSystem(conf).delete(new Path(folder), true);
	}
	
	static void combineOutputs(Configuration conf, String outDirPrefix) throws IOException {
		List<String> outputStringsList = new ArrayList<>();
		List<String> outDirs = getFilesStartingWithInDir(outDirPrefix, ".");
		for(String outFolder : outDirs) {
			outputStringsList.add(getCombinedOutputsInFolderAsString(conf, outFolder));
			new Path(outFolder).getFileSystem(conf).delete(new Path(outFolder), true);
		}
		String output = outputStringsList.stream().collect(Collectors.joining("\n"));
		FileUtils.writeStringToFile(new File(outDirPrefix + File.separator + "outAll6.txt"), output, "UTF-8", true);
	}

	static String getCombinedOutputsInFolderAsString(Configuration conf, String outFolder) throws IOException {
		Collection<File> out_parts = FileUtils.listFiles(new File(outFolder), new WildcardFileFilter("part*"), null);
		List<String> out_lines = new ArrayList<>();
		for(File file: out_parts)
			out_lines.addAll(FileUtils.readLines(file, "UTF-8"));
		Collections.sort(out_lines);
		return outFolder + "\n\t" + out_lines.stream().collect(Collectors.joining("\n\t"));
	}
	
	static List<String> getFilesStartingWithInDir(String start, String dir) throws IOException {
		List<String> dirs = new ArrayList<>();
		Files.walk(Paths.get(dir), 1).filter(x->x != new Path(dir) && x.toString().startsWith(dir + File.separator + start)).forEach(x->dirs.add(x.toString()));
		return dirs;
	}
	
	static List<String> itToList(Iterator<Text> it) {
		List<String> vals = new ArrayList<>();
		it.forEachRemaining(x->vals.add(x.toString()));
		return vals;
	}
	
	static <T>String pre(T orig, int num) {
		String spaces = "";
		for(int i = 0; i < num-orig.toString().length(); i++)
			spaces += " ";
		return spaces + orig;
	}
	
	static <T>String post(T orig, int num) {
		String spaces = "";
		if(orig == null) {
			for(int i = 0; i < num; i++)
				spaces += " ";
			return spaces;
		}
		else {
			for(int i = 0; i < num-orig.toString().length(); i++)
				spaces += " ";
			return orig + spaces;
		}
	}
	
	static <T>void println(T t) {
		System.out.println(t.toString()); 
	}
	
	static <T>void print(T t) {
		System.out.print(t.toString());
	}
}
