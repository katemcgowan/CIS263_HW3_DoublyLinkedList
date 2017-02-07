package project4;

/***********************************************************************
 * Forms a single linked list of objects linearly pointing to each
 * other, one after another. Contains a {@link #top top} and 
 * {@link #tail tail} pointer to reference the first and last element 
 * of the list. Is used similar to that of an ArrayList.
 * @author Nathan Pipe
 * @version Fall 2015
 *
 * @param <E> The generic type which the list is composed of
 **********************************************************************/

public class LinkedList<E>{
	
	/** Points to the first element of the list */
	private Node<E> top;
	
	/** Points to the last element of the list */
	private Node<E> tail;
	
	/** The current size of the list starting at 0 for 0 elements */
	private int size;

	
	/*******************************************************************
	 * Constructs an empty LinkedList, with both {@link #top top} and 
	 * {@link #tail tail} set to null.
	 ******************************************************************/
	public LinkedList() {
		top = null;
		tail = null;
		size = 0;
	}
	
	
	/*******************************************************************
	 * Constructs an unique LinkedList with equal values to that of a
	 * given list.
	 * @param list A LinkedList to copy from
	 ******************************************************************/
	public LinkedList(LinkedList<E> list) {
		top = null;
		tail = null;
		size = 0;
		
		// Construct the list as an independent, copied version of
		// the given list
		Node<E> temp = list.top;
		for(int i = 0; i < list.size(); i++) {
				E data = temp.getData();
				this.add(data);
				
				temp = temp.getNext();
		}
	}
	
	
	/*******************************************************************
	 * @return The {@link #size size} of the list.
	 ******************************************************************/
	public int size() {
		return size;
	}
	
	
	/*******************************************************************
	 * Gets the element at a specified position.
	 * @param index The index of the element to be returned, starting at
	 * 0 for the first element.
	 * @return The element at the given position.
	 * @throws IndexOutOfBoundsException Thrown when 
	 * (index < 0 || index >= size)
	 ******************************************************************/
	public E get(int index) {
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		
		// loops through, stopping at the element wanted
		Node<E> temp = top;
		for(int i = 0; i <= index; i++) {
			if(i == index)
				return temp.getData();
			else
				temp = temp.getNext();
		}
		return null;
	}
	
	
	/*******************************************************************
	 * Sets the element of a specified position.
	 * @param index The index of the element to be changed, starting at
	 * 0 for the first element.
	 * @param data The value which to change the element at the given
	 * position to.
	 * @return The previous value of the changed element.
	 * @throws IndexOutOfBoundsException Thrown when 
	 * (index < 0 || index >= size)
	 ******************************************************************/
	public E set(int index, E data) {
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		
		// loops through, stopping at the element wanted
		Node<E> temp = top;
		for(int i = 0; i <= index; i++) {
			if(i == index) {
				E tempData = temp.getData();
				temp.setData(data);
				return tempData;
			}
			else
				temp = temp.getNext();
		}
		return null;
	}
	
	
	/*******************************************************************
	 * Assimilates a given LinkedList, starting at a given position.
	 * CAUTION: Can cause infinite looping when the same list is merged
	 * multiple times.
	 * @param index The position which to begin the merge, starting at
	 * 0 for the first element.
	 * @param list The LinkedList to be merged.
	 * @throws IndexOutOfBoundsException Thrown when
	 * (index < 0 || index > size)
	 ******************************************************************/
	public void merge(int index, LinkedList<E> list) {
		if(index < 0 || index > size)
			throw new IndexOutOfBoundsException();
		
		// merging to the beginning
		if(index == 0) {
			list.tail.setNext(this.top);
			this.top = list.top;
		}
		
		// merging to the end
		else if(index == size) {
			this.tail.setNext(list.top);
			this.tail = list.tail;
		}
		
		// merging to somewhere in the middle
		else {
			// Loops through stopping 1 before the desired element
			Node<E> temp = top;
			for(int i = 0; i < index; i++) {
				if(i == index-1) {
					// list.top is now at the desired index, the 
					// previous element is now the next element after
					// list.tail
					list.tail.setNext(temp.getNext());
					temp.setNext(list.top);
				}
				else
					temp = temp.getNext();
			}
		}
		this.size += list.size;
	}
	
	
	/*******************************************************************
	 * Adds a given element to the start of the list.
	 * @param data The element to be added.
	 ******************************************************************/
	public void addFirst(E data) {
		// list is empty
		if (top == null) {
			top = new Node<E>(data, top);
			tail = top;
		} 
		else
			top = new Node<E>(data, top);
		size++;

	}
	
	
	/*******************************************************************
	 * Adds a given element to the end of the list.
	 * @param data The element to be added.
	 ******************************************************************/
	public void add(E data) {
		// list is empty
		if (top == null) {
			addFirst(data);
		} else {			
			tail.setNext(new Node<E>(data, null));
			tail = tail.getNext();
			size++;
		}
	}
	
	
	/*******************************************************************
	 * Adds a given element to a desired index in the list.
	 * @param index The position which to add the element, starting at
	 * 0 for the first element.
	 * @param data The element to be added.
	 * @throws IndexOutOfBoundsException Thrown when
	 * (index < 0 || index > size)
	 ******************************************************************/
	public void add(int index, E data) {
		if(index < 0 || index > size)
			throw new IndexOutOfBoundsException();

		// adding to the beginning of the list
		if(index == 0) 
			addFirst(data);
		// adding to the end of the list
		else if(index == size)
			add(data);
		// adding to somewhere in the middle of the list
		else {
			// Loops through stopping at the desired element
			Node<E> temp = top;
			for(int i = 1; i <= index; i++) {
				if(i == index)
					temp.setNext(new Node<E>(data, temp.getNext()));
				else
					temp = temp.getNext();
			}
			size++;
		}
	}

	
	/*******************************************************************
	 * Removes the element at a given index.
	 * @param index The position of the element to be removed, starting
	 * at 0 for the first element.
	 * @return The element removed.
	 * @throws IndexOutOfBoundsException Thrown when
	 * (index < 0 || index >= size)
	 ******************************************************************/
	public E remove(int index) {
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		
		// The desired element is the first
		if(index == 0) {
			E data = top.getData();
			top = top.getNext();
			size--;
			return data;
		}
		
		// Loops through stopping 1 before the desired element
		Node<E> temp = top;
		for(int i = 0; i <= index; i++) {
			if(i+1 == index) {
				E data = temp.getNext().getData();
				temp.setNext(temp.getNext().getNext());
				if (temp.getNext() == null)
					tail = temp;
				size--;
				return data;
			}
			else
				temp = temp.getNext();
		}
		return null;
	}
	
	
	/*******************************************************************
	 * Removes the first element in the list with a specified value.
	 * @param data The value which to be removed.
	 * @return True if an element was found with that value, false
	 * otherwise.
	 ******************************************************************/
	public boolean remove(E data) {

		// Check if list is empty
		if (top == null)
			return false;

		// Check if top is the target
		if (top.getData().equals(data)) {
			top = top.getNext();
			if(top.getNext() == null)
				tail = null;
			size--;
			return true;
		}

		// All else fails, check the whole list for the target
		Node<E> temp = top;
		while(temp.getNext() != null) {
			if(temp.getNext().getData().equals(data)) {
				temp.setNext(temp.getNext().getNext());
				if(temp.getNext() == null)
					tail = temp;
				size--;
				return true;
			}
			temp = temp.getNext();
		}

		return false;

	}
	
	
	/*******************************************************************
	 * @return Returns a String containing the contents of this 
	 * LinkedList in a vertical list. Gets the values with the elements
	 * own toString methods.
	 ******************************************************************/
	public String toString() {
		String str = "";
		Node<E> temp = top;
		while (temp != null) {
			str += temp.getData().toString();
			temp = temp.getNext();
			if(temp != null)
				str += "\n";
		}
		return str;
	}
}