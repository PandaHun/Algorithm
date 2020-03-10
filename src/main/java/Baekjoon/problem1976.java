package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem1976 {

    static int[] root;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        root = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            root[i] = i;
        }
        for(int i = 1 ; i < n +1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j < n+1; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 1) {
                    union(i,j);
                }
            }
        }
        int[] city = new int[m];
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i < m; i++) {
            city[i] = Integer.parseInt(st.nextToken());
        }
        boolean isAble = true;
        for(int i = 0 ; i < m-1; i++) {
            if(!find(city[i], city[i+1])) {
                isAble = false;
                break;
            }
        }
        if(isAble) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    static boolean find(int a, int b) {
        int aRoot = getRoot(a);
        int bRoot = getRoot(b);
        if(aRoot == bRoot) {
            return true;
        }
        return false;
    }

    static void union(int a, int b) {
        int aRoot = getRoot(a);
        int bRoot = getRoot(b);
        if (aRoot <= bRoot) {
            root[bRoot] = aRoot;
        } else {
            root[aRoot] = bRoot;
        }
    }

    static int getRoot(int node) {
        if( root[node] == node) {
            return node;
        } else {
            return root[node] = getRoot(root[node]);
        }
    }
}
