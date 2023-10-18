import java.util.InputMismatchException;
import java.util.Scanner;

public class DoublyLinkedListDriver {
	public static void main(String[] args) {

		DoublyLinkedList<Integer> listI = new DoublyLinkedList<Integer>();
		// 'Integer' List Example:
		// 1 3 5 8 10 12 20
		listI.insertItem(1);
		listI.insertItem(3);
		listI.insertItem(5);
		listI.insertItem(8);
		listI.insertItem(10);
		listI.insertItem(12);
		listI.insertItem(20);

		DoublyLinkedList<Double> listD = new DoublyLinkedList<Double>();
		// 'Double' List Example:
		// 3.1 9.6 19.3 37.3 45.9 63.5 84.5 100.7
		listD.insertItem(3.1);
		listD.insertItem(9.6);
		listD.insertItem(19.3);
		listD.insertItem(37.3);
		listD.insertItem(45.9);
		listD.insertItem(63.5);
		listD.insertItem(84.5);
		listD.insertItem(100.7);

		DoublyLinkedList<String> listS = new DoublyLinkedList<String>();
		// 'String' List Example:
		// Craig Dern Ford Goodman Macy
		listS.insertItem("Craig");
		listS.insertItem("Dern");
		listS.insertItem("Ford");
		listS.insertItem("Goodman");
		listS.insertItem("Macy");
		
		DoublyLinkedList<Integer> list0 = null;
		DoublyLinkedList<Double> list1 = null;
		DoublyLinkedList<String> list2 = null;

		Scanner userIn = new Scanner(System.in);
		String COMMAND = "-1";

		System.out.print("Enter list type (i - int, d - double, s - string): ");
		COMMAND = userIn.nextLine();
		
		// Use 'valid' to skip over asking to "Enter a command" if the previous one was invalid
		// Also use to run through this 'while-loop'
		boolean valid = true;
		while (valid) {
			if (COMMAND.equals("i")) {
				list0 = listI;
				break;
			} else if (COMMAND.equals("d")) {
				list1 = listD;
				break;
			} else if (COMMAND.equals("s")) {
				list2 = listS;
				break;
			} else if (COMMAND.equals("q")){
				System.out.println("Exiting the program...");
				userIn.close();
				System.exit(0);
			} else {
				System.out.print("Invalid command try again: ");
				COMMAND = userIn.nextLine();
			}
		}

		System.out.println("Commands:\n"
				+ "(i) - Insert value\n"
				+ "(d) - Delete value\n"
				+ "(p) - Print List\n"
				+ "(l) - Length\n"
				+ "(t) - Print Reverse\n"
				+ "(r) - Reverse List\n"
				+ "(b) - Delete Subsection\n"
				+ "(s) - Swap Alternate\n"
				+ "(q) - Quit program");
		
		if (list0 != null) {
			while (!COMMAND.equals("q")) {
				if (valid) {
					System.out.print("Enter a command: ");
					COMMAND = userIn.nextLine();
				}

				valid = true;
				if (COMMAND.equals("i")) {
					System.out.print("The list is: "); list0.print();
					System.out.print("Enter a number to insert: ");
					try {
						int subCOMMAND = userIn.nextInt();
						// Consume the newline char
						userIn.nextLine();
						list0.insertItem(subCOMMAND);
						System.out.print("The list is: "); list0.print();
						System.out.print("The reverse list: "); list0.printReverse();
					} catch (InputMismatchException e) {
						System.out.println("Must imput an Integer!");
						userIn.nextLine();
					}
				} else if (COMMAND.equals("d")) {
					System.out.print("The list is: "); list0.print();
					System.out.print("Enter a number to delete: ");
					try {
						int subCOMMAND = userIn.nextInt();
						// Consume the newline char
						userIn.nextLine();
						list0.deleteItem(subCOMMAND);
						System.out.print("The list is: "); list0.print();
						System.out.print("The reverse list: "); list0.printReverse();
					} catch (InputMismatchException e) {
						System.out.println("Must imput an Integer!");
						userIn.nextLine();
					}
				} else if (COMMAND.equals("p")) {
					System.out.print("The list is: "); list0.print();
				} else if (COMMAND.equals("l")) {
					System.out.println("The length of the list: " + list0.length());
				} else if (COMMAND.equals("t")) {
					System.out.print("The reverse list: "); list0.printReverse();
				} else if (COMMAND.equals("r")) {
					System.out.print("The original list: "); list0.print();
					list0.reverseList();
					System.out.print("The reversed list: "); list0.print();
					// System.out.print("The reverse list: "); list0.printReverse();
				} else if (COMMAND.equals("b")) {
					try {
						System.out.print("Enter the lower bound: ");
						int subCOMMAND_L = userIn.nextInt();
						userIn.nextLine();
						System.out.print("Enter the upper bound: ");
						int subCOMMAND_U = userIn.nextInt();
						userIn.nextLine();
						System.out.print("The original list: "); list0.print();
						list0.deleteSubsection(subCOMMAND_L, subCOMMAND_U);
						System.out.print("The modified list: "); list0.print();
						System.out.print("The reverse list: "); list0.printReverse();
					} catch (InputMismatchException e) {
						System.out.println("Must imput an Integer!");
						userIn.nextLine();
					}
				} else if (COMMAND.equals("s")) {
					System.out.print("The original list: "); list0.print();
					list0.swapAlternate();
					System.out.print("The modified list: "); list0.print();
					System.out.print("The reverse list: "); list0.printReverse();
				} else if (COMMAND.equals("q")) {
				} else {
					valid = false;
					System.out.print("Invalid command try again: ");
					COMMAND = userIn.nextLine();
				}
			}
			System.out.println("Exiting the program...");
			userIn.close();
			System.exit(0);
		} else if (list1 != null) {
			while (!COMMAND.equals("q")) {
				if (valid) {
					System.out.print("Enter a command: ");
					COMMAND = userIn.nextLine();
				}

				valid = true;
				if (COMMAND.equals("i")) {
					System.out.print("The list is: "); list1.print();
					System.out.print("Enter a number to insert: ");
					try {
						double subCOMMAND = userIn.nextDouble();
						// Consume the newline char
						userIn.nextLine();
						list1.insertItem(subCOMMAND);
						System.out.print("The list is: "); list1.print();
						System.out.print("The reverse list: "); list1.printReverse();
					} catch (InputMismatchException e) {
						System.out.println("Must imput a Double!");
						userIn.nextLine();
					}
				} else if (COMMAND.equals("d")) {
					System.out.print("The list is: "); list1.print();
					System.out.print("Enter a number to delete: ");
					try {
						double subCOMMAND = userIn.nextDouble();
						// Consume the newline char
						userIn.nextLine();
						list1.deleteItem(subCOMMAND);
						System.out.print("The list is: "); list1.print();
						System.out.print("The reverse list: "); list1.printReverse();
					} catch (InputMismatchException e) {
						System.out.println("Must imput a Double!");
						userIn.nextLine();
					}
				} else if (COMMAND.equals("p")) {
					System.out.print("The list is: "); list1.print();
				} else if (COMMAND.equals("l")) {
					System.out.println("The length of the list is: " + list1.length());
				} else if (COMMAND.equals("t")) {
					System.out.print("The reverse list: "); list1.printReverse();
				} else if (COMMAND.equals("r")) {
					System.out.print("The original list: "); list1.print();
					list1.reverseList();
					System.out.print("The reversed list: "); list1.print();
					// System.out.print("The reverse list: "); list1.printReverse();
				} else if (COMMAND.equals("b")) {
					try {
						System.out.print("Enter the lower bound: ");
						double subCOMMAND_L = userIn.nextDouble();
						userIn.nextLine();
						System.out.print("Enter the upper bound: ");
						double subCOMMAND_U = userIn.nextDouble();
						userIn.nextLine();
						System.out.print("The original list: "); list1.print();
						list1.deleteSubsection(subCOMMAND_L, subCOMMAND_U);
						System.out.print("The modified list: "); list1.print();
						System.out.print("The reverse list: "); list1.printReverse();
					} catch (InputMismatchException e) {
						System.out.println("Must imput a Double!");
						userIn.nextLine();
					}
				} else if (COMMAND.equals("s")) {
					System.out.print("The original list: "); list1.print();
					list1.swapAlternate();
					System.out.print("The modified list: "); list1.print();
					System.out.print("The reverse list: "); list1.printReverse();
				} else if (COMMAND.equals("q")) {
				} else {
					valid = false;
					System.out.print("Invalid command try again: ");
					COMMAND = userIn.nextLine();
				}
			}
			System.out.println("Exiting the program...");
			userIn.close();
			System.exit(0);
		} else if (list2 != null) {
			while (!COMMAND.equals("q")) {
				if (valid) {
					System.out.print("Enter a command: ");
					COMMAND = userIn.nextLine();
				}

				valid = true;
				if (COMMAND.equals("i")) {
					System.out.print("The list is: "); list2.print();
					System.out.print("Enter a string to insert: ");
					try {
						String subCOMMAND = userIn.nextLine();
						list2.insertItem(subCOMMAND);
						System.out.print("The list is: "); list2.print();
						System.out.print("The reverse list: "); list2.printReverse();
					} catch (InputMismatchException e) {
						System.out.println("Must imput a String!");
					}
				} else if (COMMAND.equals("d")) {
					System.out.print("The list is: "); list2.print();
					System.out.print("Enter a string to delete: ");
					try {
						String subCOMMAND = userIn.nextLine();
						list2.deleteItem(subCOMMAND);
						System.out.print("The list is: "); list2.print();
						System.out.print("The reverse list: "); list2.printReverse();
					} catch (InputMismatchException e) {
						System.out.println("Must imput a String!");
					}
				} else if (COMMAND.equals("p")) {
					System.out.print("The list is: "); list2.print();
				} else if (COMMAND.equals("l")) {
					System.out.println("The length of the list is: " + list2.length());
				} else if (COMMAND.equals("t")) {
					System.out.print("The reverse list: "); list2.printReverse();
				} else if (COMMAND.equals("r")) {
					System.out.print("The original list: "); list2.print();
					list2.reverseList();
					System.out.print("The reversed list: "); list2.print();
					// System.out.print("The reverse list: "); list2.printReverse();
				} else if (COMMAND.equals("b")) {
					// Please NOTE! : If you delete subsection 'a' - 'e' for example
					// this will not remove anything from the list as lower case comes
					// after upper case in the lexographic ordering of strings. This
					// would be equal to choosing a lower and upper bound both above
					// the highest ordered node (the tail). Use capital letters or
					// whole names/words for modification in a list of capital names.
					try {
						System.out.print("Enter the lower bound: ");
						String subCOMMAND_L = userIn.nextLine();
						System.out.print("Enter the upper bound: ");
						String subCOMMAND_U = userIn.nextLine();
						System.out.print("The original list: "); list2.print();
						list2.deleteSubsection(subCOMMAND_L, subCOMMAND_U);
						System.out.print("The modified list: "); list2.print();
						System.out.print("The reverse list: "); list2.printReverse();
					} catch (InputMismatchException e) {
						System.out.println("Must imput a String!");
					}
				} else if (COMMAND.equals("s")) {
					System.out.print("The original list: "); list2.print();
					list2.swapAlternate();
					System.out.print("The modified list: "); list2.print();
					System.out.print("The reverse list: "); list2.printReverse();
				} else if (COMMAND.equals("q")) {
				} else {
					valid = false;
					System.out.print("Invalid command try again: ");
					COMMAND = userIn.nextLine();
				}
			}
			System.out.println("Exiting the program...");
			userIn.close();
			System.exit(0);
		} else {
			System.out.println("There has been an unforseen error.");
			userIn.close();
			System.exit(0);
		}
	}
}
