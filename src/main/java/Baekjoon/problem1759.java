package Baekjoon;
/*
 *  @Author: Pandahun
 *  @Content: 임호 만들기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem1759 {

    private static int L, C;
    private static char[] password;

    public static void main( String[] args ) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        password = new char[C];
        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < 6; i++) {
            password[i] = temp[i].charAt(0);
        }

        Arrays.sort(password);
        solve(0, "");

    }

    private static void solve( int index, String now ) {
        if (now.length() == L) {
            if (isPossible(now)) {
                System.out.println(now);
            }
            return;
        }

        if (index >= C) {
            return;
        }

        solve(index + 1, now + password[index]);
        solve(index + 1, now);
    }

    private static boolean isPossible( String now ) {
        int count = 0;
        int another = 0;
        for (int i = 0; i < now.length(); i++) {
            if (isIt(now.charAt(i))) {
                count++;
            } else {
                another++;
            }
        }
        return (count >= 1 && another >= 2);
    }

    private static boolean isIt( char c ) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
