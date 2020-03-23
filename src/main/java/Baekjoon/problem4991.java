package Baekjoon;

import java.io.*;
import java.util.*;

public class problem4991 {

    private static int W, H, cnt, result;
    private static int[][] dist;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static char[][] map;
    private static List<Dust> dusts;
    private static boolean[] selected;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            if (W == 0 && H == 0) {
                break;
            }
            map = new char[H][W];
            dusts = new ArrayList<>();
            String in;
            Dust start = null;
            for (int i = 0; i < H; i++) {
                in = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = in.charAt(j);
                    if (map[i][j] == 'o') {
                        start = new Dust(i, j);
                    } else if (map[i][j] == '*') {
                        dusts.add(new Dust(i, j));
                    }
                }
            }
            dusts.add(0, start);
            if (dusts.size() == 1) {
                bw.write("0\n");
                continue;
            }
            cnt = dusts.size();
            dist = new int[cnt][cnt];

            for (int i = 0; i < cnt; i++) {
                Dust go = dusts.get(i);
                for (int j = i + 1; j < cnt; j++) {
                    Dust to = dusts.get(j);
                    dist[i][j] = bfs(go, to, new boolean[H][W]);
                    dist[j][i] = dist[i][j];
                }
            }
            result = Integer.MAX_VALUE;
            selected = new boolean[cnt];
            selected[0] = true;
            dfs(0, 1, 0);

            if(result==Integer.MAX_VALUE) {
                bw.write("-1\n");
            } else {
                bw.write(result +"\n");
            }
        }
        bw.close();
    }

    static void dfs(int s, int count, int value) {
        if (value >= result) {
            return;
        }
        if (count == cnt) {
            result = value;
            return;
        }
        for (int i = 0; i < cnt; i++) {
            if (!selected[i] && dist[s][i] != 0) {
                selected[i] = true;
                dfs(i, count + 1, value + dist[s][i]);
                selected[i] = false;
            }
        }
    }

    static int bfs(Dust from, Dust to, boolean[][] visited) {
        int count = -1;
        Queue<Dust> q = new LinkedList<>();
        q.add(from);
        visited[from.r][from.c] = true;

        while (!q.isEmpty()) {
            count++;
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Dust d = q.poll();
                if (d.r == to.r && d.c == to.c) {
                    return count;
                }
                for (int k = 0; k < 4; k++) {
                    int nr = d.r + dr[k];
                    int nc = d.c + dc[k];
                    if (nr >= 0 && nc >= 0 && nr < H && nc < W && map[nr][nc] != 'x' && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        q.add(new Dust(nr, nc));
                    }
                }
            }
        }
        return 0;
    }
}

class Dust {

    int r;
    int c;

    public Dust(int r, int c) {
        this.r = r;
        this.c = c;
    }
}