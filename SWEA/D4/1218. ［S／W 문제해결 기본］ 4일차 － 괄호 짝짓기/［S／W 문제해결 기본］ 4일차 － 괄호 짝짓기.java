import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = 10;

        for(int test_case = 1; test_case <= T; test_case++) {
            Stack<Character> stack = new Stack<>();
            int N = sc.nextInt();
            String str = sc.next();

            for(int i = 0; i < N; i++) {
                char c = str.charAt(i);
                if(stack.isEmpty()) {
                    if(c == ')' || c == ']' || c =='}' || c =='>') {
                        break;
                    }
                    else {
                        stack.push(str.charAt(i));
                    }    
                }
                else{
                    if (c == '(' || c == '[' || c == '{' || c == '<') {
                        stack.push(str.charAt(i));
                    }
                    else {
                        if(c == ')') {
                            if(stack.peek() == '(') {
                                stack.pop();
                            }
                            else break;
                        }
                        else if(c == ']') {
                            if(stack.peek() == '[') {
                                stack.pop();
                            }
                            else break;
                        }
                        else if(c == '}') {
                            if(stack.peek() == '{') {
                                stack.pop();
                            }
                            else break;
                        }
                        else {
                            if(stack.peek() == '<') {
                                stack.pop();
                            }
                            else break;
                        }
                    }
                }
            }
            System.out.print("#" + test_case + " ");
            if(stack.empty()) System.out.println(1);
            else System.out.println(0);
        }
    }
}