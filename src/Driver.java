import data_structures.*;

public class Driver {
	private static final int SIZE = 10;
	private static LinearListADT<Integer> list;
	private static final int TEST_LOOP_COUNT = SIZE + 1;

	public static void main(String[] args) {
		System.out.println("Requested new list of size " + SIZE);
		list = new ArrayLinearList<Integer>(SIZE);
		System.out.println("Sucessfully created a new list");
		verboseTest(list);
		runTests(list);
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
	}

	private static void runTests(LinearListADT<Integer> list) {
		for (int i = 1; i <= SIZE; i++)
			list.addFirst(i);
		System.out.println("Should now print SIZE .. 1");
		for (Integer i : list)
			System.out.println(i);
		for (int i = 1; i <= SIZE; i++)
			if (list.removeFirst() == null)
				throw new RuntimeException("ERROR with removeFirst");
		for (Integer i : list)
			System.out.println(i);

		if (!list.isEmpty())
			throw new RuntimeException("ERROR in isEmpty");
		if (list.size() != 0)
			throw new RuntimeException("ERROR in size");

		for (int i = 1; i <= 100 * SIZE; i++) {
			for (int j = 1; j <= SIZE; j++)
				list.addFirst(j);
			for (int j = 1; j <= SIZE; j++)
				list.removeLast();
		}

		for (int i = 1; i <= 100 * SIZE; i++) {
			for (int j = 1; j <= SIZE; j++)
				list.addLast(j);
			for (int j = 1; j <= SIZE; j++)
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
		for (int i = 1; i <= SIZE; i++)
			list.addFirst(i);

		for (int i = 1; i <= SIZE; i++)
			if (list.find(i) != i)
				throw new RuntimeException("ERROR in find");
			else
				System.out.println("FOUND " + i);

		for (int i = 1; i <= SIZE; i++)
			if (!list.contains(i))
				throw new RuntimeException("ERROR in find");

		list.clear();
		for (int i = 1; i <= SIZE; i++)
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
		for (int i = 1; i <= SIZE / 2; i++) {
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
