import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < 9; i++) {
            arr.add(sc.nextInt());
            sum += arr.get(i);
        }
        for(int i = 0; i < 8; i++) {
            for(int j = i + 1; j < 9; j++) {
                if(arr.get(i) + arr.get(j) == sum - 100) {
                    arr.remove(j);
                    arr.remove(i);
                    Collections.sort(arr);
                    for(int k = 0; k < 7; k++) {
                        System.out.println(arr.get(k));
                    }
                    return;
                }
            }
        }
	}
}