package SWExpertAcademy;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class problem4050 {

    static int N, answer;
    static Integer[] arr;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            answer = 0;
            arr = new Integer[N];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                answer += arr[i];
            }
            Arrays.sort(arr, (o1, o2) -> o2 - o1);
            for (int i = 2; i < N; i += 3) {
                answer -= arr[i];
            }
            bw.write("#" + tc + " " + answer + "\n");
        }
        bw.flush();
    }
}
