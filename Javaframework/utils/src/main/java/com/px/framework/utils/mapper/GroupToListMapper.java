package com.px.framework.utils.mapper;

import java.util.ArrayList;
import java.util.List;

import com.px.framework.utils.group.Group;

public class GroupToListMapper<T,V> {
	public List<V> mapFrom(Group<T> sourceItems,OneWayMapper<T,V> mapper){
		List<V> mappedItems = new ArrayList<>();
		if(sourceItems!=null && !sourceItems.isEmpty()){
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
	public void startMapping(Group<T> sourceItems){
	  //to start mapping
	}
	public void finishMapping(Group<T> sourceItems,List<V> mappedItems){
	  //to finish mapping
	}
}
