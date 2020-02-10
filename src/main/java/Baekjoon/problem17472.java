package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem17472 {

    private static int N;
    private static int M;
    private static int[][] map, time;
    private static boolean[] active;
    private static int[] dr = { -1, 1, 0, 0 };
    private static int[] dc = { 0, 0, -1, 1 };
    private static List<Virus> virusLists;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        virusLists = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    virusLists.add(new Virus(i, j));
                }
            }
        }
        active = new boolean[virusLists.size()];
        solve(0, 0);
        System.out.print(answer);
    }

    private static void solve(int index, int depth) {
        if (depth == M) {
            spreadVirus();
            return;
        }
        if (depth > M || index >= virusLists.size()) {
            return;
        }
        active[index] = true;
        solve(index +1, depth +1);
        active[index] = false;
        solve(index+1, depth);
    }

    private static void spreadVirus() {
        Queue<Virus> queue = new LinkedList<>();
        time = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                time[i][j] = -1;
            }
        }
        for (int i = 0; i < virusLists.size(); i++) {
            if (active[i]) {
                Virus n = virusLists.get(i);
                queue.add(n);
                time[n.r][n.c] = 0;
            }
        }
        while (!queue.isEmpty()) {
            Virus now = queue.poll();
            int r = now.r;
            int c = now.c;
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N)
                    continue;

                if (map[nr][nc] == 1)
                    continue;

                if (time[nr][nc] != -1)
                    continue;

                queue.add(new Virus(nr, nc));
                time[nr][nc] = time[r][c] + 1;
            }
        }
        int second =  check();
        if (second == -1) {
            if ( answer == Integer.MAX_VALUE) {
                answer = -1;
            }
        } else {
            if( answer == -1 || answer > second) {
                answer = second;
            }
        }

    }

    static int check() {
        int max = 0;
        for(int i = 0 ; i < N; i++) {
            for(int j = 0 ; j < N; j++) {
                if(map[i][j] == 0 && max < time[i][j]) {
                    max = time[i][j];
                }

                if(map[i][j] == 0 && time[i][j] == -1) {
                    return -1;
                }
            }
        }
        return max;
    }
}

class Virus {

    int r;
    int c;

    public Virus(int r, int c) {
        this.r = r;
        this.c = c;
    }
}