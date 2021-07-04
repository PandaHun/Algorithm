package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem9935 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        int sLength = s.length();
        int tLength = t.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sLength; i++) {
            char c = s.charAt(i);
            sb.append(c);
            if (sb.length() >= tLength) {
                boolean same = true;
                for (int idx = 0; idx < tLength; idx++) {
                    char c1 = sb.charAt(sb.length() - tLength + idx);
                    char c2 = t.charAt(idx);
                    if (c1 != c2) {
                        same = false;
                        break;
                    }
                }
                if (same) {
                    sb.delete(sb.length() - tLength, sb.length());
                }
            }
        }

        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb.toString());
        }
    }
}
