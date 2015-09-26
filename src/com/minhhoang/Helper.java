package com.minhhoang;

import java.io.*;
import java.util.ArrayList;

public class Helper {
	
	private final String FILEPATH = "input";
	private final String SAVEPATH = "output";
	
	public static void main(String[] args) {
		Helper helper = new Helper();
	}

	public Helper() {
		try {
			BufferedReader reader = getReader();
			String[] emails = getEmail(reader);
			String[] links = convertToHtml(emails);
			saveFile(links);
			System.out.println("finished");
		} catch (FileNotFoundException e) {
			System.err.println("No such file to read");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Cannot read file");
			e.printStackTrace();
		}
	}
	
	public BufferedReader getReader() throws FileNotFoundException {
		FileReader input = new FileReader(FILEPATH); 
		BufferedReader reader = new BufferedReader(input);
		return reader;
	}
	
	public BufferedWriter getWriter() throws IOException {
		FileWriter output = new FileWriter(SAVEPATH);
		BufferedWriter writer = new BufferedWriter(output);
		return writer;
	}
	
	public String[] getEmail(BufferedReader reader) throws IOException {
		ArrayList<String> emails = new ArrayList<String>();
		String line;
		while ((line = reader.readLine()) != null) {
			emails.add(line);
		}
		String[] output = new String[emails.size()];
		output = emails.toArray(output);
		reader.close();
		return output;
	}
	
	public String[] convertToHtml(String[] allEmails) {
		String firstPart = "http://www.student.tcu.edu/";
		String secondPart = "/10403labs.html";
		int numberOfEmails = allEmails.length;
		
		String[] output = new String[numberOfEmails];
		
		// Take the name field out of the emails. Strip all dot and put them into an array.
		for (int i = 0; i < numberOfEmails; i++) {
			String name = allEmails[i].split("@")[0];
			name = name.replaceAll("\\.", "");
			output[i] = firstPart + name + secondPart;
		}
		return output;
	}
	
	public void saveFile(String[] links) {
		try {
			BufferedWriter writer = getWriter();
			for (String link: links) {
				writer.write(link + "\n");
			}
			writer.close();
		} catch (IOException e) {
			System.out.println("No such file to write");
			e.printStackTrace();
		}
	}
}
