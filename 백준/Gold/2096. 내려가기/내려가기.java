import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		int maxArr[][] = new int[N + 1][3];
		int minArr[][] = new int[N + 1][3];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				int input = Integer.parseInt(st.nextToken());
				maxArr[i][j] = input;
				minArr[i][j] = input;
			}
		}

		for (int i = 1; i <= N; i++) {
			minArr[i][0] += Math.min(minArr[i - 1][0], minArr[i - 1][1]);
			minArr[i][1] += Math.min(Math.min(minArr[i - 1][0], minArr[i - 1][1]), minArr[i - 1][2]);
			minArr[i][2] += Math.min(minArr[i - 1][1], minArr[i - 1][2]);

			maxArr[i][0] += Math.max(maxArr[i - 1][0], maxArr[i - 1][1]);
			maxArr[i][1] += Math.max(Math.max(maxArr[i - 1][0], maxArr[i - 1][1]), maxArr[i - 1][2]);
			maxArr[i][2] += Math.max(maxArr[i - 1][1], maxArr[i - 1][2]);

		}

		int max = Math.max(Math.max(maxArr[N][0], maxArr[N][1]), maxArr[N][2]);
		int min = Math.min(Math.min(minArr[N][0], minArr[N][1]), minArr[N][2]);

		System.out.println(max + " " + min);
	}
}