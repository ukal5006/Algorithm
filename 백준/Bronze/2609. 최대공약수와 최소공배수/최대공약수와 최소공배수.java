import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int max = Math.max(a, b);
		int min = Math.min(a, b);

		while (true) {
			if (max % min == 0) {
				break;
			}

			int c = max % min;
			max = min;
			min = c;
		}

		System.out.println(min);
		System.out.println(a * b / min);
	}
}