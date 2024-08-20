import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, V; // 정점 개수, 간선 개수, 시작 정점
	static List[] adj;
	static List<Integer> dfsList = new ArrayList<Integer>();
	static List<Integer> bfsList = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		adj = new LinkedList[N + 1];

		for (int v = 1; v <= N; v++) {
			adj[v] = new LinkedList<>();
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());

			adj[v1].add(v2);
			adj[v2].add(v1);
		}
		for (int i = 1; i < adj.length; i++) {
			Collections.sort(adj[i]);
		}
		dfs(V);
		bfs(V);
		for (int i = 0; i < dfsList.size(); i++) {
			System.out.print(dfsList.get(i) + " ");
		}
		System.out.println();
		for (int i = 0; i < bfsList.size(); i++) {
			System.out.print(bfsList.get(i) + " ");
		}

	}

	static void dfs(int v) {
		dfsList.add(v);
		for (int i = 0; i < adj[v].size(); i++) {
			int idx = dfsList.indexOf(adj[v].get(i));
			if (idx == -1) {
				dfs((int) adj[v].get(i));
			}
		}
	}

	static void bfs(int v) {
		Queue<List<Integer>> queue = new ArrayDeque<>();
		bfsList.add(v);
		queue.add(adj[v]);
		while (!queue.isEmpty()) {
			List<Integer> temp = queue.poll();
			for (int i = 0; i < temp.size(); i++) {
				int idx = bfsList.indexOf(temp.get(i));
				if (idx == -1) {
					bfsList.add((int) temp.get(i));
					queue.add(adj[(int) temp.get(i)]);
				}
			}
		}
	}

}