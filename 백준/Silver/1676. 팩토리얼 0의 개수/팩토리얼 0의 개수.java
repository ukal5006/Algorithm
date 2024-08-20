import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int five = 0;
		int two = 0;

		for (int i = N; i >= 2; i--) {
			five += countFive(i);
			two += countTwo(i);
		}

		System.out.println(Math.min(five, two));

	}

	static int countFive(int number) {
		int count = 0;

		while (number >= 5) {
			if (number % 5 != 0) {
				break;
			}
			count++;
			number /= 5;
		}

		return count;
	}

	static int countTwo(int number) {
		int count = 0;

		while (number >= 2) {
			if (number % 2 != 0) {
				break;
			}
			count++;
			number /= 2;
		}

		return count;
	}
}