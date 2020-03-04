package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class problem12015 {

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        List<Integer> lis = new ArrayList<>();
        lis.add(0);
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int input = arr[i] = Integer.parseInt(st.nextToken());
            if (input > lis.get(lis.size() - 1)) {
                lis.add(input);
            } else {
                int left = 0;
                int right = lis.size() - 1;

                while (left < right) {
                    int mid = (left + right) >> 1;
                    if (lis.get(mid) >= input) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                lis.set(right, input);
            }
        }
        System.out.println(lis.size() - 1);
    }
}
