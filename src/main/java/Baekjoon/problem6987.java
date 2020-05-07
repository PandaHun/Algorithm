package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class problem6987 {

    static final int N = 4;
    static int[] team1 = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
    static int[] team2 = {1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5};
    static int[][] input;
    static int win, draw, loss;
    static boolean flag;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            input = new int[6][3];
            st = new StringTokenizer(br.readLine(), " ");
            win = draw = loss = 0;
            flag = false;
            for (int k = 0; k < 6; k++) {
                win += input[k][0] = Integer.parseInt(st.nextToken());
                draw += input[k][1] = Integer.parseInt(st.nextToken());
                loss += input[k][2] = Integer.parseInt(st.nextToken());
            }
            if( win + draw + loss != 30) {
                bw.write("0 ");
                continue;
            } else {
                dfs(0);
            }
            bw.write( flag ? "1 " : "0 ");
        }
        bw.flush();
    }

    static void dfs(int depth) {
        if(flag) {
            return;
        }
        if( depth == 15) {
            flag = true;
            return;
        }
        int t1 = team1[depth];
        int t2 = team2[depth];

        // team1 이 승리할 수 있다면
        if (input[t1][0] > 0 && input[t2][2] > 0) {
            input[t1][0]--;
            input[t2][2]--;
            dfs(depth + 1);
            input[t1][0]++;
            input[t2][2]++;
        }
        // team1 과 team2가 무승부라면
        if (input[t1][1] > 0 && input[t2][1] > 0) {
            input[t1][1]--;
            input[t2][1]--;
            dfs(depth + 1);
            input[t1][1]++;
            input[t2][1]++;
        }
        // team2 가 승리할 수 있다면
        if (input[t1][2] > 0 && input[t2][0] > 0) {
            input[t1][2]--;
            input[t2][0]--;
            dfs(depth + 1);
            input[t1][2]++;
            input[t2][0]++;
        }
    }
}
