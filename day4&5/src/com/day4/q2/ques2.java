package com.day4.q2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class ques2 {
	private static void writeData(File file) {
		try(BufferedWriter writer=new BufferedWriter(new FileWriter(file))){
			Scanner scanner=new Scanner(System.in);
			String dataToBeWritten="";
			System.out.println("Enter text to be written in file : ");
			dataToBeWritten=scanner.nextLine();
			writer.write(dataToBeWritten);
			System.out.println("File written successfully ..");
			
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("File cannot be written..");
		}
	}
	private static String readData(File file) {
		String line=null;
		try(BufferedReader reader=new BufferedReader(new FileReader(file))){
			while((line=reader.readLine())!=null) {
				System.out.println(line);
			}
			System.out.println("File reading done..");
		}catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println("File cannot be readed ..");
		}
		return line;
	}
	public static void main(String[] args) {
		File file=new File("fileCreated.txt");
		writeData(file);
		readData(file);
	}
}
