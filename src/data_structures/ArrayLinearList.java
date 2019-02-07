package data_structures;

import java.util.Iterator;

/**
 * Program #1 Array list for data storage of max size 100 CS310 16 February 2019
 * 
 * @author Hannah Juarez cssc1481
 */

public class ArrayLinearList<T> implements LinearListADT<T> {

	private T listArray[];
	private int objectCount, headIdx, tailIdx;

	/*
	 * Default constructor
	 */
	public ArrayLinearList() {
		this(LinearListADT.DEFAULT_MAX_CAPACITY);
	}

	/*
	 * Custom constructor
	 */
	@SuppressWarnings("unchecked")
	public ArrayLinearList(int maxCapacity) {
		int size;
		if (maxCapacity < 1)
			size = 1;
		else if (maxCapacity > DEFAULT_MAX_CAPACITY)
			size = DEFAULT_MAX_CAPACITY;
		else
			size = maxCapacity;
		listArray = (T[]) new Object[size];
		this.objectCount = 0;
		this.headIdx = 0;
		this.tailIdx = 0;
	}

	/*
	 * Outputs “Front: indexFront Rear: indexRear”
	 */
	@Override
	public void ends() {
		System.out.println("Front: " + this.headIdx + " Rear: " + this.tailIdx);
	}

	/*
	 * Adds the Object obj to the beginning of list and returns true if the list is
	 * not full. returns false and aborts the insertion if the list is full.
	 */
	@Override
	public boolean addFirst(T obj) {
		if (this.isFull())
			return false;
		if (this.isEmpty())
			this.headIdx = 0;
		else
			this.headIdx = (this.headIdx - 1 + this.listArray.length) % this.listArray.length;
		this.listArray[this.headIdx] = obj;
		this.objectCount++;
		return true;
	}

	/*
	 * Adds the Object obj to the end of list and returns true if the list is not
	 * full. returns false and aborts the insertion if the list is full.
	 */
	@Override
	public boolean addLast(T obj) {
		if (this.isFull())
			return false;
		if (this.isEmpty())
			this.tailIdx = 0;
		else
			this.tailIdx = (this.tailIdx + 1 + this.listArray.length) % this.listArray.length;
		this.listArray[this.tailIdx] = obj;
		this.objectCount++;
		return true;
	}

	/*
	 * Removes and returns the parameter object obj in first position in list if the
	 * list is not empty, null if the list is empty.
	 */
	@Override
	public T removeFirst() {
		if (this.isEmpty())
			return null;
		T itemToReturn = this.listArray[this.headIdx];
		this.listArray[this.headIdx] = null;
		this.headIdx = (this.headIdx + 1 + this.listArray.length) % this.listArray.length;
		this.objectCount--;
		return itemToReturn;
	}

	/*
	 * Removes and returns the parameter object obj in last position in list if the
	 * list is not empty, null if the list is empty.
	 */
	@Override
	public T removeLast() {
		if (this.isEmpty())
			return null;
		T itemToReturn = this.listArray[this.tailIdx];
		this.listArray[this.tailIdx] = null;
		this.tailIdx = (this.tailIdx - 1 + this.listArray.length) % this.listArray.length;
		this.objectCount--;
		return itemToReturn;
	}

	/*
	 * Removes and returns the parameter object obj from the list if the list
	 * contains it, null otherwise. The ordering of the list is preserved. The list
	 * may contain duplicate elements. This method removes and returns the first
	 * matching element found when traversing the list from first position. Note
	 * that you may have to shift elements to fill in the slot where the deleted
	 * element was located.
	 */
	@Override
	public T remove(T obj) {
		// Use find() or contains() to locate item
		// Store item to return
		// Compare index of item removed versus head and tail indices
		// Shift smaller side to fill hole (if same distance, use right side)
		// Update objectCount and appropriate index
		return null;
	}

	/*
	 * Returns the first element in the list, null if the list is empty. The list is
	 * not modified.
	 */
	@Override
	public T peekFirst() {
		if (!this.isEmpty())
			return this.listArray[this.headIdx];
		return null;
	}

	/*
	 * Returns the last element in the list, null if the list is empty. The list is
	 * not modified.
	 */
	@Override
	public T peekLast() {
		if (!this.isEmpty())
			return this.listArray[this.tailIdx];
		return null;
	}

	/*
	 * Returns true if the parameter object obj is in the list, false otherwise. The
	 * list is not modified.
	 */
	@Override
	public boolean contains(T obj) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * Returns the element matching obj if it is in the list, null otherwise. In the
	 * case of duplicates, this method returns the element closest to front. The
	 * list is not modified.
	 */
	@Override
	public T find(T obj) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * The list is returned to an empty state.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		this.listArray = (T[]) new Object[this.listArray.length];
		this.objectCount = 0;
		this.headIdx = 0;
		this.tailIdx = 0;
	}

	/*
	 * Returns true if the list is empty, otherwise false
	 */
	@Override
	public boolean isEmpty() {
		return this.objectCount == 0;
	}

	/*
	 * Returns true if the list is full, otherwise false
	 */
	@Override
	public boolean isFull() {
		return this.objectCount == listArray.length;
	}

	/*
	 * Returns the number of Objects currently in the list.
	 */
	@Override
	public int size() {
		return this.objectCount;
	}

	/*
	 * Returns an Iterator of the values in the list, presented in the same order as
	 * the underlying order of the list. (front first, rear last)
	 */
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
