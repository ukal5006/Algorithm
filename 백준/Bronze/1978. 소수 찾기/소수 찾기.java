import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean map[] = new boolean[1001];

	public static void main(String[] args) throws IOException {
		map[1] = true;

		for (int i = 2; i <= 1000; i++) {
			if (!map[i]) {
				eratosthenes(i);
			}
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int count = 0;

		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(st.nextToken());
			if (!map[input]) {
				count++;
			}
		}

		System.out.println(count);
	}

	static void eratosthenes(int number) {
		int gop = 2;

		while (number * gop <= 1000) {
			map[number * gop] = true;
			gop++;
		}
	}
}