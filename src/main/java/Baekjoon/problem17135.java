package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class problem17135 {

    private static int N, M, D;
    private static int[][] origin, map;
    private static int[] archers;
    private static int[] arr;
    private static int killed, answer;
    private static List<Monster> monsterList, archerLists;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        origin = new int[N + 1][M];
        archers = new int[3];
        arr = new int[M];
        answer = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                origin[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < M; i++) {
            arr[i] = i;
        }
        solve(0, 0);
        System.out.println(answer);
    }

    private static void solve(int idx, int depth) {
        if (depth == 3) {
            monsterList = new ArrayList<>();
            archerLists = new ArrayList<>();
            copyMap();
            for (int i = 0; i < 3; i++) {
                map[N][arr[archers[i]]] = 2;
                archerLists.add(new Monster(N, archers[i]));
            }
            startGame();
            answer = Math.max(answer, killed);
            return;
        }
        if (idx == M) {
            return;
        }
        archers[depth] = arr[idx];
        solve(idx + 1, depth + 1);
        solve(idx + 1, depth);
    }

    private static void startGame() {
        killed = 0;
        while (monsterList.size() != 0) {
            List<Monster> kill = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                int[] dist = new int[monsterList.size()];
                int minDistance = Integer.MAX_VALUE;

                for (int j = 0; j < monsterList.size(); j++) {
                    dist[j] = Math.abs(archerLists.get(i).r - monsterList.get(j).r)
                            + Math.abs(archerLists.get(i).c - monsterList.get(j).c);
                    if (minDistance > dist[j]) {
                        minDistance = dist[j];
                    }
                }

                List<Monster> find = new ArrayList<>();
                for (int j = 0; j < monsterList.size(); j++) {
                    if (dist[j] == minDistance) {
                        if (dist[j] <= D) {
                            find.add(monsterList.get(j));
                        }
                    }
                }

                if (find.size() == 0) {
                    continue;
                } else if (find.size() == 1) {
                    kill.add(find.get(0));
                } else {
                    int minC = Integer.MAX_VALUE;

                    for (int j = 0; j < find.size(); j++) {
                        if (find.get(j).c < minC) {
                            minC = find.get(j).c;
                        }
                    }
                    for (int j = 0; j < find.size(); j++) {
                        if (minC == find.get(j).c) {
                            kill.add(find.get(j));
                        }
                    }
                }
            }
            for (int i = 0; i < kill.size(); i++) {
                for (int j = 0; j < monsterList.size(); j++) {
                    if (kill.get(i).r == monsterList.get(j).r && kill.get(i).c == monsterList.get(j).c) {
                        monsterList.remove(j);
                        killed++;
                        break;
                    }
                }
            }

            int size = monsterList.size();
            int idx = 0;
            while (size > 0) {
                if (monsterList.get(idx).r + 1 != N) {
                    monsterList.add(new Monster(monsterList.get(idx).r + 1, monsterList.get(idx).c));
                }
                monsterList.remove(idx);
                size--;
            }
        }
    }

    private static void copyMap() {
        map = new int[N + 1][M];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                map[r][c] = origin[r][c];
                if (map[r][c] == 1) {
                    monsterList.add(new Monster(r, c));
                }
            }
        }
    }
}

class Monster {

    int r;
    int c;

    public Monster(int r, int c) {
        this.r = r;
        this.c = c;
    }
}