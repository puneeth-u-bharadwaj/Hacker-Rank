package algorithms.warmup;

/*
 * Problem Statement
 * Find Digits
 * https://www.hackerrank.com/challenges/find-digits
 */

public class FindDigits {

	public static void main(String[] args) {
		int arr[] = { 0 };
		int i = 0;
		int n = 1;
		while (n != 0) {
			arr[i] = n % 10;
			n /= 10;
			i++;
		}
	}
}
