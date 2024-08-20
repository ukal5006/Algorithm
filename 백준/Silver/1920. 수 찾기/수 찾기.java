import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

		Arrays.sort(arr);

		st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			int now = Integer.parseInt(st.nextToken());
			int s = 0;
			int e = N - 1;
			int mid = 0;

			while (s <= e) {
				mid = (s + e) / 2;
				if (arr[mid] == now) {
					break;
				} else if (arr[mid] > now) {
					e = mid - 1;
				} else {
					s = mid + 1;
				}
			}

			if (arr[mid] == now) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		}

		System.out.println(sb);

	}
}