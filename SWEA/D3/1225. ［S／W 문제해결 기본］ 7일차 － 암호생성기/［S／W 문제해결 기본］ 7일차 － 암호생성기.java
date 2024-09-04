import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = 10;

        for(int test_case = 1; test_case <= T; test_case++) {
            Queue<Integer> queue = new ArrayDeque<>();
            int t = sc.nextInt();

            for(int i = 0 ; i < 8; i++) {
                queue.offer(sc.nextInt());
            }

            int key = 0;

            while(key == 0) {
                for(int i = 1; i <= 5; i++) {
                    if(queue.peek() - i > 0) {
                        queue.offer(queue.poll() - i);
                    }
                    else {
                        key = 1;
                        queue.poll();
                        queue.offer(0);
                        break;
                    }
                }
            }
            System.out.print("#" + t);
            for(int i = 0; i < 8; i++) {
                System.out.print(" " + queue.poll());
            }
            System.out.println();
        }
    }
}