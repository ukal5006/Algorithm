import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int now = N;
		int time = 0;
		while (true) {
			time++;
			now = ((now % 10) * 10) + (now / 10 + now % 10) % 10;
			if (N == now) {
				System.out.println(time);
				return;
			}
		}
	}
}