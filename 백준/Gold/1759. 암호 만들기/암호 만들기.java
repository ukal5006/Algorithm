import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int L, C;
	static int answer[];
	static char arr[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		answer = new int[L];
		arr = new char[C];

		for (int i = 0; i < C; i++) {
			arr[i] = sc.next().charAt(0);
		}

		Arrays.sort(arr);

		comb(0, 0);
	}

	static boolean check(int idx) { // 모음이면 true 자음이면 false을 return
		if (arr[idx] == 'a' || arr[idx] == 'e' || arr[idx] == 'i' || arr[idx] == 'o' || arr[idx] == 'u') {
			return true;
		} else
			return false;
	}

	static boolean check2(int arr[]) {
		int mom = 0;
		int son = 0;

		for (int i = 0; i < L; i++) {
			if (check(answer[i])) {
				mom += 1;
			} else {
				son += 1;
			}
		}

		if (mom >= 1 && son >= 2) {
			return true;
		} else {
			return false;
		}
	}

	static void comb(int count, int idx) {
		if (count == L) {
			if (check2(answer)) {
				for (int i = 0; i < L; i++) {
					System.out.print(arr[answer[i]]);
				}
				System.out.println();
			}
			return;
		}

		if (idx == C) {
			return;
		}

		answer[count] = idx;
		comb(count + 1, idx + 1);
		comb(count, idx + 1);
	}
}