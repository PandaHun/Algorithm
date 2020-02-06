import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class problem3190 {

	private static int N;
	private static int K;
	private static int L;
	private static int[][] map;
	private static int dir;
	private static int answer;
	private static int[] seconds;
	private static char[] operations;
	private static int[] dr = { 0, -1, 0, 1 };
	private static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 1;
		}
		L = Integer.parseInt(br.readLine());
		seconds = new int[L];
		operations = new char[L];
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			seconds[i] = Integer.parseInt(st.nextToken());
			operations[i] = st.nextToken().charAt(0);
		}
		LinkedList<Integer> ll = new LinkedList<>();
		Deque<Point> de = new LinkedList<>();
		de.add(new Point(1, 1));
		map[1][1] = 2;
		dir = 0;
		answer = 0;
		int operId = 0;
		while (true) {

			if (operId < L && answer == seconds[operId]) {
				if (operations[operId++] == 'D') {
					dir = (4 + (dir - 1)) % 4;
				} else {
					dir = (dir + 1) % 4;
				}
			}

			int nr = de.getFirst().r + dr[dir];
			int nc = de.getFirst().c + dc[dir];
			if (nr > N || nr < 1 || nc > N || nc < 1 || map[nr][nc] == 2) {
				answer += 1;
				break;
			}
			if (map[nr][nc] == 1) {
				map[nr][nc] = 2;
				de.addFirst(new Point(nr, nc));
			} else {
				map[nr][nc] = 2;
				de.addFirst(new Point(nr, nc));

				Point remove = de.removeLast();
				map[remove.r][remove.c] = 0;
			}

			answer++;
		}
		System.out.println(answer);
	}

}

class Point {
	int r;
	int c;

	public Point(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
