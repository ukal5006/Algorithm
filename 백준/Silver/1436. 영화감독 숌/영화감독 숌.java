import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = 0;
		int number = 666;
		while(true) {
			
			if(Integer.toString(number).contains("666")) {
				count++;
			}
			
			if(N == count) {
				System.out.println(number);
				return;
			}
			
			number++;
		}
	}
}