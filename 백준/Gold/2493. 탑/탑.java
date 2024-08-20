import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Tower> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= N; i++) {
			int h = Integer.parseInt(st.nextToken());
			while (!stack.isEmpty() && stack.peek().height < h) {
				stack.pop();
			}
			if (stack.isEmpty()) { // 다.. 나갔네... 쪼꼬미들... 아무도 레이저 못받는구나...
				sb.append("0 ");
			} else {
				sb.append(stack.peek().num + " ");
			}
			stack.push(new Tower(i, h));
		}
		System.out.println(sb);
	}

	static class Tower {
		int num, height;

		Tower(int n, int h) {
			num = n;
			height = h;
		}
	}
}