import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static char map[][] = new char [5][5];
    static boolean arr[] = new boolean[25];
    static int di[] = {-1,1,0,0};
    static int dj[] = {0,0,-1,1};
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 5; i++) {
            String input = sc.next();
            for(int j = 0; j < 5; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        comb(0, 0);

        System.out.println(answer);
    }

    static void comb(int count, int idx) {
        if(count == 7) {
            int sCount = 0;
            int start = -1;
            for(int i = 0; i < 25; i++) {
                if(arr[i] && map[i / 5][i % 5] == 'S') {
                    sCount++;
                    if(start == -1) {
                        start = i;
                    }
                }
        }
        
        if(sCount >= 4) {
            if(isLink(start)) {
                answer++;
            }
        }
        return;
    }

        if(idx == 25) {
            return;
        }

        arr[idx] = true;
        comb(count + 1, idx + 1);
        arr[idx] = false;
        comb(count, idx + 1);
    }

    

    static class Point {
        int i, j;
        Point(int i, int j) {
            this. i = i;
            this. j = j;
        }
    }

    static boolean isLink(int start) {
        int si = start/5;
		int sj = start%5;
		Queue<Point> queue = new LinkedList<>();
		boolean[][] visit = new boolean[5][5];
		
		queue.add(new Point(si, sj));
		visit[si][sj] = true;
		
		int cnt = 0;
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			cnt++;
			if(cnt == 7) return true;
			
			for(int d=0; d<4; d++) {
				int ni = now.i + di[d];
				int nj = now.j + dj[d];
				
				if(ni>=0 && ni<5 && nj>=0 && nj<5 && arr[ni*5+nj] && !visit[ni][nj]) {
					queue.add(new Point(ni, nj));
					visit[ni][nj] = true;
				}
			}
		}
		
		return false;

    }
}