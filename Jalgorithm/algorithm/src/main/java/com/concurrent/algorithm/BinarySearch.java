package com.concurrent.algorithm;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class BinarySearch {

	public BinarySearch() {
		
	}
	
	public static void main(String[] args) {
		
		StdOut.println("1111");
		
		//StdDraw.circle(0.2, 0.2, 0.1);
		int[] whitelist = In.readInts(args[0]);
		
		/*Arrays.sort(whitelist);
		
		while(!StdIn.isEmpty()) {
			//输入
			int key = StdIn.readInt();
			StdOut.println(key);
			if(rank(key,whitelist)<0) {
				//没找到
				StdOut.println(key);
			}
		}*/
		BinarySearch(whitelist);
		
		StdOut.println("22222");
		
	}

	//正整数转化为二进制
	public static String int2binary(int N) {
		
		String s = "";
		
		for(int n=N;n>0;n/=2) {
			s = n%2+s;
		}
		
		System.out.println("二进制:"+s);
		
		return s;
	}
	
	public static int rank(int key,int[] a) {
		//数组先排序
		int lo = 0;
		int hi = a.length-1;
		while(lo <= hi) {
			
			int  mid = lo + (hi-lo)/2;
			if(key<a[mid]) hi = mid - 1;
			else if(key>a[mid]) lo = mid +1;
			else return mid;
			
		}
		return -1;
		
		
	}
	
	public static void BinarySearch(int[] whitelist) {
		
		Arrays.sort(whitelist);
		
		while(!StdIn.isEmpty()) {
			int key = StdIn.readInt();
			StdOut.println(key);
			if(rank(key,whitelist)<0) {
				StdOut.println(key);
			}
		}
		
	}
}
