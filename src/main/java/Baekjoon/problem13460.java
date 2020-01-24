package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem13460 {

    private static char[][] map;
    private static int N;
    private static int M;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static boolean[][][][] visited;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[10][10][10][10];
        Information information = new Information(0, 0, 0, 0, 0);
        for (int i = 0; i < N; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = temp[j];
                if (map[i][j] == 'R') {
                    information.redR = i;
                    information.redC = j;
                } else if (map[i][j] == 'B') {
                    information.blueR = i;
                    information.blueC = j;
                }
            }
        }
        bfs(information);
    }

    private static void bfs(Information information) {
        Queue<Information> queue = new LinkedList<>();
        queue.offer(information);

        while (!queue.isEmpty()) {

            Information now = queue.poll();
            visited[now.redR][now.redC][now.blueR][now.blueC] = true;

            if (now.count >= 10) {
                System.out.println(-1);
                return;
            }
            for (int k = 0; k < 4; k++) {

                int nBlueR = now.blueR;
                int nBlueC = now.blueC;
                while (map[nBlueR + dr[k]][nBlueC + dc[k]] != '#') {
                    nBlueR += dr[k];
                    nBlueC += dc[k];
                    if (map[nBlueR][nBlueC] == 'O') {
                        break;
                    }
                }

                int nRedR = now.redR;
                int nRedC = now.redC;
                while (map[nRedR + dr[k]][nRedC + dc[k]] != '#') {
                    nRedR += dr[k];
                    nRedC += dc[k];
                    if (map[nRedR][nRedC] == 'O') {
                        break;
                    }
                }

                if (map[nBlueR][nBlueC] == 'O') {
                    continue;
                }
                if (map[nRedR][nRedC] == 'O') {
                    System.out.println(now.count + 1);
                    return;
                }

                if (nRedR == nBlueR && nRedC == nBlueC) {

                    switch (k) {
                        //북,남,서,동
                        case 0:
                            if (now.redR > now.blueR) {
                                nRedR++;
                            } else {
                                nBlueR++;
                            }
                            break;
                        case 1:
                            if (now.redR > now.blueR) {
                                nBlueR--;
                            } else {
                                nRedR--;
                            }
                            break;
                        case 2:
                            if (now.redC > now.blueC) {
                                nRedC++;
                            } else {
                                nBlueC++;
                            }
                            break;
                        case 3:
                            if (now.redC > now.blueC) {
                                nBlueC--;
                            } else {
                                nRedC--;
                            }
                            break;
                    }
                }
                if (!visited[nRedR][nRedC][nBlueR][nBlueC]) {
                    queue.offer(new Information(nRedR, nRedC, nBlueR, nBlueC, now.count + 1));
                }
            }
        }
        System.out.println(-1);
    }
}

class Information {
    int redR;
    int redC;
    int blueR;
    int blueC;
    int count;

    public Information(int redR, int redC, int blueR, int blueC, int count) {
        this.redR = redR;
        this.redC = redC;
        this.blueR = blueR;
        this.blueC = blueC;
        this.count = count;
    }
}