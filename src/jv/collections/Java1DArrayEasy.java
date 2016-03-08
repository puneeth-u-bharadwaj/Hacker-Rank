package jv.collections;

import java.util.Scanner;

public class Java1DArrayEasy {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		int a[] = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			a[i] = in.nextInt() + a[i - 1];
		}

		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				if (a[j] - a[i] < 0) {
					count++;
				}
			}
		}

		System.out.println(count);

		in.close();
	}
}
