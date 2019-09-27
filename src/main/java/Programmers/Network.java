package Programmers;

/*
https://programmers.co.kr/learn/courses/30/lessons/43162?language=java
 */
public class Network {
    static boolean[][] link;
    static int answer;


    public static int solution(int n, int[][] computers) {
        answer = 0;
        link = new boolean[n][n];
        for(int i=0;i<n;i++){
            if(!link[i][i]) {
                solve(computers, i, n);
                answer++;
            }
        }

        return answer;
    }
    static void solve(int[][] computers, int index, int depth){
            for(int i=0;i<depth;i++){
                if(computers[index][i] == 1 && !link[index][i]){
                    link[index][i] = true;
                    link[i][index] = true;
                    solve(computers, i, depth);
                }
            }
    }

    public static void main( String[] args ) {
        int n = 3;
        int[][] computers = {{1,1,0}, {1,1,0}, {0,0,1}};
        System.out.println(solution(n, computers));
    }
}
