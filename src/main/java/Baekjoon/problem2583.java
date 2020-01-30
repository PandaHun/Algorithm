package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem2583 {

	private static int N;
	private static int M;
	private static int K;
	private static int[][] map;
	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };
	private static List<Integer> answer;
	private static int number;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		answer = new ArrayList<>();
		number = 0;
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int[] r = new int[2];
			int[] c = new int[2];
			r[0] = Integer.parseInt(st.nextToken());
			c[0] = Integer.parseInt(st.nextToken());
			r[1] = Integer.parseInt(st.nextToken());
			c[1] = Integer.parseInt(st.nextToken());
			for(int i = r[0]; i< r[1]; i++) {
				for(int j = c[0] ; j < c[1] ; j++) {
					map[i][j] = -1;
				}
			}
		}
		for (int r = 0; r < M; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] == 0) {
					answer.add(solve(r,c));
					number++;
				}
			}
		}
		Collections.sort(answer);
		System.out.println(answer.size());
		for(int i : answer) {
			System.out.print(i + " ");
			
		}
		
	}
	private static int solve(int r, int c) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(r, c));
		int value = number + 1;
		int size = 1;
		map[r][c] = value;

		while (!q.isEmpty()) {
			Pos now = q.poll();

			for (int k = 0; k < 4; k++) {
				int nr = now.r + dr[k];
				int nc = now.c + dc[k];

				if (nr < 0 || nc < 0 || nr >= M || nc >= N || map[nr][nc] != 0) {
					continue;
				}
				if (map[nr][nc] == 0) {
					size++;
					map[nr][nc] = value;
					q.add(new Pos(nr,nc));
				}
			}
		}

		return size;
	}
}

class Pos {
	int r;
	int c;

	public Pos(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
