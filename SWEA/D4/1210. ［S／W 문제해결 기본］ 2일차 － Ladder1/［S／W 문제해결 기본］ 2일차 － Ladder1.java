import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = sc.nextInt();

			int[][] arr = new int[100][100];

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			int x = 0;
			for (int i = 0; i < 100; i++) {
				if (arr[99][i] == 2) {
					x = i;
					break;
				}
			}

			for (int i = 99; i > 0; i--) {
				if (x - 1 >= 0 && arr[i][x - 1] == 1) {
					while (true) {
						x -= 1;
						if (x == 0 || arr[i][x - 1] == 0) {
							break;
						}
					}

				} else if (x + 1 <= 99 && arr[i][x + 1] == 1) {
					while (true) {
						x += 1;
						if (x == 99 || arr[i][x + 1] == 0) {
							break;
						}
					}
				}

			}
			System.out.println("#" + T + " " + x);
		}
	}
}