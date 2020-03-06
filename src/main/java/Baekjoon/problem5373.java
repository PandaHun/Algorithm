package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class problem5373 {

    private static char[][][] cubes;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            initCubes();
            int k = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            while (st.hasMoreTokens()) {
                rotateCubes(st.nextToken());
            }
            printCube();
        }
        bw.flush();
    }

    private static void printCube() throws IOException {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                bw.write(cubes[0][j][2 - i] + "");
            }
            bw.write("\n");
        }
    }

    private static void go(int f, int u, int l, int d, int r, boolean clock) {
        char[][] temp = new char[3][3];
        char[] turn = new char[3];
        if (clock) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    temp[i][j] = cubes[f][2 - j][i];
                }
            }
            for (int i = 0; i < 3; i++) {
                turn[i] = cubes[u][i][0];
            }
            for (int i = 0; i < 3; i++) {
                cubes[u][i][0] = cubes[l][0][2 - i];
            }
            for (int i = 0; i < 3; i++) {
                cubes[l][0][2 - i] = cubes[d][2][i];
            }
            for (int i = 0; i < 3; i++) {
                cubes[d][2][i] = cubes[r][2 - i][2];
            }
            for (int i = 0; i < 3; i++) {
                cubes[r][2 - i][2] = turn[i];
            }
            cubes[f] = temp;
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    temp[i][j] = cubes[f][j][2 - i];
                }
            }
            for (int i = 0; i < 3; i++) {
                turn[i] = cubes[u][i][0];
            }
            for (int i = 0; i < 3; i++) {
                cubes[u][i][0] = cubes[r][2 - i][2];
            }
            for (int i = 0; i < 3; i++) {
                cubes[r][2 - i][2] = cubes[d][2][i];
            }
            for (int i = 0; i < 3; i++) {
                cubes[d][2][i] = cubes[l][0][2 - i];
            }
            for (int i = 0; i < 3; i++) {
                cubes[l][0][2 - i] = turn[i];
            }
            cubes[f] = temp;
        }
    }

    private static void rotateCubes(String operation) {
        boolean isClock = operation.charAt(1) == '+';

        switch (operation.charAt(0)) {
            case 'U':
                go(0, 4, 2, 5, 3, isClock);
                break;
            case 'D':
                go(1, 3, 5, 2, 4, isClock);
                break;
            case 'F':
                go(2, 0, 4, 1, 5, isClock);
                break;
            case 'B':
                go(3, 5, 1, 4, 0, isClock);
                break;
            case 'L':
                go(4, 2, 0, 3, 1, isClock);
                break;
            case 'R':
                go(5, 1, 3, 0, 2, isClock);
                break;
        }
    }

    private static void initCubes() {
        cubes = new char[6][][];
        char[] colors = new char[]{'w', 'y', 'r', 'o', 'g', 'b'};
        for (int i = 0; i < 6; i++) {
            cubes[i] = new char[3][3];
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    cubes[i][j][k] = colors[i];
                }
            }
        }
    }
}
