package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem12100 {

	private static int N;
	private static int[][] map;
	private static int[][] nmap;
	private static boolean[][] visited;
	private static int[] lean;
	private static int[] dr = { 1, -1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };
	private static int max;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		lean = new int[5];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		max = Integer.MIN_VALUE;
		solve(0);
		System.out.println(max);
	}
	
	private static void print() {
		for (int[] j : nmap) {
			for (int i : j) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	private static void solve(int depth) {
		if (depth == 5) {
			leanMap();
			return;
		}
		for (int i = 0; i < 4; i++) {
			lean[depth] = i;
			solve(depth + 1);
		}
	}

	private static void leanMap() {
		nmap = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				nmap[r][c] = map[r][c];
			}
		}
		for (int i = 0; i < 5; i++) {
			visited = new boolean[N][N];
			if (lean[i] == 0) {
				for (int r = N - 1; r >= 0; r--) {
					for (int c = 0; c < N; c++) {
						doLean(r, c, lean[i]);
					}
				}
			} else if (lean[i] == 1) {
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						doLean(r, c, lean[i]);
					}
				}
			} else if (lean[i] == 2) {
				for (int c = 0; c < N; c++) {
					for (int r = 0; r < N; r++) {
						doLean(r, c, lean[i]);
					}
				}
			} else if (lean[i] == 3) {
				for (int c = N - 1; c >= 0; c--) {
					for (int r = 0; r < N; r++) {
						doLean(r, c, lean[i]);
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (nmap[i][j] > max) {
					max = nmap[i][j];
				}
			}
		}
	}

	private static void doLean(int r, int c, int dir) {
		if (nmap[r][c] == 0) {
			return;
		}
		while (true) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
				return;
			}
			if (visited[nr][nc]) {
				return;
			}
			if (nmap[nr][nc] == nmap[r][c]) {
				visited[nr][nc] = true;
				nmap[nr][nc] *= 2;
				nmap[r][c] = 0;
				return;
			} else if (nmap[nr][nc] != 0) {
				return;
			}
			nmap[nr][nc] = nmap[r][c];
			nmap[r][c] = 0;
			r = nr;
			c = nc;
		}
	}
}
