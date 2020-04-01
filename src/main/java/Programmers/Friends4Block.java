package Programmers;

public class Friends4Block {

    public static void main(String[] args) {
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        System.out.println(solution(4, 5, board));
    }

    static char[][] map;
    static boolean[][] isBlock;
    static int[] dr = {0, 1, 1};
    static int[] dc = {1, 0, 1};

    static int solution(int m, int n, String[] board) {
        int answer = 0;
        map = new char[m][n];
        isBlock = new boolean[m][n];
        for (int i = 0; i < board.length; i++) {
            map[i] = board[i].toCharArray();
        }
        boolean isEnd = false;
        while (!isEnd) {
            isEnd = true;
            isBlock = new boolean[m][n];
            for (int r = 0; r < m - 1; r++) {
                for (int c = 0; c < n - 1; c++) {
                    char now = map[r][c];
                    if (now == ' ') {
                        continue;
                    }
                    boolean ableToCrash = true;
                    for (int k = 0; k < 3; k++) {
                        if (map[r + dr[k]][c + dc[k]] != now) {
                            ableToCrash = false;
                            break;
                        }
                    }
                    if (ableToCrash) {
                        isBlock[r][c] = true;
                        isEnd = false;
                        for (int k = 0; k < 3; k++) {
                            isBlock[r + dr[k]][c + dc[k]] = true;
                        }
                    }
                }
            }
            for(int r = 0 ; r<m ;r ++) {
                for(int c = 0 ; c < n ; c++) {
                    System.out.print(map[r][c]);
                }
                System.out.println();
            }
            System.out.println();
            answer += crash();
            moveBlock();
        }
        return answer;
    }

    static void moveBlock() {
        for (int r = map.length - 1; r > 0; r--) {
            for (int c = 0; c < map[0].length; c++) {
                if (map[r][c] == ' ' ) {
                    int target = r-1;
                    boolean flag = false;
                    while( target >= 0) {
                        if( map[target][c] != ' ') {
                            flag = true;
                            break;
                        }
                        target--;
                    }
                    if(flag) {
                        map[r][c] = map[target][c];
                        map[target][c] = ' ';
                    }
                }
            }
        }
    }

    static int crash() {
        int ret = 0;
        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[0].length; c++) {
                if (isBlock[r][c]) {
                    map[r][c] = ' ';
                    ret++;
                }
            }
        }
        return ret;
    }
}