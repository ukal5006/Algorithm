import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0;
		int point[] = new int[2];

		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				int input = sc.nextInt();
				if (max <= input) {
					max = input;
					point[0] = i;
					point[1] = j;
				}
			}
		}

		System.out.println(max);
		System.out.println(point[0] + " " + point[1]);
	}
}