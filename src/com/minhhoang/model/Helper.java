package com.minhhoang.model;

import java.io.*;
import java.util.ArrayList;

public class Helper {
	
	public static String[] getEmail(String text) {
		ArrayList<String> emails = new ArrayList<String>();
		
		for (String email : text.split("\\r?\\n")) {
			if (!email.equals(""))
				emails.add(email);
		}
		
		String[] output = new String[emails.size()];
		output = emails.toArray(output);
		
		return output;
	}
	
	public static String[] convertToHtml(String[] allEmails) {
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
	
	public static void saveFile(String path, String[] links) {
		try {
			BufferedWriter writer = getWriter(path);
			for (String link: links) {
				writer.write(link + "\n");
			}
			writer.close();
		} catch (IOException e) {
			System.out.println("No such file to write");
			e.printStackTrace();
		}
	}
	
	private static BufferedWriter getWriter(String path) throws IOException {
		FileWriter output = new FileWriter(path);
		BufferedWriter writer = new BufferedWriter(output);
		return writer;
	}
}
