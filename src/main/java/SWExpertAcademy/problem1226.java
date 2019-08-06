package SWExpertAcademy;
import java.util.*;
import java.io.*;
public class problem1226 {

    public static void main(String[] args) throws IOException, NumberFormatException{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int[] dx = {0 ,0 , -1, 1};
        int[] dy = {1, -1, 0 , 0};
        for(int tc=1;tc<=10;tc++){
            boolean answer = false;
            int[][] map = new int[16][16];
            int targetX = 0;
            int targetY = 0;

            Queue<Integer> qx = new LinkedList<>();
            Queue<Integer> qy = new LinkedList<>();

            br.readLine();

            for(int i=0;i<16;i++){
                String temp =  br.readLine();
                for(int j=0;j<16;j++){
                    map[i][j] = temp.charAt(j) - '0';
                    if( map[i][j] ==2){
                        qx.add(j);
                        qy.add(i);
                    }

                    if( map[i][j]==3){
                        targetX = j;
                        targetY = i;
                    }
                }
            }
            while(!qx.isEmpty()) {
                int x = qx.poll();
                int y = qy.poll();

                for(int i=0;i<4;i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if( nx >=0 && ny >=0 && nx<16 && ny<16){

                        if(map[ny][nx] == 3)
                            answer =true;

                        if(map[ny][nx] == 0){
                            qx.add(nx);
                            qy.add(ny);
                            map[ny][nx]= 2;
                        }
                    }

                }
            }

            System.out.println("#" +tc + " " + (answer ? '1': '0'));
        }
    }
}
