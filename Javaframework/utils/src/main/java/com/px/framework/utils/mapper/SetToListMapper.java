package com.px.framework.utils.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SetToListMapper<T,V> {
	public List<V> mapFrom(Set<T> sourceItems,OneWayMapper<T,V> mapper){
		List<V> mappedItems = new ArrayList<>();
		if(sourceItems!=null){
			startMapping(sourceItems);
			int index = 0;
			for(T sourceItem:sourceItems){
				V destinationItem = mapper.mapFrom(sourceItem,index);
				index++;
				mappedItems.add(destinationItem);
			}
			finishMapping(sourceItems, mappedItems);
		}
		return mappedItems;
	}
	public void startMapping(Set<T> sourceItems){
		//to start mapping
	}
	public void finishMapping(Set<T> sourceItems,List<V> mappedItems){
		//to finish mapping
	}
}
