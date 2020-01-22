package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class problem2819 {

    private static String[][] map;
    private static HashSet<String> set;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    private static final int N = 4;

    public static void main(String[] args) throws IOException, NumberFormatException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            map = new String[N][N];
            set = new HashSet<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = st.nextToken();
                }
            }

            for (int i = 0; i < N; i++) {
                String temp;
                for (int j = 0; j < N; j++) {
                    temp = map[i][j];
                    solve(i, j, temp, 0);
                }
            }
            sb.append("#").append(tc).append(" ").append(set.size()).append("\n");
        }
        System.out.println(sb);
    }

    private static void solve(int r, int c, String temp, int cnt) {
        if(cnt == 6) {
            set.add(temp);
            return;
        }
        for(int i = 0 ; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if( nr < 0 || nr >= N || nc < 0 || nc >= N) continue;

            solve(nr, nc, temp + map[nr][nc], cnt+1);
        }
    }
}
