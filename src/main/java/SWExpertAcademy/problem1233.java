package SWEA_Solution;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class problem1233 {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder answer = new StringBuilder();
		for (int tc = 1; tc <= 10; tc++) {
			answer.append("#" + tc + " ");
			int N = Integer.parseInt(br.readLine());
			int leaf = N / 2 + 1;
			boolean isAble = true;
			for (int i = 1; i <= N; i++) {
				String input = br.readLine();
				if (!isAble) {
					continue;
				}
				String[] in = input.split(" ");
				if ((in[1].charAt(0) > '0' && in[1].charAt(0) <= '9') && i < leaf) {
					isAble = false;
					continue;
				}
				if (i >= leaf && (in[1].charAt(0) == '-' || in[1].charAt(0) == '*' || in[1].charAt(0) == '/'
						|| in[1].charAt(0) == '+')) {
					isAble = false;
				}
			}
			answer.append((isAble ? 1 : 0) + "\n");
		}
		bw.write(answer.toString());
		bw.flush();
	}
}
