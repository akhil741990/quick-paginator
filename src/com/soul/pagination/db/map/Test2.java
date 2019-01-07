package com.soul.pagination.db.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Test2 {

	public static void main(String args[]) {
		
		HashMap<MapEntry, MapEntry> map75 = new HashMap<MapEntry, MapEntry>(1024, 0.75f);
		HashMap<MapEntry, MapEntry> map85 = new HashMap<MapEntry, MapEntry>(1024, 0.85f);
		
		
	   ArrayList<MapEntry> elementsAfterRehash = new ArrayList<MapEntry>();
	   ArrayList<MapEntry> elementsBeforeRehash = new ArrayList<MapEntry>();	
	   
		for(int i = 1 ; i <= 800;i++) {
			MapEntry m = new MapEntry(i);
			int h;
			int hash = (h = m.hashCode()) ^ (h >>> 16);
			hash = hash & (1024-1);
			System.out.println("Bucket for i="+i + " = "+hash);
			if(i>768) {
				hash = hash & (2048-1);
				elementsAfterRehash.add(m);
				System.out.println("Rehash - Bucket for i="+i + " = "+hash);
			}else {
				elementsBeforeRehash.add(m);
			}
			map75.put(m, m);
			map85.put(m, m);
		}
		
		long time75 = 0;
		long time85 = 0;
		for(int i = 1 ;i <= 10;i++) {
			Random r = new Random();
			int randomInt =  r.nextInt((31 - 0) + 1) + 0;
			long startTime = System.nanoTime();
			
			MapEntry key = elementsAfterRehash.get(randomInt);
			
			MapEntry m1 = map85.get(key);
			if(m1!=null) {
				
				time85 =  (System.nanoTime() - startTime);
				System.out.println("Id ="+m1.getId()); 
				System.out.println("time85 = "+time85);
				
				
			}
			startTime = System.nanoTime();
			MapEntry m = map75.get(key);
			if(m!=null) {
				time75 = (System.nanoTime() - startTime);
				System.out.println("time75 = "+time75);
				System.out.println("===============");
			}
			
		}
		
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		
		for(int i = 1 ;i <= 10;i++) {
			Random r = new Random();
			int randomInt =  r.nextInt((767 - 0) + 1) + 0;
			long startTime = System.nanoTime();
			
			MapEntry key = elementsBeforeRehash.get(randomInt);
			
			MapEntry m1 = map85.get(key);
			if(m1!=null) {
				
				time85 =  (System.nanoTime() - startTime);
				System.out.println("Id ="+m1.getId()); 
				System.out.println("time85 = "+time85);
				
				
			}
			startTime = System.nanoTime();
			MapEntry m = map75.get(key);
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
