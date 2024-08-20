import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int d[] = { -1, 1 };
		int l = 1;
		int r = 1;
		int lIdx = 0;
		int rIdx = 1;

		while (X != 1) {
			if (l + d[lIdx] < 1) {
				r++;
				lIdx = (lIdx + 1) % 2;
				rIdx = (rIdx + 1) % 2;
			} else if (r + d[rIdx] < 1) {
				l++;
				lIdx = (lIdx + 1) % 2;
				rIdx = (rIdx + 1) % 2;
			} else {
				l = l + d[lIdx];
				r = r + d[rIdx];
			}

			X--;
		}

		System.out.println(l + "/" + r);

	}
}