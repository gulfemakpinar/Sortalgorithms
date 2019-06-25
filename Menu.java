
//-----------------------------------------------------
//Description: This class uses sort methods and shuffle method in sort class. 
//-----------------------------------------------------

import java.util.*;
import java.lang.*;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner g = new Scanner(System.in);

		// creates a linked list
		linklist<Integer> num = new linklist<Integer>();

		System.out.println(
				"1- Produce numbers\n2- Selection sort\n3- Insertion sort\n4- Shell sort\n5- Bubble Sort\n6- Shuffle\n7-To see all of them automaticly");
		System.out.print("Enter number from 1 to 7(To end the program enter 0):");

		// gets an integer from user.
		int i = g.nextInt();

		// if user does not enter 1 or 7 asks again.
		while (i != 1 && i != 7) {
			System.out.println("First you should produce numbers.");
			System.out.print("Enter number from 1 to 7(To end the program enter 0):");
			i = g.nextInt();
		}

		// until user enters 0 loop continues.
		while (i != 0) {

			// checks whether number is sorted or not before shuffling them if
			// they are not sorted ask again to sort them.
			while (i == 6 && !(Sort.isSorted(num))) {
				System.out.println("You should sort numbers before you shuffle them.");
				System.out.print("Enter number from 1 to 7(To end the program enter 0):");
				i = g.nextInt();
			}

			// checks whether number is sorted or not before sorting them if
			// they are sorted ask again to produce new numbers or shuffle them.
			while ((i == 2 || i == 3 || i == 4 || i == 5) && (Sort.isSorted(num))) {
				System.out.println("You should shuffle numbers or produce new numbers before you shuffle them.");
				System.out.print("Enter number from 1 to 7(To end the program enter 0):");
				i = g.nextInt();
			}

			// by using switch
			switch (i) {

			case 1:
				// if user enters 1 produce 10 numbers between 0 and 100 and add
				// them to num.
				System.out.println("Produced numbers:");
				num.removeAll();
				Sort.ProduceNum(num, 10, 100);
				break;

			case 2:
				// if user enters 2, use selection sort to order numbers in num.
				System.out.println("Ordered numbers:");
				Sort.Selection(num);
				break;

			case 3:
				// if user enters 3, uses insertion sort to order numbers in
				// num.
				System.out.println("Ordered numbers:");
				Sort.Insertion(num);
				break;

			case 4:
				// if user enters 4, uses shell sort to order numbers in num.
				System.out.println("Ordered numbers:");
				Sort.Shell(num);
				break;

			case 5:
				// if user enters 5, uses bubble sort to order numbers in num.
				System.out.println("Ordered numbers:");
				Sort.Bubble(num);
				break;

			case 6:
				// if user enters 6 shuffles numbers in num.
				System.out.println("Shuffled numbers:");
				Sort.shuffle(num);
				break;

			case 7:
				// do all the things above without entering any number.
				System.out.println("Produced numbers:");
				num.removeAll();
				Sort.ProduceNum(num, 10, 100);
				for (int s : num)
					System.out.println(s);
				System.out.println("Ordered numbers(Selection):");
				Sort.Selection(num);
				for (int s : num)
					System.out.println(s);

				System.out.println("Produced numbers:");
				num.removeAll();
				Sort.ProduceNum(num, 10, 100);
				for (int s : num)
					System.out.println(s);
				System.out.println("Ordered numbers(Insertion):");
				Sort.Insertion(num);
				for (int s : num)
					System.out.println(s);

				System.out.println("Produced numbers:");
				num.removeAll();
				Sort.ProduceNum(num, 10, 100);
				for (int s : num)
					System.out.println(s);
				System.out.println("Ordered numbers(Shell):");
				Sort.Shell(num);
				for (int s : num)
					System.out.println(s);

				System.out.println("Produced numbers:");
				num.removeAll();
				Sort.ProduceNum(num, 10, 100);
				for (int s : num)
					System.out.println(s);
				System.out.println("Ordered numbers(Bubble):");
				Sort.Bubble(num);
				for (int s : num)
					System.out.println(s);

				System.out.println("Shuffled numbers:");
				Sort.shuffle(num);
				break;

			}

			// prints all items in num.
			for (int s : num)
				System.out.println(s);
			System.out.print("Enter number from 1 to 7(To end the program enter 0):");
			i = g.nextInt();

		}
		// exits the program.
		System.exit(0);
		;

	}

}
