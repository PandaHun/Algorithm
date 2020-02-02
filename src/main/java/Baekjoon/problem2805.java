package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem2805 {

    private static int N;
    private static int K;
    private static int[] arr;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        int max = 0;
        boolean isIn = false;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println(binarySearch(0, max));
    }

    private static int binarySearch(int start, int end) {
        while( start <= end ) {
            int middle = (start + end) / 2;

            if( cut(middle)) {
                start = middle + 1;
            }else {
                end = middle - 1;
            }
        }
        return end;
    }

    private static boolean cut(int cutHeigth) {
        long sum = 0;
        for( int i : arr) {
            sum += i - cutHeigth > 0 ? i - cutHeigth : 0;
        }

        if(sum >= K) {
            return true;
        }
        return false;
    }
}
