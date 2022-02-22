package com.concurrent.algorithm;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;

/**
 * 插入排序
 *
 */
public class Insertion {

	public static void sort(Comparable[] a) {
		 //将 a[]  按升序排列
		int N = a.length;
		
		for(int i=1;i<N;i++) {
			for(int j = i;j>0&&Example.less(a[j], a[j-1]);j--) 
				Example.exch(a,j, j-1);
		}
	}
	
	public static void main(String[] args) {
		
		int[] a = In.readInts(args[0]);
		
		Integer[] b = (Integer[]) Arrays.stream(a).boxed().toArray(Integer[]::new);
		
		 sort(b);
       assert Example.isSorted(b);
       Example.show(b);
		
	}
}
