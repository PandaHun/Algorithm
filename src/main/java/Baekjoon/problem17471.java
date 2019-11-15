package Baekjoon;
/*
 *  @Author: Pandahun
 *  @Content: 게리 맨더링
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class problem17471 {

    private static int N, answer = Integer.MAX_VALUE;
    private static int[] peoples;
    private static boolean[] elections;
    private static boolean[][] isConnected;

    public static void main( String[] args ) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        peoples = new int[N + 1];
        elections = new boolean[N + 1];
        isConnected = new boolean[N + 1][N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < N + 1; i++) {
            peoples[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            isConnected[i][i] = true;
            int number = Integer.parseInt(st.nextToken());
            for (int j = 0; j < number; j++) {
                int another = Integer.parseInt(st.nextToken());
                isConnected[i][another] = true;
                isConnected[another][i] = true;
            }
        }
        setElection(1);

        if(answer == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(answer);
    }

    static void setElection( int start ) {
        if (start == N + 1) {
            if (checkIsConnected(true) && checkIsConnected(false)) {
                answer = Math.min(answer, solve());
            }
            return;
        }
        elections[start] = true;
        setElection(start + 1);
        elections[start] = false;
        setElection(start + 1);
    }

    static boolean checkIsConnected( boolean flag ) {
        boolean[] visited = new boolean[N + 1];
        LinkedList<Integer> district = new LinkedList<Integer>();
        for (int i = 1; i < N + 1; i++) {
            if (elections[i] == flag) {
                district.addLast(i);
                visited[i] = true;
                break;
            }
        }
        while (!district.isEmpty()) {
            int now = district.pollFirst();

            for (int i = 1; i < N + 1; i++) {
                if (visited[i])
                    continue;
                if (flag != elections[i])
                    continue;
                if (isConnected[now][i] == false)
                    continue;
                district.addLast(i);
                visited[i] = true;
            }
        }

        for (int i = 1; i < N + 1; i++) {
            if (elections[i] != flag)
                continue;
            if (!visited[i])
                return false;
        }
        return true;
    }

    static int solve() {
        int firstDistrictValue = 0;
        int secondDistrictValue = 0;
        for (int i = 1; i < N + 1; i++) {
            if (elections[i])
                firstDistrictValue += peoples[i];
            else
                secondDistrictValue += peoples[i];
        }

        return Math.abs(firstDistrictValue - secondDistrictValue);
    }
}
