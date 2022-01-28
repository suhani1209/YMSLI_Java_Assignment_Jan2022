package com.day6.q4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class BiggestNumber {
	public static void main(String[] args) throws NumberFormatException, IOException {
		List<Double> numbers=new ArrayList<>();
		try {
			BufferedReader br=new BufferedReader(new FileReader("data.txt"));
			String line=null;
			while((line=br.readLine())!=null)
			{
				numbers.add(Double.parseDouble(line));
			}
			System.out.println("Biggest double is : "+findBiggestNumber(numbers));
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}

	private static Double findBiggestNumber(List<Double> numbers) {
		double maxDouble=0;
		for(Double number:numbers)
		{
			maxDouble=Math.max(number, maxDouble);
		}
		return maxDouble;
	}
}
