import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int inputLen, N, brokenBtnCount, answer;
	static boolean btns[] = new boolean[10];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		String input = st.nextToken();
		inputLen = input.length();
		N = Integer.parseInt(input);

		st = new StringTokenizer(br.readLine());
		brokenBtnCount = Integer.parseInt(st.nextToken());

		if (brokenBtnCount != 0) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < brokenBtnCount; i++) {
				int btn = Integer.parseInt(st.nextToken());
				btns[btn] = true;
			}
		}

		answer = Math.abs(N - 100);

		homogen(0, 0);

		System.out.println(answer);
	}

	static void homogen(int count, int number) {
		if (count > 0 && count <= 7) {
			answer = Math.min(answer, Math.abs(number - N) + lengCheck(number));
		}

		if (count > 7) {
			return;
		}

		for (int i = 0; i <= 9; i++) {
			if (!btns[i]) {
				homogen(count + 1, number * 10 + i);
			}
		}
	}

	static int lengCheck(int number) {
		int count = 1;

		while (number > 9) {
			number /= 10;
			count++;
		}

		return count;
	}
}