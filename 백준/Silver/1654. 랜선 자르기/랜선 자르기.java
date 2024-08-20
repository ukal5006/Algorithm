import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int K = sc.nextInt();
		int N = sc.nextInt();
		
		int arr[] = new int[K];
		long s = 0;
		long e = 0;

		for (int i = 0; i < K; i++) {
			int input = sc.nextInt();
			arr[i] = input;
			e = Math.max(e, input);
		}
		
		e++;
		long mid = 0;

		while (s < e) {
			
			mid = (e + s) /2;
			
			long sum = 0;

			for (int i = 0; i < K; i++) {
				sum += arr[i] / mid;
			}

			if (sum < N) {
				e = mid;
			} else {
				s = mid + 1;
			}
		}

		System.out.println(s - 1);
	}
}