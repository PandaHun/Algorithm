import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem17406 {

	private static int N, M, K;
	private static int[][] origin, nmap;
	private static int[][] operation;
	private static int[] order;
	private static boolean[] used;
	private static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		origin = new int[N + 1][M + 1];
		operation = new int[K][3];
		order = new int[K];
		used = new boolean[K];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				origin[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				operation[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve(0);
		System.out.println(answer);
	}

	private static void solve(int depth) {
		if (depth == K) {
			rotateArray();
			getValue();
			return;
		}
		for (int i = 0; i < K; i++) {
			if (!used[i]) {
				used[i] = true;
				order[depth] = i;
				solve(depth + 1);
				used[i] = false;
			}
		}
	}

	private static void rotateArray() {
		copyArray();
		for (int k = 0; k < K; k++) {
			int r = operation[order[k]][0];
			int c = operation[order[k]][1];
			int s = operation[order[k]][2];
			for (int i = 1; i <= s; i++) {
				int temp = nmap[r - i + 1][c - i];
				for (int nr = r - i + 1; nr < r + i; nr++) {
					nmap[nr][c - i] = nmap[nr + 1][c - i];
				}
				for (int nc = c - i; nc < c + i; nc++) {
					nmap[r + i][nc] = nmap[r + i][nc + 1];
				}
				for (int nr = r + i; nr > r - i; nr--) {
					nmap[nr][c + i] = nmap[nr - 1][c + i];
				}
				for (int nc = c + i; nc > c - i; nc--) {
					nmap[r - i][nc] = nmap[r - i][nc - 1];
				}
				nmap[r-i][c-i] = temp;
			}
		}
	}

	private static void copyArray() {
		nmap = new int[N + 1][M + 1];
		for (int i = 0; i <= N; i++) {
			System.arraycopy(origin[i], 0, nmap[i], 0, M+1);
		}
	}

	private static void getValue() {
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= M; j++) {
				sum += nmap[i][j];
			}
			answer = answer > sum ? sum : answer;
		}
	}
}
