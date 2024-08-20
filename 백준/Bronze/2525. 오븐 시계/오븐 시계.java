import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		int cHour = C / 60;
		int cMinute = C % 60;

		if (cMinute + B >= 60) {
			A++;
			B += cMinute - 60;
		} else {
			B += cMinute;
		}

		if (A + cHour >= 24)
			A += cHour - 24;
		else
			A += cHour;

		System.out.println(A + " " + B);

	}
}