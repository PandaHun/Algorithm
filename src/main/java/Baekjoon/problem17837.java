package Baekjoon;

import java.io.*;
import java.util.*;

public class problem17837 {

    private static int N, K, turn;
    private static int[][] map;
    private static Deque<Pin>[][] pins;
    private static List<Pin> pinsList;
    private static int[] dr = {0, 0, 0, -1, 1};
    private static int[] dc = {0, 1, -1, 0, 0};

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        pins = new Deque[N + 1][N + 1];
        pinsList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                pins[i][j] = new LinkedList<>();
            }
        }
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            pinsList.add(new Pin(r, c, d));
            pins[r][c].add(pinsList.get(i));
        }
        List<Pin> temp;
        while (turn <= 1000) {
            int len = pinsList.size();

            for (int i = 0; i < len; i++) {
                Pin now = pinsList.get(i);
                temp = new ArrayList<>();
                int nr = now.r + dr[now.directions];
                int nc = now.c + dc[now.directions];
                if (isOutRange(nr, nc) || map[nr][nc] == 2) {
                    now.directions = changeDirection(now.directions);
                    nr = now.r + dr[now.directions];
                    nc = now.c + dc[now.directions];
                }
                if (!isOutRange(nr, nc) && map[nr][nc] != 2) {
                    if (map[nr][nc] == 0) {
                        while (!pins[now.r][now.c].isEmpty()) {
                            Pin cur = pins[now.r][now.c].poll();
                            if (!cur.equals(now)) {
                                temp.add(cur);
                            } else {
                                pins[now.r][now.c].addFirst(cur);
                                break;
                            }
                        }
                        while (!pins[now.r][now.c].isEmpty()) {
                            Pin cur = pins[now.r][now.c].poll();
                            cur.r = nr;
                            cur.c = nc;
                            pins[nr][nc].add(cur);
                        }
                        pins[now.r][now.c].addAll(temp);
                    } else if (map[nr][nc] == 1) {
                        int size = pins[now.r][now.c].size();
                        for (int k = size - 1; k >= 0; k--) {
                            Pin cur = pins[now.r][now.c].getLast();
                            cur.r = nr;
                            cur.c = nc;
                            temp.add(cur);
                            if( cur.equals(now)) {
                                break;
                            }
                        }
                    }
                    if(pins[nr][nc].size() >=4) {
                        System.out.println(turn);
                        return;
                    }
                }
            }
            turn++;
        }
        System.out.println(-1);
    }

    private static boolean isOutRange(int nr, int nc) {
        if (nr <= 0 || nr > N || nc <= 0 || nc > N) {
            return true;
        }
        return false;
    }

    private static int changeDirection(int direction) {
        if (direction == 1) {
            return 2;
        } else if (direction == 2) {
            return 1;
        } else if (direction == 3) {
            return 4;
        } else {
            return 3;
        }
    }
}

class Pin {

    int r;
    int c;
    int directions;

    public Pin(int r, int c, int directions) {
        this.r = r;
        this.c = c;
        this.directions = directions;
    }
}