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

	@Override
	public void ends() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean addFirst(T obj) {
		// If full, return false
		// If empty, add item at location [0]
		// Otherwise, decrement headIdx and add item (use modulo for wrap around)
		// Increment objectCount and return true
		return false;
	}

	@Override
	public boolean addLast(T obj) {
		// If full, return false
		// If empty, add item at location [0]
		// Otherwise, increment tailIdx and add item (use modulo for wrap around)
		// Increment objectCount and return true
		return false;
	}

	@Override
	public T removeFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T removeLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T remove(T obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T peekFirst() {
		// if (!this.isEmpty())
		// return first item
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T peekLast() {
		// TODO Auto-generated method stub
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
