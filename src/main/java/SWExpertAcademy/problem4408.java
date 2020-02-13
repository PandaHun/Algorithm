package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class problem4408 {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] room = new int[201];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int start = (Integer.parseInt(st.nextToken()) + 1) / 2;
				int end = (Integer.parseInt(st.nextToken()) + 1) / 2;
				if (start > end) {
					int temp = start;
					start = end;
					end = temp;
				}
				for (; start <= end; start++) {
					room[start]++;
				}
			}
			int max = -1;
			for (int i = 1; i <= 200; i++) {
				max = Math.max(max, room[i]);
			}
			bw.append("#" + tc + " " + max + "\n");
		}
		bw.flush();

		br.close();
		bw.close();

	}
}
