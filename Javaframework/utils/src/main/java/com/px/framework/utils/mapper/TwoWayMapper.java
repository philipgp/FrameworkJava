package com.px.framework.utils.mapper;

public interface TwoWayMapper<T,V> {

	public V mapFrom(T source,Object...objects); 
	public T mapTo(V source,Object...objects); 
}
