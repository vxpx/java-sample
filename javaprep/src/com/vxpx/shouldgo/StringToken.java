package com.vxpx.shouldgo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class StringToken {
	Map<String, Integer> magazineMap;
	Map<String, Integer> noteMap;

	public StringToken(String magazine, String note) {

		magazineMap = new HashMap<String, Integer>();
		noteMap = new HashMap<String, Integer>();

		StringTokenizer token1 = new StringTokenizer(magazine, " ");
		StringTokenizer token2 = new StringTokenizer(note, " ");

		while (token1.hasMoreTokens()) {
			String str = token1.nextToken();

			Integer count = magazineMap.put(str, 1);
			if (count != null) {
				magazineMap.put(str, count + 1);
			}
		}

		while (token2.hasMoreTokens()) {
			String str = token2.nextToken();

			Integer count = noteMap.put(str, 1);
			if (count != null) {
				noteMap.put(str, count + 1);
			}
		}

	}

	public boolean solve() {

		boolean possible = true;

		Set<String> noteSet = noteMap.keySet();

		for (String key : noteSet) {

			Integer noteCount = noteMap.get(key);
			Integer magazineCount = magazineMap.get(key);

			System.out.println("Key : " + key + " noteCount : " + noteCount + " magazineCount : " + magazineCount);
			
			if (magazineCount != null && noteCount <= magazineCount) {
				continue;
			} else {
				possible = false;
				break;
			}
		}

		return possible;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();

		// Eat whitespace to beginning of next line
		scanner.nextLine();

		StringToken s = new StringToken(scanner.nextLine(), scanner.nextLine());
		scanner.close();

		boolean answer = s.solve();
		if (answer)
			System.out.println("Yes");
		else
			System.out.println("No");

	}
}
