package Baekjoon;

import java.io.*;

public class problem1786 {

    static int cnt;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        String T = br.readLine();
        String P = br.readLine();
        kmp(T, P);
        System.out.print(cnt + "\n");
        System.out.print(sb.toString());
    }

    static int[] getPi(String P) {
        int[] pi = new int[P.length()];
        char[] p = new char[P.length()];
        p = P.toCharArray();
        int j = 0;
        for (int i = 1; i < pi.length; i++) {
            while (j > 0 && p[i] != p[j]) {
                j = pi[j - 1];
            }
            if (p[i] == p[j]) {
                pi[i] = ++j;
            }
        }
        return pi;
    }

    static void kmp(String str, String pattern) {
        int[] pi = getPi(pattern);
        int j = 0;
        for (int i = 0; i < str.length(); i++) {
            while (j > 0 && str.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if (str.charAt(i) == pattern.charAt(j)) {
                if (j == pi.length - 1) {
                    cnt++;
                    int tmp = i - pattern.length() + 2;
                    sb.append(tmp).append(' ');
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
    }
}
