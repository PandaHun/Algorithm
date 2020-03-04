package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem11055 {

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] ans = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            ans[i] = arr[i];
        }
        int answer = 0;
        for(int i = 0; i < N ; i++) {
            for(int j = 0; j < i ; j++) {
                if(arr[j] < arr[i]) {
                    ans[i] = Math.max(ans[j]+ arr[i], ans[i]);
                }
            }
            answer = Math.max(answer, ans[i]);
        }
        System.out.println(answer);
    }
}
