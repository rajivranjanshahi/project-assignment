package com.assigment.one;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FileOperation {

	public static void main(String[] args) throws IOException {
		String folderPath = "Infiles";
		FileOperation fo = new FileOperation();
		List<Integer> outPut = new ArrayList<Integer>();
		List<Integer> result = fo.readFiles(folderPath, outPut);
		System.out.println("Size is ::" +result.size());
		Collections.sort(result);
		System.out.println("Size is ::" +result.size());
		PrintWriter pw = new PrintWriter("OutFiles//out.txt");
		for (int i = 0; i < result.size(); i++) {
			pw.write(String.valueOf(result.get(i)));
			pw.write("\n");
		}
		pw.flush();
		pw.close();

	}

	private List<Integer> readFiles(String folderPath, List<Integer> results) {
		File[] files = new File(folderPath).listFiles();
		for (File file : files) {
			if (file.isFile()) {

				//System.out.println(folderPath + file.getName());
				Scanner scanFile;
				try {
					scanFile = new Scanner(new File(file.getAbsolutePath()));
					while (scanFile.hasNextInt()) {
						int value = scanFile.nextInt();
						results.add(value);

					}
				} catch (FileNotFoundException e) {

					e.printStackTrace();
				}

			}

		}

		return results;
	}

}
