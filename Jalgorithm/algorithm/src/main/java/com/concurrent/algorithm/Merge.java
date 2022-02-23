package com.concurrent.algorithm;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;

/**
 * 归并排序,自顶向下
 *
 */
public class Merge {

	private static Comparable[] aux;//归并辅助数组
	
	public static void sort(Comparable[] a) {
		aux = new Comparable[a.length];
		
		Example.sort(a,0,a.length-1);
	}
	
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
	
	//自顶向下归并排序
	private static void sort(Comparable[] a,int lo,int hi) {
		//数组a排序
		if(lo>=hi) return;
		int mid = lo+(hi-lo)/2;
		Example.sort(a,lo,mid);//左半边排序
		Example.sort(a,mid+1,hi);//右半边排序

		merge(a,lo,mid,hi);//归并
	}
	
	
	public static void main(String[] args) {
		
		int[] a = In.readInts(args[0]);
		
		Integer[] b = (Integer[])Arrays.stream(a).boxed().toArray(Integer[]::new);
		
		sort(b,0,b.length-1);
		
		  assert Example.isSorted(b);
	       Example.show(b);
		
		
	}
	
	
}
