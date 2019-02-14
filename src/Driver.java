import data_structures.*;

public class Driver {
	private static final int LIST_SIZE = 10;
	private static LinearListADT<Integer> list;
	private static final int TEST_LOOP_COUNT = LIST_SIZE + 1;

	public static void main(String[] args) {
		System.out.println("Requested new list of size " + LIST_SIZE);
		list = new ArrayLinearList<Integer>(LIST_SIZE);
		System.out.println("Successfully created a new list");
		verboseTest(list);
		runTests(list);
		iterTest(list);
	}

	/*
	 * Print the current size and ends of list.
	 */
	private static void printInfo(LinearListADT<Integer> list) {
		System.out.print("Size: " + list.size() + "\t| ");
		list.ends();
	}

	/*
	 * Add to front until full, alternate removal from back and addition to front
	 * several times, remove from back until empty, add to front once (to test index
	 * reset). Clear list and repeat in reverse.
	 */
	private static void verboseTest(LinearListADT<Integer> list) {
		System.out.print("Initial state\t| ");
		printInfo(list);

		for (int i = 1; i <= TEST_LOOP_COUNT; i++) {
			if (list.addFirst(i)) {
				System.out.print("addFirst: " + i + "\t| ");
				printInfo(list);
			} else {
				if (list.isFull())
					System.out.println("addFirst failed: list full");
				else
					System.out.println("addFirst failed: unknown reason");
			}
		}

		for (int i = 1; i <= TEST_LOOP_COUNT; i++) {
			Integer item = list.removeLast();
			if (item == null) {
				if (list.isEmpty())
					System.out.println("removeLast failed: list empty");
				else
					System.out.println("removeLast failed: unknown reason");
			} else {
				System.out.print("removeLast: " + item + "\t| ");
				printInfo(list);
			}
		}

		for (int i = 1; i <= TEST_LOOP_COUNT; i++) {
			if (list.addLast(i)) {
				System.out.print("addLast: " + i + "\t| ");
				printInfo(list);
			} else {
				if (list.isFull())
					System.out.println("addLast failed: list full");
				else
					System.out.println("addLast failed: unknown reason");
			}
		}
		
		System.out.println("Should print 1 through n:");
		for (Object obj : list)
			System.out.print(obj + ", ");
		System.out.println();

		for (int i = 1; i <= LIST_SIZE / 2; i++) {
			System.out.print("removed: " + list.remove(i) + "\t| ");
			printInfo(list);

			if (list.addLast(i)) {
				System.out.print("addLast: " + i + "\t| ");
				printInfo(list);
			} else
				System.out.println("addLast failed");
		}

		System.out.println("Should print n/2+1 through n, 1 through n/2:");
		for (Object obj : list)
			System.out.print(obj + ", ");
		System.out.println();

		for (int i = 1; i <= TEST_LOOP_COUNT; i++) {
			Integer item = list.removeFirst();
			if (item == null) {
				if (list.isEmpty())
					System.out.println("removeFirst failed: list empty");
				else
					System.out.println("removeFirst failed: unknown reason");
			} else {
				System.out.print("removeFirst " + item + "\t| ");
				printInfo(list);
			}
		}

		if (list.addFirst(1)) {
			System.out.print("addFirst 1\t| ");
			printInfo(list);
		}
		System.out.print("removeLast " + list.removeLast() + "\t| ");
		printInfo(list);

		System.out.println("Note: check front and rear indices");
	}

	/*
	 * Instructor-provided tests
	 */
	private static void runTests(LinearListADT<Integer> list) {
		for (int i = 1; i <= LIST_SIZE; i++)
			list.addFirst(i);

		System.out.println("\nShould print n through 1:");
		for (Integer i : list)
			System.out.print(i + ", ");
		System.out.println();

		for (int i = 1; i <= LIST_SIZE; i++)
			if (list.removeFirst() == null)
				throw new RuntimeException("ERROR with removeFirst");
		for (Integer i : list)
			System.out.println(i);

		if (!list.isEmpty())
			throw new RuntimeException("ERROR in isEmpty");
		if (list.size() != 0)
			throw new RuntimeException("ERROR in size");

		for (int i = 1; i <= 100 * LIST_SIZE; i++) {
			for (int j = 1; j <= LIST_SIZE; j++)
				list.addFirst(j);
			for (int j = 1; j <= LIST_SIZE; j++)
				list.removeLast();
		}

		for (int i = 1; i <= 100 * LIST_SIZE; i++) {
			for (int j = 1; j <= LIST_SIZE; j++)
				list.addLast(j);
			for (int j = 1; j <= LIST_SIZE; j++)
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

		for (int i = 1; i <= LIST_SIZE; i++)
			list.addFirst(i);

		for (int i = 1; i <= LIST_SIZE; i++)
			if (list.find(i) != i)
				throw new RuntimeException("ERROR in find");
			else
				System.out.println("FOUND " + i);

		for (int i = 1; i <= LIST_SIZE; i++)
			if (!list.contains(i))
				throw new RuntimeException("ERROR in find");

		list.clear();
		for (int i = 1; i <= LIST_SIZE; i++)
			list.addFirst(i);

		Integer tmp = list.remove(4);
		if (tmp == null)
			System.out.println("ERROR in remove");
		else
			System.out.println("removed " + tmp);

		System.out.println("Should print n through 1 except 4:");
		for (Integer i : list)
			System.out.println(i);

		System.out.println("Should print error in removing 4:");
		for (int i = 1; i <= LIST_SIZE / 2; i++) {
			tmp = list.remove(i);
			if (tmp == null)
				System.out.println("ERROR in remove");
			else
				System.out.println("removed " + tmp);
		}

		System.out.println("Should print n through n/2+1:");
		for (Integer i : list)
			System.out.println(i);
	}

	/*
	 * Test iterator index and ConcurrentModificationException
	 */
	private static void iterTest(LinearListADT<Integer> list) {
		list.clear();
		System.out.println();
		
		for (int i = 1; i <= LIST_SIZE; i++) {
			if (list.addFirst(i)) {
				System.out.print("addFirst: " + i + "\t| ");
				printInfo(list);
			} else {
				if (list.isFull())
					System.out.println("addFirst failed: list full");
				else
					System.out.println("addFirst failed: unknown reason");
			}
		}
		
		System.out.println("Should fail with ConcurrentModificationException after evaluating 3:");
		for (Integer obj : list) {
			if (obj.compareTo(3) == 0)
				list.remove(3);
			System.out.println("Evaluated " + obj);
		}
	}
}