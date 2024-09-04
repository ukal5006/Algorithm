import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int T = 10;
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int count =sc.nextInt();
            int arr [] = new int[100];
            int max, min;
            
            for(int i = 0; i < 100; i++) {
                arr[i] = sc.nextInt();
            }

            for(int i = 0; i < count; i++) {
                int maxIdx = -1;
                int minIdx = -1;
                min = 100;
                max = 0;

                for(int j = 0; j < 100; j++) {
                    if(arr[j] >= max) {
                        max = arr[j];
                        maxIdx = j;
                    }
                    if(arr[j] <= min) {
                        min = arr[j];
                        minIdx = j;
                    }
                }

                if(min == max) {
                    break;
                }
                else{
                    arr[maxIdx] -= 1;
                    arr[minIdx] += 1;
                }
            }

            min = 100;
            max = 0;
            for(int j = 0; j < 100; j++) {
                if(arr[j] >= max) {
                    max = arr[j];
                }
                if(arr[j] <= min) {
                    min = arr[j];
                }
            }
            System.out.println("#" + test_case + " " + (max - min));
	    }
    }
}