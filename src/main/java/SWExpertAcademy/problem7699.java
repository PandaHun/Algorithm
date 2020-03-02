package SWExpertAcademy;

import java.io.*;
import java.util.StringTokenizer;

public class problem7699 {

    private static int N, M;
    private static char[][] map;
    private static boolean[] used;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static int answer;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new char[N][M];
            used = new boolean[26];
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for(int j = 0 ; j <M ; j++) {
                    map[i][j] = str.charAt(j);
                }
            }
            answer = 0;
            used[map[0][0] - 'A'] = true;
            solve(0, 0, 1);
            bw.write("#" + tc + " " + answer + "\n");
        }
        bw.flush();
    }

    private static void solve(int r, int c, int cnt) {
        if( cnt > answer) {
            answer = cnt;
        }
        if( cnt == 26) {
            return;
        }
        for(int k = 0 ; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if(nr >=0 && nc >=0 && nr < N && nc < M && !used[map[nr][nc]-'A'] ) {
                used[map[nr][nc]-'A'] = true;
                solve(nr,nc, cnt+1);
                used[map[nr][nc]-'A'] = false;
            }
        }
    }
}
