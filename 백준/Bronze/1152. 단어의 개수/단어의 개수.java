import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		if (str.equals(" ")) {
			System.out.println(0);
		} else {

			int count = 1;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == ' ') {
					if (i == 0 || i == str.length() - 1)
						continue;
					count++;
				}
			}
			System.out.println(count);
		}
	}
}