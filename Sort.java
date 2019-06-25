
//-----------------------------------------------------
//Description: This class has selection, insertion, shell, bubble sort methods, shuffle method and a method that produce random numbers and add them to the linked list.
//-----------------------------------------------------
import edu.princeton.cs.algs4.StdRandom;
import java.lang.*;

public class Sort {

	static void ProduceNum(linklist<Integer> a, int num, int max)
	// --------------------------------------------------------
	// Summary: produce num number between 0 and max and add them to linked list
	// a.
	// Precondition: a is an integer linked list and num and max are
	// integers.
	// Postcondition: a is an integer unordered linked list with num number and
	// the numbers are between 0 and max.
	// ------------------------------------------------------
	{
		for (int i = 0; i < num; i++) {
			// produce random numbers by using math random.
			a.add((int) (Math.random() * max));
		}
	}

	static void Selection(linklist<Integer> a)
	// --------------------------------------------------------
	// Summary: order the numbers in linked list by using selection sort. Using
	// two loop gets number
	// sequentially and finds the minimum number in the right side of the number
	// that we get and swap them.
	// Precondition: a is an unordered integer linked list.
	// Postcondition: a is an integer ordered linked list.
	// ------------------------------------------------------
	{
		// finds the size of a.
		int N = a.size();
		for (int i = 0; i < N; i++) {
			// assign min to i th index.
			int min = i;
			for (int j = i + 1; j < N; j++)
				// compare jth number to minth number and if jth number is less
				// than minth number. assigns j to min.
				if (a.get(j) < a.get(min))
					min = j;
			// exchange ith and minth number.
			exch(a, i, min);
		}

	}

	public static void Insertion(linklist<Integer> a)
	// --------------------------------------------------------
	// Summary: order the numbers in linked list by using insertion sort. Using
	// two loop gets number
	// sequentially and checks the number that is left side of the number that
	// we get and if the number that we get
	// is less than the number that we check, we swap them.
	// Precondition: a is an unordered integer linked list.
	// Postcondition: a is an integer ordered linked list.
	// ------------------------------------------------------
	{
		// finds the size of a.
		int N = a.size();
		for (int i = 0; i < N; i++)
			for (int j = i; j > 0; j--)
				if (a.get(j) < a.get(j - 1))
					exch(a, j, j - 1);
				else
					break;
	}

	public static void Shell(linklist<Integer> a)
	// --------------------------------------------------------
	// Summary: order the numbers in linked list by using shell sort. We use
	// powers of two minus one increment sequence. Firstly, using a loop we find
	// larger number that is less then size of the linked list and this number
	// is powers of two minus one increment sequence. Using three loop gets
	// number
	// sequentially starting from hth number and checks the number that is h
	// number left of the number that we get and if the number that we get
	// is less than the number that we check, we swap them. Them decrease h by
	// log_2(h).
	// Precondition: a is an unordered integer linked list.
	// Postcondition: a is an integer ordered linked list.
	// ------------------------------------------------------
	{
		int N = a.size();
		int h = 1;
		int x = 0;
		while (h < Math.log(N) / Math.log(2)) {
			h = (int) Math.pow(2, x) + 1;
			x++;
		}
		while (h >= 1) {
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h && a.get(j) < a.get(j - h); j -= h)
					exch(a, j, j - h);
			}
			h = (int) (Math.log(h) / Math.log(2));
		}
	}

	public static void Bubble(linklist<Integer> a)
	// --------------------------------------------------------
	// Summary: order the numbers in linked list by using bubble. Using two loop
	// gets number
	// sequentially and checks the number that is right side of the number that
	// we get and if the number that we get
	// is less than the number that we check, we swap them.
	// Precondition: a is an integer unordered linked list.
	// Postcondition: a is an integer ordered linked list.
	// ------------------------------------------------------
	{
		int N = a.size();
		for (int i = 0; i < N-1; i++) {
			for (int j = 0; j < N-i-1; j++) {
				if (a.get(j + 1) < a.get(j)) {
					exch(a, j + 1, j);
				}
			}
		}

	}

	public static void shuffle(linklist<Integer> a)
	// --------------------------------------------------------
	// Summary: shuffle the numbers in linked list. Using a loop gets number
	// sequentially and produce a random number between 0 and the index of the
	// number that we get. swap them.
	// Precondition: a is an integer ordered linked list.
	// Postcondition: a is an integer unordered linked list.
	// ------------------------------------------------------
	{
		int N = a.size();
		for (int i = 0; i < N; i++) {
			int r = StdRandom.uniform(i + 1);
			exch(a, i, r);
		}
	}

	private static void exch(linklist<Integer> a, int i, int j)
	// --------------------------------------------------------
	// Summary: swap the ith number and jth number.
	// Precondition: a is an integer ordered linked list and i and j is an
	// integer.
	// Postcondition: ith number is in jth place and jth number is in ith place
	// of the linked list
	// ------------------------------------------------------
	{
		Integer ith = a.get(i);
		Integer jth = a.get(j);
		a.addTo(jth, i);
		a.remove(i + 1);
		a.addTo(ith, j);
		a.remove(j + 1);
	}

	static boolean isSorted(linklist<Integer> a)
	// --------------------------------------------------------
	// Summary: checks whether linked list sorted or not.
	// --------------------------------------------------------
	{
		for (int i = 1; i < a.size(); i++)
			if (a.get(i) < a.get(i - 1))
				return false;
		return true;
	}

}
