package com.concurrent.algorithm;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 快速排序
 *
 */
public class Quick {
	
	private static int partition(Comparable[] a,int lo,int hi) {
		//数组切分为a[lo..i-1],a[i],a[i+1..hi]
		int i= lo,j=hi+1;//左右扫描指针
		Comparable v = a[lo];//切分元素
		
		while(true) {
			//扫描左右，检查扫描是否结束并交换元素
			while(Example.less(a[++i],v)) if(i==hi) break;//循环查找v<a[i]
			while(Example.less(v,a[--j])) if(j==lo) break;//循环查找 v>a[j]
			if(i>=j) break;
			Example.exch(a, i, j);
		}
		
		Example.exch(a, lo, j);//将v=a[j] 放入正确位置
		return j; //a[lo..j-1]<=a[j]<=a[j+1..hi] 达成
		
	}
	

	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);//消除对输入的依赖
		
		sort(a,0,a.length-1);
	}
	
	//递归切分排序
	private static void sort(Comparable[] a,int lo,int hi) {
		if(hi<=lo) return;
		
		/*if(hi<=lo+5) {
		 	//切换插入排序，小数组插入排序快点
			Insertion.sort(a,lo,hi);
			return;
		}*/
		
		int j = partition(a,lo,hi);//切分
		sort(a,lo,j-1);//左半边排序 
		sort(a,j+1,hi);//右半边排序
	}
	
	public static void main(String[] args) {
		int[] a = In.readInts(args[0]);
		
		Integer[] b = (Integer[])Arrays.stream(a).boxed().toArray(Integer[]::new);
		
		sort(b);
		
		  assert Example.isSorted(b);
	       Example.show(b);
	} 
	
	
}
