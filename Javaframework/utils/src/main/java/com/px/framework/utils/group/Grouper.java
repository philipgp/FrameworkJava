package com.px.framework.utils.group;

import java.io.Serializable;
/**
 * Grouper groups similar items based on some conditions provided in abstract functions isMemberOf() and getNewgroup().
 * How this works is , a list of items is provided to group() function. it will iterate through the list of items.
 * it first checks if it is a member of any available group. if no group is available, create a new group and add the item
 * if item is a member of any group, add the item to the group.
 * if item is not a member of any group, create a new group and add item to that group. 
 * in effect it create a group of group, each item in a group is related.
 * for eg: if we have a list of PNR  we can group it by PNR so that each group has passengers with same PNR and we have a list of 'em 
 * @author 61008
 *
 * @param <T>
 */
public abstract class Grouper<T,Q extends Group<T>> implements Serializable{


	private static final long serialVersionUID = 6725666923142148141L;

	protected Group<Q> groups;
	/**
	 * group similar items to make a group of group
	 * @param items
	 * @return
	 */
	public Group<Q> group(Iterable<T> items){
		if(items!=null) {
			for(T item:items){ 
				Group<T> group = getGroupToAdd(item); // check the group to which the item should be added
				group.add(item); // add it. simple!
			} 
		}
		return groups;
	}
	/**
	 * find the group that should host the current item
	 * @param item item to be added
	 * @return
	 */
	protected Group<T> getGroupToAdd(T item){
		if(groups!=null){
			for(Q group:groups){ // iterate through the list of current groups
				if(isMemberOf(group, item)){ // check
					return group;
				}
			}
			Q group = getNewGroup(item);
			groups.add(group);
			return group;
		}
		else {// if there is no groups available, create new group
			groups = new Group<>();
			Q group = getNewGroup(item);

			groups.add(group);
			return group;
		}
	}

	/**
	 * This  function should be implemented by child classes
	 * @param item
	 * @return
	 */
	protected abstract Q getNewGroup(T item);
	/**
	 * This  function should be implemented by child classes
	 * @param item
	 * @return
	 */
	protected abstract boolean isMemberOf(Q group,T item); 

}
