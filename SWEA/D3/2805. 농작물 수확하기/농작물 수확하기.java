import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int size =sc.nextInt();
            int arr [][] = new int [size][size];

            for(int i = 0; i < size; i++) {
                String str = sc.next();
                for(int j =0; j < size; j++) {
                    arr[i][j] = str.charAt(j)-'0';
                }
            }

            int sum = 0;
            int idx = size / 2;
            int count = 1;
            for(int i = 0; i < size; i++) {
                if(i <= size / 2) {
                    for(int j = idx; j < idx + count; j++) {
                        sum += arr[i][j];
                    }

                    if(i < size / 2) {
                        idx -= 1;
                        count +=2;
                    }
                }
                else {
                    idx += 1;
                    count -=2;
                    for(int j = idx; j < idx + count; j++) {
                        sum+= arr[i][j];
                    }
                }
            }
            System.out.println("#" + test_case + " " + sum);
	    }
    }
}