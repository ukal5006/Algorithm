import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i = 1; i <= N - 1; i++) {
            for(int j = i; j < N; j++) {
                System.out.print(" ");
            }
            for(int j = 0; j < i * 2 - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i = N; i > 0; i--) {
            for(int j = i; j < N; j++) {
                System.out.print(" ");
            }
            for(int j = 0; j < i * 2 - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
	}
}