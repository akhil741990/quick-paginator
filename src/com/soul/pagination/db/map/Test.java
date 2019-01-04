package com.soul.pagination.db.map;

import java.util.HashMap;
import java.util.Random;

public class Test {

	public static void main(String args[]) {
		
		HashMap<Integer, MapEntry> map75 = new HashMap<Integer, MapEntry>(1000, 0.5f);
		HashMap<Integer, MapEntry> map85 = new HashMap<Integer, MapEntry>(1000, 0.85f);
		
		for(int i = 1 ; i <= 800;i++) {
			MapEntry m = new MapEntry(i);
			int h;
			int hash = (h = m.getId().hashCode()) ^ (h >>> 16);
			hash = hash & (1000-1);
			System.out.println("Bucket for i="+i + " = "+hash);
			map75.put(m.getId(), m);
			map85.put(m.getId(), m);
		}
		
		long time75 = 0;
		long time85 = 0;
		for(int i = 1 ;i <= 10;i++) {
			Random r = new Random();
			int randomInt =  r.nextInt((50 - 1) + 1) + 1;
			long startTime = System.nanoTime();
			
			MapEntry m1 = map85.get(randomInt);
			if(m1!=null) {
				
				time85 =  (System.nanoTime() - startTime);
				System.out.println("Id ="+m1.getId()); 
				System.out.println("time85 = "+time85);
				
				
			}
			startTime = System.nanoTime();
			MapEntry m = map75.get(randomInt);
			if(m!=null) {
				time75 = (System.nanoTime() - startTime);
				System.out.println("time75 = "+time75);
				System.out.println("===============");
			}
			
		}
		
		System.out.println("#########################################");
		
		
		for(int i = 1 ;i <= 10;i++) {
			Random r = new Random();
			int randomInt =  r.nextInt((800 - 750) + 1) + 750;
			long startTime = System.nanoTime();
			
			MapEntry m1 = map85.get(randomInt);
			if(m1!=null) {
				
				time85 =  (System.nanoTime() - startTime);
				System.out.println("Id ="+m1.getId()); 
				System.out.println("time85 = "+time85);
				
				
			}
			startTime = System.nanoTime();
			MapEntry m = map75.get(randomInt);
			if(m!=null) {
				time75 = (System.nanoTime() - startTime);
				System.out.println("time75 = "+time75);
				System.out.println("===============");
			}
			
		}
		
//		System.out.println("Average time map75:"+time75);
//		System.out.println("Average time map85:"+time85);
	}
}
