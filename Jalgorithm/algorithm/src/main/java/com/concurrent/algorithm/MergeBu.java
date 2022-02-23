package com.concurrent.algorithm;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;

/**
 * 自底向上
 *
 */
public class MergeBu {

	private static Comparable[] aux;//归并所需辅助数组
	
	//原地归并
	public static void merge(Comparable[] a,int lo,int mid,int hi) {
		
		aux = new Comparable[a.length];
		//将a[lo...mid]和a[mid+1...hi]归并
		int i=lo,j=mid+1;
		for(int k=lo;k<=hi;k++) //复制数组到aux
			aux[k]=a[k];
		
		for(int k=lo;k<=hi;k++)//归并数组到a[lo,hi]
			if(i>mid) a[k]=aux[j++];
			else if(j>hi) a[k]=aux[i++];
			else if(Example.less(aux[j], aux[i])) a[k]=aux[j++];
			else a[k]=aux[i++];
	}
	
	private static void sort(Comparable[] a) {
		int N = a.length;
		aux = new Comparable[N];
		
		for(int sz=1;sz<N;sz=sz+sz)
			for(int lo=0;lo<N-sz;lo+=sz+sz)
				merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1));	
	}
	
	public static void main(String[] args) {
			
			int[] a = In.readInts(args[0]);
			
			Integer[] b = (Integer[])Arrays.stream(a).boxed().toArray(Integer[]::new);
			
			sort(b);
			
			  assert Example.isSorted(b);
		       Example.show(b);
			
			
		}
}
