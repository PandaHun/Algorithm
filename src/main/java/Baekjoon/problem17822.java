package Baekjoon;
/*
 *  @Author: Pandahun
 *  @Content: 원판 돌리기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem17822 {

    private static int N, M, T, answer;
    private static int[][] operation, disk;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static boolean isAdjcent;

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        disk = new int[N + 1][M];
        operation = new int[T][3];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                disk[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            operation[i][0] = Integer.parseInt(st.nextToken());
            operation[i][1] = Integer.parseInt(st.nextToken());
            operation[i][2] = Integer.parseInt(st.nextToken());
        }

        int order = 0;
        while (T > 0) {
            isAdjcent = false;
            System.out.println(T);
            rotateDisk(order);
            T--;
            order++;
        }
        getSum();
        System.out.println(answer);
    }

    static void print() {
        for (int i = 1; i < N + 1; i++) {
            for (int j = 0; j < M; j++)
                System.out.print(disk[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    static void rotateDisk( int order ) {
        doOperation(order);
        print();

        for (int i = 1; i < N + 1; i++) {
            for (int j = 0; j < M; j++) {
                if (disk[i][j] != 0)
                    checkAdj(i, j);
            }
        }
        print();
        if (!isAdjcent) {
            System.out.println("보정 " + order);
            editDisk();
        }
        print();
    }

    static void doOperation( int order ) {
        int diskNumber = operation[order][0];
        int direction = operation[order][1];
        int rotateCount = operation[order][2] % M;
        while (rotateCount > 0) {
            for (int i = diskNumber; i < N + 1; i += diskNumber) {
                //시계
                if (direction == 0) {
                    int temp = disk[i][M - 1];
                    for (int index = M - 1; index > 0; index--) {
                        disk[i][index] = disk[i][index - 1];
                    }
                    disk[i][0] = temp;
                } else {
                    int temp = disk[i][0];
                    for (int index = 0; index < M - 1; index++) {
                        disk[i][index] = disk[i][index + 1];
                    }
                    disk[i][M - 1] = temp;
                }
            }
            rotateCount--;
        }
    }

    static void checkAdj( int r, int c ) {
        Queue<DiskInfo> q = new LinkedList<>();
        q.add(new DiskInfo(r, c, disk[r][c]));
        while (!q.isEmpty()) {

            DiskInfo now = q.poll();
            if (now.value != 0) {
                for (int i = 0; i < 4; i++) {

                    int nr = now.r + dr[i];
                    int nc = now.c + dc[i];

                    if (nr < 1 || nr > N) continue;
                    if (nc == -1) {
                        nc = M - 1;
                    } else if (nc == M) {
                        nc = 0;
                    }
                    if (disk[nr][nc] != 0 && now.value == disk[nr][nc]) {
                        disk[nr][nc] = 0;
                        q.add(new DiskInfo(nr, nc, now.value));
                        isAdjcent = true;
                    }
                }
            }
        }
    }

    static void editDisk() {
        int cnt = 0;
        int sum = 0;
        for (int r = 1; r < N + 1; r++) {
            for (int c = 0; c < M; c++) {
                if (disk[r][c] != 0) {
                    cnt++;
                    sum += disk[r][c];
                }
            }
        }
        double avg = (double) sum / cnt;
        System.out.println("AVG: " + avg);
        for (int r = 1; r < N + 1; r++) {
            for (int c = 0; c < M; c++) {
                if (disk[r][c] != 0) {
                    if (disk[r][c] > avg)
                        disk[r][c]--;
                    else if (disk[r][c] < avg)
                        disk[r][c]++;
                }
            }
        }
    }

    static void getSum() {
        answer = 0;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 0; j < M; j++) {
                answer += disk[i][j];
            }
        }
    }
}

class DiskInfo {
    int r;
    int c;
    int value;

    public DiskInfo( int r, int c, int value ) {
        this.r = r;
        this.c = c;
        this.value = value;
    }
}