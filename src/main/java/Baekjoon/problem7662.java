package Baekjoon;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class problem7662 {

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            TreeMap<Long, Long> map = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                char cmd = st.nextToken().charAt(0);
                long number = Long.parseLong(st.nextToken());
                if (cmd == 'I') {
                    if (map.containsKey(number)) {
                        map.put(number, map.get(number) + 1);
                    } else {
                        map.put(number, 1L);
                    }
                } else {
                    if (map.isEmpty()) {
                        continue;
                    }
                    if (number == 1) {
                        long max = map.lastKey();
                        long next = map.get(max) - 1;
                        if (next == 0) {
                            map.remove(max);
                        } else {
                            map.put(max, next);
                        }
                    } else {
                        long min = map.firstKey();
                        long next = map.get(min) - 1;
                        if (next == 0) {
                            map.remove(min);
                        } else {
                            map.put(min, next);
                        }
                    }
                }
            }
            if (map.isEmpty()) {
                bw.write("EMPTY\n");
            } else {
                bw.write(map.lastKey() + " " + map.firstKey() + "\n");
            }
        }
        bw.flush();
    }
}
