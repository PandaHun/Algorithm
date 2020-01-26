package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem1221 {

    private static int N;
    private static int[] input;
    private static String[] numbers = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T;tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            st.nextToken();
            N = Integer.parseInt(st.nextToken());
            String str = br.readLine().trim();
            input = new int[10];
            for(int i = 0 ; i < 10; i ++) {
                int length = str.length();
                str = str.replace(numbers[i], "");
                input[i] = (length - str.length()) / 3;
            }
            sb.append(" " +tc +"\n" );
            for(int i = 0 ; i < 10; i ++) {
                for(int j = 0 ; j < input[i]; j++) {
                    sb.append(numbers[i] +" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}