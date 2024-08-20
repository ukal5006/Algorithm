import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int days[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		String day[] = { "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN" };

		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();
		int sum = 0;

		for (int i = 0; i < x; i++) {
			sum += days[i];
		}

		sum += y - 1;
		System.out.println(day[sum % 7]);
	}
}