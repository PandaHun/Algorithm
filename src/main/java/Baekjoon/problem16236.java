package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem16236 {

    private static int N;
    private static int[][] map;
    private static int[][] distances;
    private static boolean[][] visited;
    private static Pos shark;
    private static List<Pos> fishs;
    private static int sharkSize = 2;
    private static int sharkEat = 0;
    private static int answer = 0;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] == 9) {
                    shark = new Pos(r, c, 0);
                    map[r][c] = 0;
                }
            }
        }
        solve();
        System.out.println(answer);
    }

    private static void solve() {
        while (true) {
            distances = new int[N][N];
            visited = new boolean[N][N];
            findDistances();
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] < sharkSize && map[i][j] > 0 && distances[i][j] > 0) {
                        min = Math.min(min, distances[i][j]);
                    }
                }
            }

            fishs = new ArrayList<>();
            for(int i = 0 ; i < N; i++) {
                for(int j = 0 ; j < N ; j++) {
                    if( map[i][j] < sharkSize && map[i][j] > 0 && distances[i][j] == min) {
                        fishs.add(new Pos(i,j,0));
                    }
                }
            }
            if(fishs.isEmpty()) {
                break;
            }else if( fishs.size() == 1) {
                int fishR = fishs.get(0).r;
                int fishC = fishs.get(0).c;

                answer += distances[fishR][fishC];
                map[fishR][fishC] = 0;
                sharkEat++;
                if( sharkEat == sharkSize) {
                    sharkEat = 0;
                    sharkSize++;
                }
                map[shark.r][shark.c] = 0;
                shark.r = fishR;
                shark.c = fishC;
                continue;
            }else {
                int minR = Integer.MAX_VALUE;

                for( Pos now : fishs) {
                    minR = Math.min(now.r, minR);
                }
                int minC = Integer.MAX_VALUE;
                int minAmount = 0;

                for(Pos now : fishs) {
                    if( now.r == minR) {
                        minAmount++;
                        minC = Math.min(minC, now.c);
                    }
                }
                if(minAmount == 1) {
                    int fishR = 0;
                    int fishC = 0;
                    for (Pos now : fishs) {
                        if (now.r == minR) {
                            fishR = now.r;
                            fishC = now.c;
                            break;
                        }
                    }
                    answer += distances[fishR][fishC];
                    map[fishR][fishC] = 0;
                    sharkEat++;
                    if( sharkEat == sharkSize) {
                        sharkEat = 0;
                        sharkSize++;
                    }
                    map[shark.r][shark.c] = 0;
                    shark.r = fishR;
                    shark.c = fishC;
                    continue;
                }else{
                    int fishR = 0;
                    int fishC = 0;
                    for(Pos now : fishs) {
                        if(now.r == minR && now.c == minC) {
                            fishR = now.r;
                            fishC = now.c;
                            break;
                        }
                    }
                    answer += distances[fishR][fishC];
                    map[fishR][fishC] = 0;
                    sharkEat++;
                    if( sharkEat == sharkSize) {
                        sharkEat = 0;
                        sharkSize++;
                    }
                    map[shark.r][shark.c] = 0;
                    shark.r = fishR;
                    shark.c = fishC;
                    continue;
                }
            }
        }
    }

    private static void findDistances() {
        Queue<Pos> queue = new LinkedList<>();
        int r = shark.r;
        int c = shark.c;
        int value = 0;
        distances[r][c] = value;
        visited[r][c] = true;
        queue.add(new Pos(r, c, value));
        while (!queue.isEmpty()) {
            Pos now = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nr = now.r + dr[k];
                int nc = now.c + dc[k];
                int nValue = now.value;

                if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
                    continue;
                }
                if (!visited[nr][nc] && map[nr][nc] <= sharkSize) {
                    queue.add(new Pos(nr, nc, nValue+1));
                    distances[nr][nc] = nValue+1;
                    visited[nr][nc] = true;
                }
            }
        }
    }
}

class Pos {
    int r;
    int c;
    int value;

    public Pos(int r, int c, int value) {
        this.r = r;
        this.c = c;
        this.value = value;
    }
}