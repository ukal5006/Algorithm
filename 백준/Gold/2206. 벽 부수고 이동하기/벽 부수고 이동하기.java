import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int map[][];
    static boolean visited[][][];
    static int di[] = {-1,1,0,0};
    static int dj[] = {0,0,-1,1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map  = new int[N][M];
        visited = new boolean[N][M][2];

        for(int i = 0; i < N; i++) {
            String input = sc.next();
            for(int j = 0 ; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0,0,0));
    }

    static int bfs(int i, int j, int skill) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(i,j,skill, 1));
        visited[i][j][skill] = true;
        
        while (!queue.isEmpty()) {
                Point now = queue.poll();

                if(now.i == N - 1 && now.j == M - 1) {
                    return now.count;
                }

                for(int d = 0; d < 4; d++) {
                    int nextI = now.i + di[d];
                    int nextJ = now.j + dj[d];

                    if(nextI >= 0 && nextI < N && nextJ >= 0 && nextJ < M) {
                        if(map[nextI][nextJ] == 0 && !visited[nextI][nextJ][now.skill]) {
                            queue.offer(new Point(nextI, nextJ, now.skill, now.count + 1));
                            visited[nextI][nextJ][now.skill] = true;
                        }
                        
                        else if(map[nextI][nextJ] == 1 && now.skill == 0) {
                            queue.offer(new Point(nextI, nextJ, now.skill + 1, now.count + 1));
                            visited[nextI][nextJ][now.skill + 1] = true;
                        }
                    }
                }
            }
        return - 1;
    }

    static class Point {
        int i, j, skill, count;
        Point(int i, int j, int skill, int count) {
            this.i = i;
            this.j = j;
            this.skill = skill;
            this.count = count;
        }
    }
}