package data_structures;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Program #1 Data structure for an unsorted list of max size 100
 * 
 * CS310
 * 
 * 16 February 2019
 * 
 * @author Hannah Juarez cssc1481
 */

public class ArrayLinearList<E extends Comparable<E>> implements LinearListADT<E>, Iterable<E> {
	// how to resolve 

	protected E[] storage;
	protected int currentSize;
	protected int headIdx, tailIdx;
	protected long modificationCounter;

	/*
	 * Default constructor
	 * 
	 * Calls custom constructor using LinearListADT.DEFAULT_MAX_CAPACITY
	 */
	public ArrayLinearList() {
		this(LinearListADT.DEFAULT_MAX_CAPACITY);
	}

	/*
	 * Custom constructor
	 * 
	 * Enforces maximum size of 100, allows compiler to handle negative sizes
	 */
	@SuppressWarnings("unchecked")
	public ArrayLinearList(int requestedSize) {
		if (requestedSize > LinearListADT.DEFAULT_MAX_CAPACITY)
			storage = (E[]) new Comparable[LinearListADT.DEFAULT_MAX_CAPACITY];
		else
			storage = (E[]) new Comparable[requestedSize];
		this.currentSize = 0;
		this.headIdx = 0;
		this.tailIdx = 0;
		this.modificationCounter = 0;
	}

	/*
	 * Outputs "Front: indexFront Rear: indexRear"
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
	public boolean addFirst(E obj) {
		if (this.isFull())
			return false;
		if (!this.isEmpty())
			this.headIdx = (--this.headIdx + this.storage.length) % this.storage.length;
		this.storage[this.headIdx] = obj;
		this.currentSize++;
		this.modificationCounter++;
		return true;
	}

	/*
	 * Adds the Object obj to the end of list and returns true if the list is not
	 * full. returns false and aborts the insertion if the list is full.
	 */
	@Override
	public boolean addLast(E obj) {
		if (this.isFull())
			return false;
		if (!this.isEmpty())
			this.tailIdx = (++this.tailIdx + this.storage.length) % this.storage.length;
		this.storage[this.tailIdx] = obj;
		this.currentSize++;
		this.modificationCounter++;
		return true;
	}

	/*
	 * Removes and returns the parameter object obj in first position in list if the
	 * list is not empty, null if the list is empty.
	 */
	@Override
	public E removeFirst() {
		if (this.isEmpty())
			return null;
		
		E itemToReturn = this.storage[this.headIdx];
		this.storage[this.headIdx] = null;
		
		if (this.size() > 1)
			this.headIdx = (++this.headIdx + this.storage.length) % this.storage.length;
		this.currentSize--;
		this.modificationCounter++;
		return itemToReturn;
	}

	/*
	 * Removes and returns the parameter object obj in last position in list if the
	 * list is not empty, null if the list is empty.
	 */
	@Override
	public E removeLast() {
		if (this.isEmpty())
			return null;
		
		E itemToReturn = this.storage[this.tailIdx];
		this.storage[this.tailIdx] = null;
		
		if (this.size() > 1)
			this.tailIdx = (--this.tailIdx + this.storage.length) % this.storage.length;
		this.currentSize--;
		this.modificationCounter++;
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
	public E remove(E obj) {
		boolean isFound = false;
		int idx = 0;
		int curr, next;
		E itemToReturn = null;

		while (!isFound && idx < this.size()) {
			curr = (this.headIdx + idx + this.storage.length) % this.storage.length;

			if (this.storage[curr].compareTo(obj) == 0) {
				itemToReturn = this.storage[curr];
				isFound = true;
				break;
			}
			idx++;
		}

		if (isFound) {
			if (this.size() - idx < idx + 1) {
				while (idx < this.size() - 1) {
					curr = (this.headIdx + idx + this.storage.length) % this.storage.length;
					next = (this.headIdx + ++idx + this.storage.length) % this.storage.length;
					this.storage[curr] = this.storage[next];
				}
				this.tailIdx = (--this.tailIdx + this.storage.length) % this.storage.length;
			} else {
				while (idx > 0) {
					curr = (this.headIdx + idx + this.storage.length) % this.storage.length;
					next = (this.headIdx + --idx + this.storage.length) % this.storage.length;
					this.storage[curr] = this.storage[next];
				}
				this.headIdx = (++this.headIdx + this.storage.length) % this.storage.length;
			}
			this.currentSize--;
			this.modificationCounter++;
		}
		return itemToReturn;
	}

	/*
	 * Returns the first element in the list, null if the list is empty. The list is
	 * not modified.
	 */
	@Override
	public E peekFirst() {
		if (this.isEmpty())
			return null;
		return this.storage[this.headIdx];
	}

	/*
	 * Returns the last element in the list, null if the list is empty. The list is
	 * not modified.
	 */
	@Override
	public E peekLast() {
		if (this.isEmpty())
			return null;
		return this.storage[this.tailIdx];
	}

	/*
	 * Returns true if the parameter object obj is in the list, false otherwise. The
	 * list is not modified.
	 */
	@Override
	public boolean contains(E obj) {
		for (E item : this.storage) {
			if (item.compareTo(obj) == 0)
				return true;
		}
		return false;
	}

	/*
	 * Returns the element matching obj if it is in the list, null otherwise. In the
	 * case of duplicates, this method returns the element closest to front. The
	 * list is not modified.
	 */
	@Override
	public E find(E obj) {
		for (E item : this.storage) {
			if (item.compareTo(obj) == 0)
				return item;
		}
		return null;
	}

	/*
	 * The list is returned to an empty state.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		this.storage = (E[]) new Comparable[this.storage.length];
		this.currentSize = 0;
		this.headIdx = 0;
		this.tailIdx = 0;
		this.modificationCounter = 0; // should this be ++?
	}

	/*
	 * Returns true if the list is empty, otherwise false
	 */
	@Override
	public boolean isEmpty() {
		return this.currentSize == 0;
	}

	/*
	 * Returns true if the list is full, otherwise false
	 */
	@Override
	public boolean isFull() {
		return this.currentSize == storage.length;
	}

	/*
	 * Returns the number of Objects currently in the list.
	 */
	@Override
	public int size() {
		return this.currentSize;
	}

	/*
	 * Returns an Iterator of the values in the list, presented in the same order as
	 * the underlying order of the list. (front first, rear last)
	 */
	@Override
	public Iterator<E> iterator() {
		return new IteratorHelper();
	}

	class IteratorHelper implements Iterator<E> {
		int iterIndex;
		long stateCheck;

		public IteratorHelper() {
			this.iterIndex = 0;
			this.stateCheck = modificationCounter;
		}

		@Override
		public boolean hasNext() {
			if (this.stateCheck != modificationCounter)
				throw new ConcurrentModificationException();
			return this.iterIndex < currentSize;
		}

		@Override
		public E next() {
			if (!hasNext())
				throw new NoSuchElementException();
			E itemToReturn = storage[(headIdx + this.iterIndex++ + storage.length) % storage.length];
			return itemToReturn;
		}
	}
}
