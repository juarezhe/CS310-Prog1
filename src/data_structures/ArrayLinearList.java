package data_structures;

import java.util.Iterator;

public class ArrayLinearList<T> implements LinearListADT<T> {
	
	private int objectCount, headIdx, tailIdx;
	
	public ArrayLinearList() {
		// Default constructor
		// Create array of size DEFAULT_MAX_CAPACITY
		this.objectCount = 0;
		this.headIdx = -1;
		this.tailIdx = -1;
	}
	
	public ArrayLinearList(int maxCapacity) {
		// Custom constructor
		// Create array of size maxCapacity
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addLast(T obj) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
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
