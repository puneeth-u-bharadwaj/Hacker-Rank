package algorithms.implementation;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ManasaAndStones {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			Set<Long> answer = ManasaandStones(in.nextLong(), in.nextLong(), in.nextLong());
			Iterator<Long> iterator = answer.iterator();
			while (iterator.hasNext()) {
				System.out.printf("%d ", iterator.next());
			}
			System.out.println();
		}
		in.close();
	}

	private static Set<Long> ManasaandStones(long n, long a, long b) {
		if (a > b) {
			long temp = b;
			b = a;
			a = temp;
		}
		Set<Long> hs = new TreeSet<Long>();
		for (int i = 0; i <= n - 1; i++) {
			hs.add(i * b + (n - 1 - i) * a);
		}
		return hs;
	}

}