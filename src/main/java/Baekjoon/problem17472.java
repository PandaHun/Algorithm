package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem17472 {

    static int N, M, K;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static PriorityQueue<Bridge> pq;
    static int[] parents;
    static List<Bridge> mst;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        K = 0;
        visited = new boolean[N][M];
        //섬 라벨
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (!visited[r][c] && map[r][c] == 1) {
                    K++;
                    labelling(r, c);

                }
            }
        }
        pq = new PriorityQueue<>();
        for (int i = 1; i < K; i++) {
            findBridge(i);
        }
        parents = new int[K + 1];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        if (pq.size() == 0) {
            System.out.println(-1);
            return;
        }
        mst = new ArrayList<>();
        while(mst.size() < K - 1) {
            Bridge bridge = pq.poll();
            if(bridge == null) {
                System.out.println("-1");
                return;
            }
            if(find(bridge.s)!=find(bridge.e)) {
                mst.add(bridge);
                union(bridge);
            }
        }
        int answer = 0;
        for (Bridge now : mst) {
            answer += now.v;
        }
        System.out.println(answer);
    }

    static void union(Bridge bridge) {
        int s = find(bridge.s);
        int e = find(bridge.e);

        if (s != e) {
            parents[e] = s;
        }
    }

    static int find(int x) {
        if (x == parents[x]) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    static void findBridge(int num) {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] == num) {

                    for (int i = 0; i < 4; i++) {
                        int tr = r;
                        int tc = c;
                        int cnt = 0;
                        while (true) {
                            int nr = tr + dr[i];
                            int nc = tc + dc[i];
                            if (outOfRange(nr, nc)) {
                                break;
                            } else if (map[nr][nc] == num) {
                                break;
                            } else if (map[nr][nc] == 0) {
                                tr = nr;
                                tc = nc;
                                cnt++;
                            } else {
                                if (cnt > 1) {
                                    pq.add(new Bridge(num, map[nr][nc], cnt));
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    static void labelling(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        map[r][c] = K;
        visited[r][c] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                if (outOfRange(nr, nc) || visited[nr][nc]) {
                    continue;
                }
                if (map[nr][nc] == 1) {
                    queue.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                    map[nr][nc] = K;
                }
            }
        }
    }

    static boolean outOfRange(int r, int c) {
        return r < 0 || r >= N || c < 0 || c >= M;
    }
}

class Bridge implements Comparable<Bridge> {

    int s;
    int e;
    int v;

    public Bridge(int s, int e, int v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }

    @Override
    public int compareTo(Bridge o) {
        return this.v - o.v;
    }
}