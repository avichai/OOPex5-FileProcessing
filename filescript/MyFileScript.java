package oop.ex5.filescript;

import java.io.File;
import java.util.ArrayList;

import oop.ex5.parsing.Parsing;
import oop.ex5.sections.Section;

/**
 * This is the manager class. The scripting is done throw this class.
 * 
 * @author Avichai
 *
 */
public class MyFileScript {
	private static final int THE_FIRS_LINE_OF_FILTER_DESCRIPTION = 2;
	private static final String WARNING_IN_LINE = "Warning in line ";
	private static final String ERROR = "ERROR";
	private String sourceDir;
	private String commandFile;

	/**
	 * Constructor for MyFileScript.
	 * 
	 * @param sourceDir
	 *            the input source dir to script from.
	 * @param commandFile
	 *            the input command file that command how to script the source
	 *            dir.
	 */
	public MyFileScript(String sourceDir, String commandFile) {
		if (sourceDir != null && commandFile != null) {
			this.sourceDir = sourceDir;
			this.commandFile = commandFile;
		}
	}

	/**
	 * This method runs the scripting on the input source dir usind the
	 * commandFile.
	 */
	public void runScript() {
		try {
			Section[] mySection = Parsing.parseSection(this.commandFile);
			File mySourceDir = new File(this.sourceDir);
			if (mySection == null || !mySourceDir.exists()
					|| !mySourceDir.isDirectory()) {
				throw new CriticalException();
			} else {
				scriptDirWithSections(mySection, mySourceDir);
			}
		} catch (CriticalException e) {
			System.err.println(ERROR);
		}
	}

	/*
	 * help method for runScript
	 * 
	 * @param mySection an arraylist of sections to filter with.
	 * 
	 * @param mySourceDir the source dir to filter on
	 * 
	 * @param pars the Parsing instance.
	 */
	private static void scriptDirWithSections(Section[] mySection, File mySourceDir) {
		File[] filesInDirectoroy = mySourceDir.listFiles();
		int lineOfFilterDescrip = THE_FIRS_LINE_OF_FILTER_DESCRIPTION;
		for (Section section : mySection) {
			printWarnings(section, lineOfFilterDescrip);
			if (section.isSectionWithOrderLine()) {
				lineOfFilterDescrip += 4;
			} else {
				lineOfFilterDescrip += 3;
			}
			scriptFile(section, filesInDirectoroy);

		}
	}

	/*
	 * help method for scriptDirWithSections method.
	 * 
	 * @param section a specific section.
	 * 
	 * @param lineOfFilterDescrip the line of the filter description of the
	 * current section we are applying.
	 */
	private static void printWarnings(Section section, int lineOfFilterDescrip) {
		if (section.isFilterWarning()) {
			System.err.println(WARNING_IN_LINE + (lineOfFilterDescrip));
		}
		if (section.isOrderWarning()) {
			System.err.println(WARNING_IN_LINE + (lineOfFilterDescrip + 2));
		}

	}

	/**
	 * help method for scriptDirWithSections method.
	 * 
	 * @param section
	 *            a specific section.
	 * @param filesInDirectoroy
	 *            array of files.
	 */
	private static void scriptFile(Section section, File[] filesInDirectoroy) {
		ArrayList<File> filesToPrint = new ArrayList<File>();
		for (File file : filesInDirectoroy) {
			if (file.isFile()) {
				if (section.getFilter().isPassed(file)) {
					filesToPrint.add(file);
				}
			}
		}
		File[] arrayOfFilesToPrint = new File[filesToPrint.size()];
		filesToPrint.toArray(arrayOfFilesToPrint);
		section.getOrder().getOrder(arrayOfFilesToPrint);
		for (File file : arrayOfFilesToPrint) {
			System.out.println(file.getName());
		}

	}

	/**
	 * main method
	 * 
	 * @param args
	 *            the inputs from the user (sould be source dir and command
	 *            file).
	 */
	public static void main(String[] args) {
		try {
			if (args.length != 2) {
				throw new InvalidUsageException();
			} else {
				MyFileScript myFileScript = new MyFileScript(args[0], args[1]);
				myFileScript.runScript();
			}
		} catch (CriticalException e) {
			System.err.println(ERROR);
		}
	}
}
