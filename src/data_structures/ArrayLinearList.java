package data_structures;

import java.util.Iterator;

public class ArrayLinearList<T> implements LinearListADT<T> {

	private T listArray[];
	private int objectCount, headIdx, tailIdx;

	@SuppressWarnings("unchecked")
	public ArrayLinearList() {
		// Default constructor
		listArray = (T[]) new Object[LinearListADT.DEFAULT_MAX_CAPACITY];
		this.objectCount = 0;
		this.headIdx = -1;
		this.tailIdx = -1;
	}

	@SuppressWarnings("unchecked")
	public ArrayLinearList(int maxCapacity) {
		// Custom constructor
		listArray = (T[]) new Object[maxCapacity];
		this.objectCount = 0;
		this.headIdx = -1;
		this.tailIdx = -1;
	}

	/*
	 * Outputs “Front: indexFront Rear: indexRear”
	 */
	@Override
	public void ends() {
		// TODO Auto-generated method stub

	}

	/*
	 * Adds the Object obj to the beginning of list and returns true if the list is
	 * not full. returns false and aborts the insertion if the list is full.
	 */
	@Override
	public boolean addFirst(T obj) {
		// If full, return false
		// If empty, add item at location [0]
		// Otherwise, decrement headIdx and add item (use modulo for wrap around)
		// Increment objectCount and return true
		return false;
	}

	/*
	 * Adds the Object obj to the end of list and returns true if the list is not
	 * full. returns false and aborts the insertion if the list is full.
	 */
	@Override
	public boolean addLast(T obj) {
		// If full, return false
		// If empty, add item at location [0]
		// Otherwise, increment tailIdx and add item (use modulo for wrap around)
		// Increment objectCount and return true
		return false;
	}

	/*
	 * Removes and returns the parameter object obj in first position in list if the
	 * list is not empty, null if the list is empty.
	 */
	@Override
	public T removeFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * Removes and returns the parameter object obj in last position in list if the
	 * list is not empty, null if the list is empty.
	 */
	@Override
	public T removeLast() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
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

	@Override
	public boolean contains(T obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T find(T obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isEmpty() {
		return this.objectCount == 0;
	}

	@Override
	public boolean isFull() {
		return this.objectCount == listArray.length;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
