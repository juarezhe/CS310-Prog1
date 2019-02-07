import data_structures.ArrayLinearList;

public class Driver {
	private static final int SIZE1 = -1;
	private static final String SIZE2 = "default";
	private static final int SIZE3 = 101;
	private static final double SIZE4 = 2147483647.0;
	private static final int SIZE5 = 3;

	public static void main(String[] args) {
		// Test constructors
		System.out.println("Requested\t| Size: " + SIZE1);
		ArrayLinearList<String> list1 = new ArrayLinearList<String>(SIZE1);
		simpleTest(list1);

		System.out.println("Requested\t| Size: " + SIZE2);
		ArrayLinearList<String> list2 = new ArrayLinearList<String>();
		simpleTest(list2);

		System.out.println("Requested\t| Size: " + SIZE3);
		ArrayLinearList<String> list3 = new ArrayLinearList<String>(SIZE3);
		simpleTest(list3);

		System.out.println("Requested\t| Size: " + SIZE4);
		ArrayLinearList<String> list4 = new ArrayLinearList<String>((int) SIZE4);
		simpleTest(list4);

		System.out.println("Requested\t| Size: " + SIZE5);
		ArrayLinearList<String> list5 = new ArrayLinearList<String>(SIZE5);
		verboseTest(list5);
	}

	private static void simpleTest(ArrayLinearList<String> list) {
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

	private static void verboseTest(ArrayLinearList<String> list) {
		System.out.print("Initial state\t| ");
		printInfo(list);
		while (!list.isFull())
			addFirstTest(list);
		addFirstTest(list);
		for (int n = 0; n < SIZE5; n++) {
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
		for (int n = 0; n < SIZE5; n++) {
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

	private static void printInfo(ArrayLinearList<String> list) {
		System.out.print("Size: " + list.size() + "\t| ");
		list.ends();
	}

	private static void addFirstTest(ArrayLinearList<String> list) {
		String item = "a";
		if (list.addFirst(item))
			System.out.print("addFirst \"" + item + "\"\t| ");
		else
			System.out.print("addFirst fail\t| ");
		printInfo(list);
	}

	private static void addLastTest(ArrayLinearList<String> list) {
		String item = "b";
		if (list.addLast(item))
			System.out.print("addLast \"" + item + "\"\t| ");
		else
			System.out.print("addLast fail\t| ");
		printInfo(list);
	}

	private static void removeFirstTest(ArrayLinearList<String> list) {
		String item = list.removeFirst();
		if (item == null)
			System.out.print("removeFirst fail| ");
		else
			System.out.print("removeFirst \"" + item + "\"\t| ");
		printInfo(list);
	}

	private static void removeLastTest(ArrayLinearList<String> list) {
		String item = list.removeLast();
		if (item == null)
			System.out.print("removeLast fail\t| ");
		else
			System.out.print("removeLast \"" + item + "\"\t| ");
		printInfo(list);
	}

}
