import data_structures.*;

public class Driver {
	private static final Object[] SIZES = { "default", 101, 2147483647, 7.0, -10 };
	private static LinearListADT<Integer> list;
	private static final int TEST_LOOP_COUNT = 11;
	private static final int VERBOSE_TEST_SIZE_MAX = 10;

	public static void main(String[] args) {
		for (Object curr : SIZES) {
			System.out.println("Requested\t| Size: " + curr);

			try {
				Integer size = Integer.parseInt(curr.toString());
				list = new ArrayLinearList<Integer>(size);
				if (size > VERBOSE_TEST_SIZE_MAX || size < -1 * VERBOSE_TEST_SIZE_MAX)
					simpleTest(list);
				else
					verboseTest(list);
			} catch (Exception e) {
				System.out.println("Failed to cast " + curr + " to int.");
				System.out.println();
			}
		}
		// TODO Add tests for peekFirst and peekLast
	}

	/*
	 * Print the current size and ends of list.
	 */
	private static void printInfo(LinearListADT<Integer> list) {
		System.out.print("Size: " + list.size() + "\t| ");
		list.ends();
	}

	/*
	 * Recommended for larger lists.
	 * 
	 * Add to front until full, clear list, then add to back until full.
	 */
	private static void simpleTest(LinearListADT<Integer> list) {
		System.out.print("Initial state\t| ");
		printInfo(list);
		while (!list.isFull())
			list.addFirst(1);
		System.out.print("Final state\t| ");
		printInfo(list);

		list.clear();
		System.out.println("Clear");

		System.out.print("Initial state\t| ");
		printInfo(list);
		while (!list.isFull())
			list.addLast(1);
		System.out.print("Final state\t| ");
		printInfo(list);
		System.out.println();
	}

	/*
	 * Recommended for smaller lists.
	 * 
	 * Add to front until full, alternate removal from back and addition to front
	 * several times, remove from back until empty, add to front once (to test index
	 * reset). Clear list and repeat in reverse.
	 */
	private static void verboseTest(LinearListADT<Integer> list) {
		System.out.print("Initial state\t| ");
		printInfo(list);
		for (int i = 1; i <= TEST_LOOP_COUNT; i++) {
			if (list.addLast(i))
				System.out.print("addLast " + i + "\t| ");
			else
				System.out.print("addLast fail\t| ");
			printInfo(list);
		}
		for (int i = 1; i <= TEST_LOOP_COUNT; i++) {
			Integer item = list.removeLast();
			if (item == null)
				System.out.print("removeLast fail\t| ");
			else
				System.out.print("removeLast " + item + "\t| ");
			printInfo(list);
		}
		for (int i = 1; i <= TEST_LOOP_COUNT; i++) {
			if (list.addLast(i))
				System.out.print("addLast " + i + "\t| ");
			else
				System.out.print("addLast fail\t| ");
			printInfo(list);
		}
		for (int i = 1; i <= TEST_LOOP_COUNT / 2; i++) {
			System.out.print("remove " + list.remove(i) + "\t| ");
			printInfo(list);
			list.addLast(i);
			System.out.print("addLast " + i + "\t| ");
			printInfo(list);
		}
		for (Integer i : list)
			System.out.println(i);
	
		for (int i = 1; i <= TEST_LOOP_COUNT; i++) {
			Integer item = list.removeFirst();
			if (item == null)
				System.out.print("removeFirst fail| ");
			else
				System.out.print("removeFirst " + item + "\t| ");
			printInfo(list);
		}
		
		list.addLast(1);
		System.out.print("Final state\t| ");
		printInfo(list);
		
		for (Integer i : list)
			System.out.println(i);

		list.clear();
		System.out.println("Clear");

		runTests(list);
	}
	
	private static void runTests(LinearListADT<Integer> list) {
		for (int i = 1; i <= 10; i++)
			list.addFirst(i);
		System.out.println("Should now print 10 .. 1");
		for (Integer i : list)
			System.out.println(i);
		for (int i = 1; i <= 10; i++)
			if (list.removeFirst() == null)
				throw new RuntimeException("ERROR with removeFirst");
		for (Integer i : list)
			System.out.println(i);

		if (!list.isEmpty())
			throw new RuntimeException("ERROR in inEmpty");
		if (list.size() != 0)
			throw new RuntimeException("ERROR in size");

		for (int i = 1; i <= 1000; i++) {
			for (int j = 1; j <= 7; j++)
				list.addFirst(j);
			for (int j = 1; j <= 7; j++)
				list.removeLast();
		}

		for (int i = 1; i <= 1000; i++) {
			for (int j = 1; j <= 7; j++)
				list.addLast(j);
			for (int j = 1; j <= 7; j++)
				list.removeFirst();
		}

		list.addFirst(-1);
		if (list.peekLast() != -1)
			throw new RuntimeException("ERROR in peekLast");
		list.clear();
		list.addLast(-1);
		if (list.peekFirst() != -1)
			throw new RuntimeException("ERROR in peekLast");

		list.clear();
		for (int i = 1; i <= 10; i++)
			list.addFirst(i);

		for (int i = 1; i <= 10; i++)
			if (list.find(i) != i)
				throw new RuntimeException("ERROR in find");
			else
				System.out.println("FOUND " + i);

		for (int i = 1; i <= 10; i++)
			if (!list.contains(i))
				throw new RuntimeException("ERROR in find");

		list.clear();
		for (int i = 1; i <= 10; i++)
			list.addFirst(i);
		//
		Integer tmp = list.remove(4);
		if (tmp == null)
			System.out.println("ERROR in remove");
		else
			System.out.println("removed " + tmp);
		for (Integer i : list)
			System.out.println(i);
		//
		for (int i = 1; i <= 5; i++) {
			tmp = list.remove(i);
			if (tmp == null)
				System.out.println("ERROR in remove");
			else
				System.out.println("removed " + tmp);
		}
		for (Integer i : list)
			System.out.println(i);
	}
}
