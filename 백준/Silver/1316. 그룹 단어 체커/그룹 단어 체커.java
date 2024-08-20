import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = N;
		for (int i = 0; i < N; i++) {
			boolean check[] = new boolean[26];
			String str = sc.next();

			for (int j = 0; j < str.length(); j++) {
				if (j == 0) {
					check[(str.charAt(j) - 'a')] = true;
					continue;
				}

				if (str.charAt(j) == str.charAt(j - 1)) {
					continue;
				}

				if (check[(str.charAt(j) - 'a')]) {
					count--;
					break;
				} else {
					check[(str.charAt(j) - 'a')] = true;
				}
			}
		}
		System.out.println(count);
	}
}