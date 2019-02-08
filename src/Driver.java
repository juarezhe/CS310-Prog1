import data_structures.*;

public class Driver {
	private static final Object[] SIZES = { -10, "default", 101, 2147483647, 7.0, 3 };
	private static LinearListADT<String> list;

	public static void main(String[] args) {
		for (Object curr : SIZES) {
			System.out.println("Requested\t| Size: " + curr);

			try {
				int size = Integer.parseInt(curr.toString());
				list = new ArrayLinearList<String>(size);
				if (size > 5 || size < -5)
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
	private static void printInfo(LinearListADT<String> list) {
		System.out.print("Size: " + list.size() + "\t| ");
		list.ends();
	}

	/*
	 * Recommended for larger lists.
	 * 
	 * Add to front until full, clear list, then add to back until full.
	 */
	private static void simpleTest(LinearListADT<String> list) {
		System.out.print("Initial state\t| ");
		printInfo(list);
		while (!list.isFull())
			list.addFirst("a");
		System.out.print("Final state\t| ");
		printInfo(list);

		list.clear();
		System.out.println("Clear");

		System.out.print("Initial state\t| ");
		printInfo(list);
		while (!list.isFull())
			list.addLast("b");
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
	private static void verboseTest(LinearListADT<String> list) {
		System.out.print("Initial state\t| ");
		printInfo(list);
		while (!list.isFull())
			addFirstTest(list);
		addFirstTest(list);
		for (int n = 0; n < 3; n++) {
			removeLastTest(list);
			addFirstTest(list);
		}
		while (!list.isEmpty())
			removeLastTest(list);
		removeLastTest(list);
		addFirstTest(list);
		System.out.print("Final state\t| ");
		printInfo(list);

		list.clear();
		System.out.println("Clear");

		System.out.print("Initial state\t| ");
		printInfo(list);
		while (!list.isFull())
			addLastTest(list);
		addLastTest(list);
		for (int n = 0; n < 3; n++) {
			removeFirstTest(list);
			addLastTest(list);
		}
		while (!list.isEmpty())
			removeFirstTest(list);
		removeFirstTest(list);
		addLastTest(list);
		System.out.print("Final state\t| ");
		printInfo(list);
		System.out.println();
	}

	/*
	 * Add item to front, print success or failure of each add + state of list
	 */
	private static void addFirstTest(LinearListADT<String> list) {
		String item = "a";
		if (list.addFirst(item))
			System.out.print("addFirst \"" + item + "\"\t| ");
		else
			System.out.print("addFirst fail\t| ");
		printInfo(list);
	}

	/*
	 * Add item to back, print success or failure of each add + state of list
	 */
	private static void addLastTest(LinearListADT<String> list) {
		String item = "b";
		if (list.addLast(item))
			System.out.print("addLast \"" + item + "\"\t| ");
		else
			System.out.print("addLast fail\t| ");
		printInfo(list);
	}

	private static void removeFirstTest(LinearListADT<String> list) {
		String item = list.removeFirst();
		if (item == null)
			System.out.print("removeFirst fail| ");
		else
			System.out.print("removeFirst \"" + item + "\"\t| ");
		printInfo(list);
	}

	private static void removeLastTest(LinearListADT<String> list) {
		String item = list.removeLast();
		if (item == null)
			System.out.print("removeLast fail\t| ");
		else
			System.out.print("removeLast \"" + item + "\"\t| ");
		printInfo(list);
	}

}
