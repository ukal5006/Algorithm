import java.util.Scanner;

public class Main {
	static int map[][] = new int[101][101];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int size = 0;
		for (int i = 0; i < count; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					map[y + j][x + k] = 1;
				}
			}
		}

		for (int j = 0; j < 100; j++) {
			for (int k = 0; k < 100; k++) {
				if (map[j][k] == 1)
					size++;
			}
		}

		System.out.println(size);
	}
}