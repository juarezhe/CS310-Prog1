package data_structures;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Program #1 Data structure for an unsorted list of max size 100
 * 
 * CS-310
 * 
 * 18 February 2019
 * 
 * @author Hannah Juarez cssc1481
 */

public class ArrayLinearList<E extends Comparable<E>> implements LinearListADT<E> {
	private E[] storage;
	private int currentSize, headIdx, tailIdx;
	private long modificationCounter;

	/*
	 * Default constructor
	 * 
	 * Calls custom constructor with default of 100.
	 */
	public ArrayLinearList() {
		this(100);
	}

	/*
	 * Custom constructor
	 * 
	 * Creates new array of Comparables and casts to E. Initializes indices and counters.
	 */
	@SuppressWarnings("unchecked")
	public ArrayLinearList(int requestedSize) {
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
		if (this.currentSize > 1)
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
		if (this.currentSize > 1)
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
		int index = 0;
		int curr, next;
		E itemToReturn = null;

		while (!isFound && index < this.currentSize) {
			curr = (this.headIdx + index + this.storage.length) % this.storage.length;

			if (this.storage[curr].compareTo(obj) == 0) {
				itemToReturn = this.storage[curr];
				isFound = true;
				break;
			}
			index++;
		}

		if (isFound) {
			if (this.currentSize - index < index + 1) {
				while (index < this.currentSize - 1) {
					curr = (this.headIdx + index + this.storage.length) % this.storage.length;
					next = (this.headIdx + ++index + this.storage.length) % this.storage.length;
					this.storage[curr] = this.storage[next];
				}
				this.tailIdx = (--this.tailIdx + this.storage.length) % this.storage.length;
			} else {
				while (index > 0) {
					curr = (this.headIdx + index + this.storage.length) % this.storage.length;
					next = (this.headIdx + --index + this.storage.length) % this.storage.length;
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
		return this.find(obj) != null;
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
		this.modificationCounter++;
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

	/*
	 * IteratorHelper class allows for tracking of changes since Iterator creation.
	 * Operates in fail-fast mode.
	 */
	private class IteratorHelper implements Iterator<E> {
		private int iterIndex;
		private long stateCheck;

		public IteratorHelper() {
			this.iterIndex = 0;
			this.stateCheck = modificationCounter;
		}

		/*
		 * Returns true if the list has a next item, false if not
		 */
		@Override
		public boolean hasNext() {
			if (this.stateCheck != modificationCounter)
				throw new ConcurrentModificationException();
			return this.iterIndex < currentSize;
		}

		/*
		 * If the list has a next item, that item is returned
		 */
		@Override
		public E next() {
			if (!hasNext())
				throw new NoSuchElementException();
			return storage[(headIdx + this.iterIndex++ + storage.length) % storage.length];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
