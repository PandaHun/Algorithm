package Baekjoon;
/*
 *  @Author: Pandahun
 *  @Contents: 좋은 수열
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem2661 {

    private static boolean isEnd = false;

    public static void main( String[] args ) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());

        solve("", len);
    }

    static void solve( String str, int length ) {
        if (isEnd) return;

        if (str.length() == length) {
            System.out.println(str);
            isEnd = true;
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (isAble(str + i)) {
                solve(str + i, length);
            }
        }
    }

    static boolean isAble( String str ) {
        int len = str.length();

        for (int i = 1; i <= len / 2; i++) {
            String front = str.substring(str.length() - i - i, str.length() - i);
            String behind = str.substring(str.length() - i, str.length());

            if (front.equals(behind))
                return false;
        }

        return true;
    }
}
