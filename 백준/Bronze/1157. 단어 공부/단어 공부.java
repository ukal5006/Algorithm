import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0;
		int idx = 0;
		boolean check = false;
		int arr[] = new int[26];
		String str = sc.next().toUpperCase();

		for (int i = 0; i < str.length(); i++) {
			arr[(str.charAt(i) - 'A')]++;
		}

		for (int i = 0; i < 26; i++) {
			if (max < arr[i]) {
				max = arr[i];
				check = false;
				idx = i;
			} else if (max == arr[i]) {
				check = true;
			}
		}

		if (check) {
			System.out.println("?");
		} else {
			int a = 'A' + idx;
			char c = (char) a;
			System.out.println(c);
		}

	}
}