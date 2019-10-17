package Baekjoon;
/*
 *  @Author: Pandahun
 *  @Content: 나무 재테크
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem16235 {

    private static int N, M, K;
    private static int[][] land, energy;
    private static PriorityQueue<Wood> treeList;
    private static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main( String[] args ) throws IOException, NumberFormatException{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] tmp=br.readLine().split(" ");
        N=Integer.parseInt(tmp[0]);
        M=Integer.parseInt(tmp[1]);
        K=Integer.parseInt(tmp[2]);
        land = new int[N + 1][N + 1];
        energy = new int[N + 1][N + 1];
        treeList = new PriorityQueue<>();
        for (int r = 1; r <= N; r++) {
            tmp= br.readLine().split(" ");
            for (int c = 1; c <= N; c++) {
                land[r][c] = 5;
                energy[r][c] = Integer.parseInt(tmp[c-1]);
            }
        }
        for (int i = 0; i < M; i++) {
            tmp=br.readLine().split(" ");
            int r = Integer.parseInt(tmp[0]);
            int c = Integer.parseInt(tmp[1]);
            int age = Integer.parseInt(tmp[2]);
            treeList.add(new Wood(r, c, age));
        }
        solve();
        System.out.println(treeList.size());
    }

    static List<Wood> dead;
    static List<Wood> breed;
    static void solve() {
        dead = new LinkedList<>();
        breed = new LinkedList<>();
        for (int year = 0; year < K; year++) {
            int tsize = treeList.size();
            PriorityQueue<Wood> newpq = new PriorityQueue<>();
            for(int i = 0 ; i<tsize;i++) {
                Wood tree = treeList.poll();
                if(land[tree.r][tree.c] < tree.age){
                    dead.add(new Wood(tree.r, tree.c, tree.age));
                    continue;
                }

                land[tree.r][tree.c] -=tree.age;
                newpq.add(new Wood(tree.r, tree.c, tree.age+1));

                if((tree.age+1)%5==0){
                    breed.add(new Wood(tree.r,tree.c, tree.age+1));
                }
            }
            treeList = new PriorityQueue<>(newpq);

            for(Wood now: dead){

                land[now.r][now.c] +=now.age/2;
            }
            dead.clear();

            for(Wood now: breed){
                int r = now.r;
                int c = now.c;
                for(int k = 0; k<8;k++){
                    int nr = r + dr[k];
                    int nc = c + dc[k];

                    if( nr < 1|| nr > N || nc <1 || nc>N) continue;

                    treeList.add(new Wood(nr, nc, 1));
                }
            }
            breed.clear();

            for (int r = 1; r <= N; r++) {
                for (int c = 1; c <= N; c++) {
                    land[r][c] += energy[r][c];
                }
            }
        }
    }
}

class Wood implements Comparable<Wood>{
    int r;
    int c;
    int age;

    public Wood( int r, int c, int age ) {
        this.r = r;
        this.c = c;
        this.age = age;
    }
    @Override
    public int compareTo(Wood o) {
        return this.age - o.age;
    }
}