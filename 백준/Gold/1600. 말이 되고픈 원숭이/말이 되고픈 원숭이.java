import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int map[][];
    static int di[] = {-1,1,0,0};
    static int dj[] = {0,0,-1,1};
    static int dsi[] = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int dsj[] = {-2 ,-1, 1, 2, 2, 1, -1, -2};
    static int answer = 0;
    static int K, W ,H;
    static boolean visited[][][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        W = sc.nextInt();
        H = sc.nextInt();
        map = new int[H][W];
        visited = new boolean[H][W][K + 1];

        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                map[i][j] = sc.nextInt();        
            }
        }

        bfs();
        System.out.println(answer);
        
    }

    static void bfs() {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(0, 0, 0, 0));
        visited[0][0][0] = true;

        while(!queue.isEmpty()) {
            Point now = queue.poll();
            if(now.i == H - 1 && now.j == W - 1) {
                answer = now.time;
                return;
            }
            
            for(int d = 0; d < 4; d++) {
                int nextI = now.i + di[d];
                int nextJ = now.j + dj[d];
                int nextTime = now.time + 1;

                if(nextI >= 0 && nextI < H && nextJ >= 0 && nextJ < W && !visited[nextI][nextJ][now.skill] && map[nextI][nextJ] == 0) {
                    queue.offer(new Point(nextI, nextJ, now.skill, nextTime));
                    visited[nextI][nextJ][now.skill] = true;
                }
            }

            for(int d = 0; d < 8; d++) {
                int nextI = now.i + dsi[d];
                int nextJ = now.j + dsj[d];
                int nextSkill = now.skill + 1;
                int nextTime = now.time + 1;

                if(nextSkill <= K && nextI >= 0 && nextI < H && nextJ >= 0 && nextJ < W && !visited[nextI][nextJ][nextSkill] && map[nextI][nextJ] == 0) {
                    queue.offer(new Point(nextI, nextJ, nextSkill, nextTime));
                    visited[nextI][nextJ][nextSkill] = true;
                }
            }
        }

        answer = -1;
    }

    static class Point {
        int i, j, skill, time;
        Point(int i, int j, int skill, int time) {
            this.i = i;
            this.j = j;
            this.skill = skill;
            this.time = time;
        }
    }
}