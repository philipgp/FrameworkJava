package com.px.framework.utils.mapper;

import java.util.ArrayList;
import java.util.List;

public class ListToListMapper<T,V> {
	public List<V> mapFrom(List<T> sourceItems,OneWayMapper<T,V> mapper){
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
	
	public List<V> mapFrom(List<T> sourceItems,TwoWayMapper<T,V> mapper){
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
	
	public List<T> mapTo(List<V> sourceItems,TwoWayMapper<T,V> mapper){
		List<T> mappedItems = new ArrayList<>();
		if(sourceItems!=null){
			startMappingTo(sourceItems);
			int index = 0;
			for(V sourceItem:sourceItems){
				T destinationItem = mapper.mapTo(sourceItem,index);
				index++;
				mappedItems.add(destinationItem);
			}
			finishMappingTo(sourceItems, mappedItems);
		}
		return mappedItems;
	}
	public void startMapping(List<T> sourceItems){
	  //to start mapping
	}
	public void startMappingTo(List<V> sourceItems){ 
		  //to start mapping
		}
	public void finishMapping(List<T> sourceItems,List<V> mappedItems){
	  //to finish mapping
	}
	
	public void finishMappingTo(List<V> sourceItems,List<T> mappedItems){
		  //to finish mapping
		}
}
