package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class problem15686 {

	private static int N, M;
	private static int[][] town, dist;
	private static List<Dot> chiken;
	private static boolean[] selected;
	private static int answer;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		chiken = new ArrayList<>();
		town = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				town[i][j] = Integer.parseInt(st.nextToken());
				if (town[i][j] == 2) {
					chiken.add(new Dot(i, j));
				}
			}
		}
		answer = Integer.MAX_VALUE;
		selected = new boolean[chiken.size()];
		solve(0, 0);
		System.out.println(answer);
	}

	private static void solve(int depth, int index) {

		if (depth == M) {
			int res = bfs();
			answer = Math.min(answer, res);
			return;
		}
		if (index >= selected.length) {
			return;
		}

		selected[index] = true;
		solve(depth + 1, index + 1);
		selected[index] = false;
		solve(depth, index + 1);
	}

	private static int bfs() {
		int ret = 0;
		List<Dot> now = new ArrayList<>();
		for (int i = 0; i < selected.length; i++) {
			if (selected[i]) {
				now.add(chiken.get(i));
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (town[i][j] == 1) {
					int temp = Integer.MAX_VALUE;
					for (Dot d : now) {
						temp = Math.min(temp, getDist(d, i, j));
					}
					ret += temp;
				}
			}
		}
		return ret;
	}

	private static int getDist(Dot d1, int r, int c) {
		return Math.abs(d1.r - r) + Math.abs(d1.c - c);
	}
}

class Dot {

	int r;
	int c;

	public Dot(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
