package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem17837 {

    static int N, K, turn;
    static boolean isEnd;
    static int[][] map;
    static ArrayList<Integer>[][] pinMap;
    static Pin[] pins;
    static int[] dr = {0, 0, 0, -1, 1};
    static int[] dc = {0, 1, -1, 0, 0};
    static int[] delta = {0, 2, 1, 4, 3};

    public static void main(String[] args) throws IOException {
        init();
        Pin cur;
        List<Integer> temp = new ArrayList<>();
        for(turn =1; turn <=1000; turn++) {
            for (int i = 1; i < K + 1; i++) {
                cur = pins[i];
                int nr = cur.r + dr[cur.d];
                int nc = cur.c + dc[cur.d];
                if (!inRange(nr, nc) || map[nr][nc] == 2) {
                    cur.d = delta[cur.d];
                    nr = cur.r + dr[cur.d];
                    nc = cur.c + dc[cur.d];
                }

                if (inRange(nr, nc) && map[nr][nc] != 2) {
                    if (map[nr][nc] == 0) {
                        int t = pinMap[cur.r][cur.c].remove(pinMap[cur.r][cur.c].size() - 1);
                        while (t != i) {
                            temp.add(t);
                            t = pinMap[cur.r][cur.c].remove(pinMap[cur.r][cur.c].size() - 1);
                        }
                        temp.add(t);
                        while (!temp.isEmpty()) {
                            t = temp.remove(temp.size() - 1);
                            pins[t].r = nr;
                            pins[t].c = nc;
                            pinMap[nr][nc].add(t);
                        }
                    } else {
                        int t = pinMap[cur.r][cur.c].remove(pinMap[cur.r][cur.c].size() - 1);
                        while (t != i) {
                            pins[t].r = nr;
                            pins[t].c = nc;
                            pinMap[nr][nc].add(t);
                            t = pinMap[cur.r][cur.c].remove(pinMap[cur.r][cur.c].size() - 1);
                        }
                        pins[t].r = nr;
                        pins[t].c = nc;
                        pinMap[nr][nc].add(t);
                    }
                    if (pinMap[nr][nc].size() >= 4) {
                        System.out.println(turn);
                        return;
                    }
                }
            }
        }
        System.out.println(-1);
    }

    static boolean inRange(int r, int c) {
        return r > 0 && r <= N && c > 0 && c <= N;
    }

    static void init() throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        pinMap = new ArrayList[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < N + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                pinMap[i][j] = new ArrayList<>();
            }
        }
        pins = new Pin[K + 1];
        for (int i = 1; i < K + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            pins[i] = new Pin(r, c, d);
            pinMap[r][c].add(i);
        }
        turn = 1;
        isEnd = false;
    }
}

class Pin {

    int r;
    int c;
    int d;

    public Pin(int r, int c, int d) {
        this.r = r;
        this.c = c;
        this.d = d;
    }
}