import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<String> str = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String input = sc.next();
			if (str.indexOf(input) == -1) {
				str.add(input);
			}
		}

		Collections.sort(str, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1.length() > o2.length()) {
					return 1;
				} else if (o1.length() == o2.length()) {
					return o1.compareTo(o2);
				} else
					return -1;
			}
		});

		for (int i = 0; i < str.size(); i++) {
			System.out.println(str.get(i));
		}
	}
}