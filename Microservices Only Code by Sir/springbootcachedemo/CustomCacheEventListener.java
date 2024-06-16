package com.springbootcachedemo;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;

public class CustomCacheEventListener implements CacheEventListener<Object, Object> {

	//this method gets triggered whenever cache gets created, updated, expired
	@Override
	public void onEvent(CacheEvent event) {
		System.out.println("event captured " + event.getKey() + " " + event.getType() + " " + event.getOldValue() + " "
				+ event.getNewValue());

	}

}
