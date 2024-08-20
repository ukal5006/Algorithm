import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int map[][] = new int[9][9];
	static List<Point> blank = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 9; i++) {
			String input = sc.nextLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = input.charAt(j) - '0';
				if (map[i][j] == 0) {
					blank.add(new Point(i, j));
				}
			}
		}

		dfs(0, 1);
	}

	static void dfs(int idx, int value) {
		if (idx == blank.size()) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		}
		int i = blank.get(idx).i;
		int j = blank.get(idx).j;

		if (value == 10) {
			map[i][j] = 0;
			return;
		}

		map[i][j] = value;

		if (check1(i) && check2(j) && check3(i, j)) {
			dfs(idx + 1, 1);
			dfs(idx, value + 1);
		} else {
			dfs(idx, value + 1);
		}

	}

	static boolean check1(int i) { // 가로9칸
		int check[] = new int[10];
		for (int j = 0; j < 9; j++) {
			check[map[i][j]]++;
			if (map[i][j] != 0 && check[map[i][j]] >= 2) {
				return false;
			}
		}
		return true;
	}

	static boolean check2(int j) { // 세로9칸
		int check[] = new int[10];
		for (int i = 0; i < 9; i++) {
			check[map[i][j]]++;
			if (map[i][j] != 0 && check[map[i][j]] >= 2) {
				return false;
			}
		}
		return true;
	}

	static boolean check3(int i, int j) { // 네모(3*3) 9칸
		int check[] = new int[10];
		for (int k = i / 3 * 3; k < i / 3 * 3 + 3; k++) {
			for (int l = j / 3 * 3; l < j / 3 * 3 + 3; l++) {
				check[map[k][l]]++;
				if (map[k][l] != 0 && check[map[k][l]] >= 2) {
					return false;
				}
			}
		}
		return true;
	}

	static class Point {
		int i, j;

		Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}