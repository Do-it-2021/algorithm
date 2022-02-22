package com.concurrent.algorithm;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;

/**
 * 选择排序
 *
 */
public class Selection {
	
	 
	    private static boolean less(Comparable v, Comparable w) {
	        return v.compareTo(w) < 0;
	    }
	    private static void exch(Comparable[] a, int i, int j) {
	        Comparable t = a[i];
	        a[i] = a[j];
	        a[j] = t;
	    }
	    private static void show(Comparable[] a) {
	        for (int i = 0; i < a.length; i++) {
	            System.out.print(a[i] + "");
	            System.out.println();
	        }
	    }
	    private static boolean isSorted(Comparable[] a) {
	        for (int i = 0; i < a.length; i++) {
	            if(less(a[i], a[i-1]))
	                return false;
	        }
	        return true;
	    }

	public static void sort(Comparable[] a) {
		
		//a[] 升序排列
		int N = a.length;
		
		for(int i=0;i<N;i++) {
			//a[i] 与a[i+1..N] 中最小元素交换
			int min = i;
			for(int j=i+1;j<N;j++) 	
				if(less(a[j],a[min])) min = j;
			exch(a,i,min);
		}
		
	}
	
	public static void main(String[] args) {
		
		
		int[] a = In.readInts(args[0]);
		
		Integer[] b = (Integer[]) Arrays.stream(a).boxed().toArray(Integer[]::new);
		
		 sort(b);
        assert isSorted(b);
        show(b);
		
		
	}
	
}
