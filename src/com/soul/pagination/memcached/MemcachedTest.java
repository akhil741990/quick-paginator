package com.soul.pagination.memcached;


import java.util.concurrent.TimeUnit;

import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;



public class MemcachedTest {
	public static void main(String args[]) throws InterruptedException {
		SockIOPool pool = SockIOPool.getInstance();
		String server[] = {"localhost:1121"};
		pool.setServers(server);
		pool.setFailover( true );
		pool.setInitConn( 10 );
		pool.setMinConn( 5 );
		pool.setMaxConn( 250 );
		pool.setMaintSleep( 30 );
		pool.setNagle( false );
		pool.setSocketTO( 3000 );
		pool.setAliveCheck( true );
		pool.initialize();
		MemCachedClient m = new MemCachedClient("t");
		for(int i = 0 ;i<10000;i++) {
			m.add(i+"",900, i);
		}
		System.out.println("Data Loaded");
		TimeUnit.HOURS.sleep(1);
	}
}
