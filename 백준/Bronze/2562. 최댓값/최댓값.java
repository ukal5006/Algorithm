import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 9;
		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int max = 0, idx = 0;

		for (int i = 0; i < N; i++) {
			max = Math.max(max, arr[i]);
			if (arr[i] == max) {
				idx = i + 1;
			}
		}
		System.out.println(max);
		System.out.println(idx);
	}
}