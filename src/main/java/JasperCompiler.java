import java.io.File;
import java.util.Collection;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.RegexFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;

public class JasperCompiler {

	public static void main(String[] args) throws JRException {
		String currentPath = "/Users/eshin/workspace/";

		// Get currently running directory
		// String currentPath = System.getProperty(directory);

		System.out.println("Current path is: " + currentPath);

		// Go to directory where all the reports are
		File rootDir = new File(currentPath);

		// Get all *.jrxml files
		Collection<File> files = FileUtils.listFiles(rootDir, new RegexFileFilter("^(.*\\.jrxml)"), TrueFileFilter.INSTANCE);

		for (File file : files) {
//			System.out.println("Compiling: " + file.getAbsolutePath());
//			System.out.println("Output: " + file.getName() + ".jasper");
			// Actual compiling
			
//			System.out.println(file.getAbsolutePath());

			JasperCompileManager.compileReportToFile(file.getAbsolutePath(), file.getAbsolutePath().replaceAll("jrxml", "jasper"));
//			System.out.println("Compiling: completed!");
		}
	}
}