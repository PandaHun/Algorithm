package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class problem12738 {

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        List<Integer> lis = new ArrayList<>();
        lis.add(Integer.MIN_VALUE);
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < N+1; i++) {
            int value = arr[i] = Integer.parseInt(st.nextToken());
            if (lis.get(lis.size() - 1) < value) {
                lis.add(value);
            } else {
                int left = 1;
                int right = lis.size() - 1;
                while (left < right) {
                    int mid = (left + right) >> 1;

                    if (lis.get(mid) >= value) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                lis.set(right, value);
            }
        }
        System.out.println(lis.size() - 1);
    }
}
