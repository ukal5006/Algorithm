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
		long arr[] = new long[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		long min = Long.MAX_VALUE;
		long answer[] = new long[3];

		for (int l = 0; l <= arr.length - 3; l++) {
			int m = l + 1;
			int r = arr.length - 1;
			while (m != r) {
				long gap = arr[l] + arr[m] + arr[r];

				if (Math.abs(gap) < min) {
					min = Math.abs(gap);
					answer[0] = arr[l];
					answer[1] = arr[m];
					answer[2] = arr[r];
				}

				if (gap > 0) {
					r--;
				} else if (gap < 0) {
					m++;
				} else {
					break;
				}
			}
		}

		System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
	}
}