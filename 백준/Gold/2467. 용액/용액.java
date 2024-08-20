import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int l = 0;
		int r = arr.length - 1;
		int min = Integer.MAX_VALUE;
		int answer[] = new int[2];

		while (l != r) {
			int gap = arr[l] + arr[r];

			if (Math.abs(gap) < min) {
				min = Math.abs(gap);
				answer[0] = arr[l];
				answer[1] = arr[r];
			}

			if (gap > 0) {
				r--;
			} else if (gap < 0) {
				l++;
			} else {
				System.out.println(answer[0] + " " + answer[1]);
				return;
			}
		}

		System.out.println(answer[0] + " " + answer[1]);
	}
}