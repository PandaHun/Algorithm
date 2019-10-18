package Baekjoon;
/*
 *  @Author: Pandahun
 *  @Content: 쇠 막대기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class problem10799 {

    public static void main( String[] args ) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int answer = 0;

        String copyArrangement = input.replace("()", "0");
        ArrayList<Character> copy = new ArrayList<Character>();
        for (int i = 0; i < copyArrangement.length(); i++) {
            copy.add(copyArrangement.charAt(i));
        }
        ArrayList<Character> stack = new ArrayList<Character>();
        for (int i = 0; i < copy.size(); i++) {
            char temp = copy.get(i);
            if (temp == '(') {
                stack.add(copy.get(i));
            } else if (temp == ')') {
                stack.remove(stack.size() - 1);
                answer += 1;
            } else if (temp == '0') {
                answer += stack.size();
            }
        }
        System.out.println(answer);
    }

}
