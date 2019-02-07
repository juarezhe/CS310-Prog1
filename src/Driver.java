import data_structures.ArrayLinearList;

public class Driver {
	private static final int SIZE1 = -1;
	private static final int SIZE2 = 3;
	private static final String SIZE3 = "default";
	private static final int SIZE4 = 101;
	private static final double SIZE5 = 2147483647.0;

	public static void main(String[] args) {
		// Test constructors
		System.out.println("Requested\t| Size: " + SIZE1);
		ArrayLinearList<String> list1 = new ArrayLinearList<String>(SIZE1);
		testVerbose(list1);

		System.out.println("Requested\t| Size: " + SIZE2);
		ArrayLinearList<String> list2 = new ArrayLinearList<String>(SIZE2);
		testVerbose(list2);

		System.out.println("Requested\t| Size: " + SIZE3);
		ArrayLinearList<String> list3 = new ArrayLinearList<String>();
		testSimple(list3);

		System.out.println("Requested\t| Size: " + SIZE4);
		ArrayLinearList<String> list4 = new ArrayLinearList<String>(SIZE4);
		testSimple(list4);
		
		System.out.println("Requested\t| Size: " + SIZE5);
		ArrayLinearList<String> list5 = new ArrayLinearList<String>((int) SIZE5);
		testSimple(list5);
	}

	private static void testSimple(ArrayLinearList<String> list) {
		System.out.print("Initial state\t| ");
		printInfo(list);
		while (!list.isFull())
			list.addLast("a");
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

	private static void testVerbose(ArrayLinearList<String> list) {
		System.out.print("Initial state\t| ");
		printInfo(list);
		while (!list.isFull())
			addFirstTest(list, "a");
		addFirstTest(list, "a");
		addLastTest(list, "b");
		System.out.print("Final state\t| ");
		printInfo(list);

		list.clear();
		System.out.println("Clear");

		System.out.print("Initial state\t| ");
		printInfo(list);
		while (!list.isFull())
			addLastTest(list, "b");
		addFirstTest(list, "a");
		addLastTest(list, "b");
		System.out.print("Final state\t| ");
		printInfo(list);
		System.out.println();
	}

	private static void printInfo(ArrayLinearList<String> list) {
		System.out.print("Size: " + list.size() + "\t| ");
		list.ends();
	}

	private static void addFirstTest(ArrayLinearList<String> list, String item) {
		if (list.addFirst(item))
			System.out.print("addFirst success| ");
		else
			System.out.print("addFirst failure| ");
		printInfo(list);
	}

	private static void addLastTest(ArrayLinearList<String> list, String item) {
		if (list.addLast(item))
			System.out.print("addLast success\t| ");
		else
			System.out.print("addLast failure\t| ");
		printInfo(list);
	}

}
