package com.day5.q1;

import java.io.File;
import java.io.FileInputStream;

public class ques1 {
	private static byte[] readContent(File file)
	{
		byte[] arr=new byte[(int)file.length()];
		try(FileInputStream input=new FileInputStream(file)){
			input.read(arr);
			// printing in byte format
			for(byte a:arr)
			{
				System.out.print(a);
			}
			System.out.println();
			
			//printing in char format
			for(byte a:arr) {
				System.out.print((char)a);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return arr;
	}
	public static void main(String[] args) {
		File file=new File("file");
		readContent(file);
	}
}
