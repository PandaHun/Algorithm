package Baekjoon;

import java.io.*;
import java.util.HashMap;

public class problem4195 {

    static final int MAX = 200001;
    static int[] root, relation, level;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException, NumberFormatException {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int k = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            root = new int[MAX];
            relation = new int[MAX];
            level = new int[MAX];
            int idx = 1;
            for(int i = 1; i < MAX; i++) {
                root[i] = i;
                relation[i] = 1;
            }

            for (int i = 0; i < k; i++) {
                String[] friends = br.readLine().split(" ");
                if (!map.containsKey(friends[0])) {
                    map.put(friends[0], idx++);
                }
                if (!map.containsKey(friends[1])) {
                    map.put(friends[1], idx++);
                }
                int aIdx = map.get(friends[0]);
                int bIdx = map.get(friends[1]);
                merge(aIdx, bIdx);
            }
        }
        bw.flush();
    }

    static void merge(int a, int b) throws IOException{
        a = find(a);
        b = find(b);
        if(a == b) {
            bw.write(relation[a] + "\n");
            return;
        }
        if(level[a] > level[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        root[a] = b;
        relation[b] += relation[a];
        bw.write(relation[b] + "\n");

        if(level[a] == level[b]) {
            ++level[b];
        }
    }

    static int find(int node) {
        if( root[node] == node) {
            return node;
        }
        return root[node] = find(root[node]);
    }
}
