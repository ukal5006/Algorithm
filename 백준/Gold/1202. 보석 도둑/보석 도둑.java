import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		GemArr gemArr[] = new GemArr[N];
		int bagArr[] = new int[K];
		PriorityQueue<GemArr> pq = new PriorityQueue<>((a,b) -> b.value - a.value);

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());

			gemArr[i] = new GemArr(weight, value);
		}

		Arrays.sort(gemArr, (a, b) -> a.weight - b.weight);

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			bagArr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(bagArr);
		int gemIdx = 0;
		long answer = 0;
		
		for(int i = 0; i < K; i++) {
			while(gemIdx < N && gemArr[gemIdx].weight <= bagArr[i]) {
				pq.add(gemArr[gemIdx]);
				gemIdx++;
			}
			
			if(!pq.isEmpty()) {
				answer += pq.poll().value;
			}
		}
		
		System.out.println(answer);
	}

	static class GemArr {
		int weight, value;

		public GemArr(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}
	}
}