package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem15652 {

    private static int N;
    private static int M;
    private static int[] arr;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        back(1,0);
        //solve(0);
    }

    private static void back(int index, int depth) {
        if (depth == M) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }else{
            for(int i = index; i <=N; i ++) {
                arr[depth] = i;
                back(i, depth+1);
            }
        }
    }

    private static void solve(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int j = 1; j <= N; j++) {
            if (depth != 0 && arr[depth - 1] > j) {
                continue;
            }
            arr[depth] = j;
            solve(depth + 1);
        }
    }
}
