package com.minhhoang;

import java.io.*;
import java.util.ArrayList;

public class Helper {
	
	private final String FILEPATH = "";
	
	public static void main(String[] args) {
		
	}

	public BufferedReader getReader() throws FileNotFoundException {
		FileReader input = new FileReader(FILEPATH); 
		BufferedReader reader = new BufferedReader(input);
		return reader;
	}
	
	public String[] getEmail(BufferedReader reader) throws IOException {
		ArrayList<String> emails = new ArrayList<String>();
		String line;
		while ((line = reader.readLine()) != null) {
			emails.add(line);
		}
		String[] output = new String[emails.size()];
		output = emails.toArray(output);
		return output;
	}
	
	public String[] convertToHtml(String[] input) {
		String firstPart = "http://www.student.tcu.edu/";
		String secondPart = "/10403labs.html";
	}
}
