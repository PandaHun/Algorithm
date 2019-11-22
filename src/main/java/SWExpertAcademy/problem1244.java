package SWExpertAcademy;
/*
 *  @Author: Pandahun
 *  @Content: 최대 상금
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem1244 {

    private static String prices;
    private static char[] price;
    private static int number, answer;

    public static void main( String[] args ) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= testCase; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            prices = st.nextToken();
            number = Integer.parseInt(st.nextToken());
            price = prices.toCharArray();

            answer = Integer.MIN_VALUE;
            solve(0, 0);

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
    }

    static void solve( int current, int depth ) {
        if (depth == number) {
            int max = Integer.parseInt(new String(price));
            answer = answer > max ? answer : max;
            return;
        }

        for (int i = current; i < price.length; i++) {
            for (int j = i + 1; j < price.length; j++) {
                if (price[i] <= price[j]) {
                    swap(i, j);
                    solve(current, depth + 1);
                    swap(i, j);
                }
            }
        }
    }

    static void swap( int p, int q ) {
        char temp = price[p];
        price[p] = price[q];
        price[q] = temp;
    }
}
