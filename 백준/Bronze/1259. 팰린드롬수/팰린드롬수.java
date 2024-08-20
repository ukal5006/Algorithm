import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean check;
		while (true) {
			String input = sc.next();

			if (input.equals("0"))
				break;

			check = true;

			for (int i = 0; i < input.length() / 2; i++) {
				if (input.charAt(i) != input.charAt(input.length() - i - 1)) {
					System.out.println("no");
					check = false;
					break;
				}
			}
			if (check)
				System.out.println("yes");
		}
	}
}