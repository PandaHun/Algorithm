package Programmers;

public class Kakao_2018_SecretMap {

    public static void main(String[] args) {
        String[] answer = solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28});
        for (String t : answer) {
            System.out.println(t);
        }
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr1[i] | arr2[i];
            System.out.println(arr1[i]);
        }
        for (int i = 0; i < n; i++) {
            String t = "";
            for (int j = 0; j < n; j++) {
                if ((arr1[i] & (1 << j)) == (1 << j)) {
                    t = "#" + t;
                } else {
                    t = " " + t;
                }
            }
            answer[i] = t;
        }
        return answer;
    }
}
