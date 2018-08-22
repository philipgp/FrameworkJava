package com.px.framework.utils.mapper;

public interface OneWayMapper<T,V> {

	public V mapFrom(T source,Object...objects);
}
