package com.ds.java.string;

/**
 * H                  s
 *   e              d
 *     l          l
 *       l      r
 *         o  o
 *           w
 *         o  o
 *       l      r
 *     l          l
 *   e              d
 * H                  s
 */
public class StringX {
	public static void main(String[] args) {
		print("Helloworlds");

	}

	static void print(String s) {
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < s.length(); j++) {
				if (i == j || i + j == s.length() - 1)
					System.out.print(s.charAt(j)); // i for mirror, j for same order X string
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}
}
