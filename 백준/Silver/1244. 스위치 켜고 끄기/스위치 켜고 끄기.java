import java.util.Scanner;

public class Main {
	static int[] arr;
	static int studentCount;
	static int switchCount;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		switchCount = sc.nextInt();
		arr = new int[switchCount];
		for (int i = 0; i < switchCount; i++) {
			arr[i] = sc.nextInt();
		}

		studentCount = sc.nextInt();

		for (int i = 0; i < studentCount; i++) {
			int gender = sc.nextInt();
			int switchNumber = sc.nextInt();

			if (gender == 1) {
				for (int j = switchNumber; j <= switchCount;) {
					change(j);
					j += switchNumber;
				}
			} else {
				girl(switchNumber, 1);
			}
		}

		for (int i = 0; i < switchCount; i++) {
			if (i / 20 > 0 && i % 20 == 0)
				System.out.println();
			System.out.print(arr[i] + " ");
		}
	}

	static void girl(int switchNumber, int range) {
		if (switchNumber + range <= switchCount && switchNumber - range > 0
				&& (arr[switchNumber + range - 1] == arr[switchNumber - range - 1])) {
			change(switchNumber + range);
			change(switchNumber - range);
			girl(switchNumber, range + 1);
		} else
			change(switchNumber);
	}

	static void change(int switchNumber) {
		if (arr[switchNumber - 1] == 0) {
			arr[switchNumber - 1] = 1;
		} else
			arr[switchNumber - 1] = 0;

		for (int i = 0; i < switchCount; i++) {
		}
	}
}