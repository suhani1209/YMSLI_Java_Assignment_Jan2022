package com.day1.q4;

public class Q4 {
	public static int[] copyOf(int[] array)
	{
		int copy[]=new int[array.length];
		for(int i=0;i<array.length;i++)
		{
			copy[i]=array[i];
		}
		// also can do so Arrays.copyOf(a,a.length)
		return copy;
	}
	public static void main(String[] args) {
		int arr[]= {3,4,5};
		System.out.println("original array : ");
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		int copyArr[]=copyOf(arr);
		System.out.println("copy of the array given : ");
		for(int i=0;i<copyArr.length;i++)
		{
			System.out.print(copyArr[i]+" ");
		}
	}
}
