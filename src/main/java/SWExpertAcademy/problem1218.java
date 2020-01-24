package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class problem1218 {

    private static String input;
    private static int N;
    private static int result;
    private static Stack stack;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int tc = 1 ; tc<=10; tc++) {
            N = Integer.parseInt(br.readLine());
            input = br.readLine();
            stack = new Stack();
            result = 1;
            for(int  i = 0 ; i < N; i ++) {
                char now = input.charAt(i);
                if( now == '[' || now =='{' || now == '(' || now == '<') {
                    stack.push(now);
                }else{
                    char pop = (char) stack.pop();
                    if((pop == '[' && now == ']')||(pop =='{' && now =='}') || (pop =='<' && now =='>') || (pop =='(' && now == ')')) {
                        continue;
                    }
                    else {
                        result = 0;
                    }
                }
                if(result == 0) {
                    break;
                }
            }
            if(stack.size() !=0 ) {
                result = 0;
            }else{
                result = 1;
            }
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
}
