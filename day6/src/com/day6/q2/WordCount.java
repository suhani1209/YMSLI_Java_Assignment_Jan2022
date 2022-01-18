package com.day6.q2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

public class WordCount {
	public static void main(String[] args) throws FileNotFoundException {
		Map<String, Integer> m=new HashMap<String, Integer>(); 
		try{
			BufferedReader bufferedReader=new BufferedReader(new FileReader("javaFile.txt"));
			String line=null;
			
			while((line=bufferedReader.readLine())!=null) {
				String tokens[]=line.split(" ");
				
				for(String token:tokens) {
					Integer freq=m.get(token);
					if(freq==null) {
						m.put(token, 1);
					}else {
						m.put(token,++freq);
					}
				}
			}
			bufferedReader.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		System.out.println("Word frequency can be printed as...");
		Set<Entry<String, Integer>> entrySet = m.entrySet();
		
		for(Entry<String, Integer> entry: entrySet) {
			System.out.println(entry.getKey() +" : "+ entry.getValue());
		}
	}
}
