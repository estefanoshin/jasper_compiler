package io.github.estefanoshin;

import java.io.File;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.RegexFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;

/**
 * COMPILES EVERY .jrxml FILE AND GENERATES A BINARY WITH THE .jrxml EXTENSION
 * 
 * @author eshin
 *
 */
public class JasperCompiler {

	/**
	 * COMPILES THE PROJECT ON THE DIRECTORY OF THE PROJECT WHERE IT WAS CALLED
	 */
	public static void compile()
		throws JRException {

		File currentDirFile = new File("");
		String currentPath = currentDirFile.getAbsolutePath();

		System.out.println("Current path is: " + currentPath);

		File rootDir = new File(currentPath);

		// Get all *.jrxml files
		Collection<File> files =
			FileUtils.listFiles(rootDir, new RegexFileFilter("^(.*\\.jrxml)"), TrueFileFilter.INSTANCE);

		for (File file : files) {
			System.out.println("Compiling: " + file.getAbsolutePath());
			JasperCompileManager.compileReportToFile(file.getAbsolutePath(),
				file.getAbsolutePath().replaceAll("jrxml", "jasper"));

		}
		System.out.println("Compiling: completed!");
	}

	/**
	 * @param customPath
	 *            COMPILES THE PROJECT ON THE SPECIFIED PATH
	 */
	public static void compile(String customPath)
		throws JRException {

		System.out.println("Current path is: " + customPath);

		File rootDir = new File(customPath);

		// Get all *.jrxml files
		Collection<File> files =
			FileUtils.listFiles(rootDir, new RegexFileFilter("^(.*\\.jrxml)"), TrueFileFilter.INSTANCE);

		for (File file : files) {
			System.out.println("Compiling: " + file.getAbsolutePath());
			JasperCompileManager.compileReportToFile(file.getAbsolutePath(),
				file.getAbsolutePath().replaceAll("jrxml", "jasper"));

		}
		System.out.println("Compiling: completed!");
	}
}