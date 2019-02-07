import data_structures.ArrayLinearList;

public class Driver {

	public static void main(String[] args) {
		// Test constructors
		ArrayLinearList<String> list1 = new ArrayLinearList<String>();
		printInfo(list1);
		ArrayLinearList<String> list2 = new ArrayLinearList<String>(3);
		printInfo(list2);
		ArrayLinearList<String> list3 = new ArrayLinearList<String>(-1);
		printInfo(list3);
		ArrayLinearList<String> list4 = new ArrayLinearList<String>(101);
		printInfo(list4);
	}
	
	private static void printInfo(ArrayLinearList<String> list) {
		list.size();
		list.ends();
	}

}
