import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		if (A == B && B == C) {
			System.out.println(A * 1000 + 10000);
		} else if (A != B && B != C && A != C) {
			Math.max(Math.max(A, B), C);
			System.out.println(Math.max(Math.max(A, B), C) * 100);
		} else {
			if (A == B)
				System.out.println(100 * A + 1000);
			else if (A == C)
				System.out.println(100 * A + 1000);
			else
				System.out.println(100 * B + 1000);
		}

	}
}