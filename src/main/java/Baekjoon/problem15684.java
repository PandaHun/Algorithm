package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem15684 {

    private static int N, M, H;
    private static int[][] ladders;
    private static int answer;
    private static boolean isAble;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        ladders = new int[H + 2][N + 1];
        answer = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int b = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            ladders[b][h] = 1;
        }
        for (int i = 0; i <= 3; i++) {
            answer = i;
            solve(1, 1, 0);
            if(isAble) {
                break;
            }
        }
        System.out.print(isAble || answer == 0 ? answer + "\n" : -1 + "\n");
    }

    private static void solve(int x, int y, int depth) {
        if(isAble) {
            return;
        }
        if (depth == answer) {
            isAble = go();
            return;
        }

        for (int i = (y < N ? x : x+1); i <= H; i++) {
            for (int j = 1; j < N; j++) {
                if(ladders[i][j] == 1 || ladders[i][j-1] == 1 || ladders[i][j+1] == 1) continue;
                ladders[i][j] = 1;
                solve(i,j,depth+1);
                ladders[i][j] = 0;
            }
        }
    }

    private static boolean go() {
        for (int j = 1; j <= N; j++) {
            int i = 1;
            int temp = j;
            while( i <= H+1) {

                if(ladders[i][temp] == 1) {
                    temp++;
                }
                else if(ladders[i][temp-1] == 1) {
                    temp--;
                }
                i++;
            }
            if(j != temp) {
                return false;
            }
        }
        return true;
    }
}
