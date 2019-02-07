import data_structures.ArrayLinearList;

public class Driver {

	public static void main(String[] args) {
		// Test constructors
		ArrayLinearList<String> list1 = new ArrayLinearList<String>(-1);
		// printInfo(list1);

		ArrayLinearList<String> list2 = new ArrayLinearList<String>(3);
		// printInfo(list2);

		ArrayLinearList<String> list3 = new ArrayLinearList<String>();
		// printInfo(list3);

		ArrayLinearList<String> list4 = new ArrayLinearList<String>(101);
		// printInfo(list4);

		// Fill each list and test over-fill
		testVerbose(list1);
		testVerbose(list2);
		testSimple(list3);
		testSimple(list4);
	}
	
	private static void testSimple(ArrayLinearList<String> list) {
		System.out.print("Initial state    | ");
		printInfo(list);
		while (!list.isFull())
			list.addLast("a");
		System.out.print("Final state      | ");
		printInfo(list);
		System.out.println();
	}
	
	private static void testVerbose(ArrayLinearList<String> list) {
		System.out.print("Initial state    | ");
		printInfo(list);
		while (!list.isFull())
			addFirstTest(list, "a");
		addFirstTest(list, "a");
		addLastTest(list, "b");
		System.out.print("Final state      | ");
		printInfo(list);

		list.clear();
		System.out.println("Clear");

		System.out.print("Initial state    | ");
		printInfo(list);
		while (!list.isFull())
			addLastTest(list, "b");
		addFirstTest(list, "a");
		addLastTest(list, "b");
		System.out.print("Final state      | ");
		printInfo(list);
		System.out.println();
	}

	private static void printInfo(ArrayLinearList<String> list) {
		System.out.print("Size: " + list.size() + " | ");
		list.ends();
	}

	private static void addFirstTest(ArrayLinearList<String> list, String item) {
		if (list.addFirst(item))
			System.out.print("addFirst success | ");
		else
			System.out.print("addFirst failure | ");
		printInfo(list);
	}

	private static void addLastTest(ArrayLinearList<String> list, String item) {
		if (list.addLast(item))
			System.out.print("addLast success  | ");
		else
			System.out.print("addLast failure  | ");
		printInfo(list);
	}

}
