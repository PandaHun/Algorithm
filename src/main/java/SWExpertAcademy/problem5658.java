package SWExpertAcademy;

import java.io.*;
import java.util.*;

public class problem5658 {

    static int N, K;
    static String input;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++) {
            bw.write("#"+ tc + " ");
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            input = br.readLine();
            int answer = solve(N /4);
            bw.write(answer +"\n");
        }
        bw.flush();
    }

    static int solve(int len) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ; i < len; i++) {
            input = shift();
            set.addAll(parse(len));
        }

        List<Integer> list = new ArrayList<>();
        list.addAll(set);
        Collections.sort(list);
        return list.get(list.size() - K);
    }

    static List<Integer> parse(int len) {
        List<Integer> list = new ArrayList<>();
        String temp;
        for (int i = 0; i < 4; i++) {
            temp = input.substring(i * len, i * len + len);
            list.add(Integer.parseInt(temp, 16));
        }
        return list;
    }

    static String shift() {
        StringBuilder sb = new StringBuilder();
        String first = input.substring(0, input.length() - 1);
        String last = input.substring(input.length() - 1);
        sb.append(last);
        sb.append(first);
        return sb.toString();
    }
}
