package com.concurrent.algorithm;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;

public class Shell {

	public static void sort(Comparable[] a) {
		//将a[] 升序排列
		int N = a.length;
		
		int h = 1;
		
		while(h<N/3) h=3*h+1;
		
		while(h>=1) {
			
			for(int i=h;i<N;i++) {
				//将a[i] 插入到a[i-h],a[i-2*h]..中去
				for(int j=i;j>=h&&Example.less(a[j],a[j-h]);j-=h)
					Example.exch(a,j,j-h);
			}
			h=h/3;
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
