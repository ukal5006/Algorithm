import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		int answer = 0;
		int count = (int) Math.pow(2, N);
		while (true) {
			int half = count / 2;
			if (half == 0)
				break;
			if (r > half - 1) {
				if (c > half - 1) {
					answer += half * half * 3;
				} else {
					answer += half * half * 2;
				}
			} else {
				if (c > half - 1) {
					answer += half * half;
				}
			}
			count /= 2;
			r %= half;
			c %= half;
		}
		System.out.println(answer);
	}
}