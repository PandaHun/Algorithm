package Baekjoon;

/*
 *  @Author: Pandahun
 *  @Content: 낚시왕
 */
import java.io.*;
import java.util.*;

public class problem17143 {

    private static int R, C, N;
    private static Shark[][] map;
    private static List<Shark> sharkList;
    private static int answer;

    public static void main( String[] args ) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        answer = 0;
        map = new Shark[R + 1][C + 1];
        sharkList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            Shark shark = new Shark(size, r, c, speed, d);
            sharkList.add(shark);
            map[r][c] = shark;
        }

/*
        for(int i = 1 ; i<=R;i++){
            for(int k = 1 ; k<=C;k++)
                System.out.print(map[i][k] +" ");
            System.out.println();
        }*/

        for (int idx = 1; idx <= C; idx++) {
            kill(idx);
            survive();
        }
        System.out.println(answer);

    }

    static void kill( int idx ) {
        for (int r = 1; r <= R; r++) {
            if (map[r][idx] != null) {
                Shark killedShark = map[r][idx];
                answer += map[r][idx].size;
                sharkList.remove(killedShark);
                map[r][idx] = null;
                break;
            }
        }
    }

    static void survive() {
        map = new Shark[R + 1][C + 1];
        for (Shark shark : sharkList) {
            shark.move(R, C);
        }

        for (int i = sharkList.size() - 1; i >= 0; i--) {

            Shark sharks = sharkList.get(i);
            if (map[sharks.row][sharks.column] == null) {
                map[sharks.row][sharks.column] = sharks;
            } else {
                if (map[sharks.row][sharks.column].size > sharks.size) {
                    sharkList.remove(sharks);
                } else {
                    sharkList.remove(map[sharks.row][sharks.column]);
                    map[sharks.row][sharks.column] = sharks;
                }
            }
        }

    }
}

class Shark {
    int row;
    int column;
    int speed;
    int direction;
    int size;

    public Shark( int size, int row, int column, int speed, int direction ) {
        this.row = row;
        this.column = column;
        this.speed = speed;
        this.direction = direction;
        this.size = size;
    }

    public void move( int R, int C ) {
        int[] dc = {0, 0, 1, -1};
        int[] dr = {-1, 1, 0, 0};

        int end = C;
        if (this.direction < 3) {
            end = R;
        }

        int changed = 2 * (end - 1);
        int speed = this.speed % changed;

        for (int i = 0; i < speed; i++) {
            if (this.direction < 3) {
                // 위, 아래
                if ((this.row == end && this.direction == 2) || (this.row == 1 && this.direction == 1)) {
                    this.changeDirection();
                }
                this.row += dr[this.direction - 1];
            } else {
                if ((this.column == end && this.direction == 3) || (this.column == 1 && this.direction == 4)) {
                    this.changeDirection();
                }
                this.column += dc[this.direction - 1];
            }
        }
    }

    public void changeDirection() {
        int next = this.direction + 1;
        if (next % 2 == 0) {
            this.direction = next;
        } else {
            this.direction = next - 2;
        }
    }
}
