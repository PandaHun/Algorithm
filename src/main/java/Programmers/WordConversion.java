package Programmers;

public class WordConversion {

    static boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length + 1];
        for(String word: words) {
            if (word.equals(target)) {
                return solve(words, begin, target);
            }
        }

        return 0;
    }

    static int solve(String[]words, String begin, String target){
        int answer = 0;
        String before;
        for(int i = 0; i<words.length; i++){

            if(visited[i])
                continue;
            for(int j=0;j<begin.length(); j++){
                before = begin;
                before = (j > 0 ? begin.substring(0, j) : "") + words[i].charAt(j) + (j < begin.length()-1 ? begin.substring(j+1) : "");

                if(before.equals(target))
                    return 1;

                if(before.equals(words[i])){
                    visited[i] = true;
                    answer = 1;
                    answer += solve(words, before, target);
                }
            }
        }
        return answer;
    }

    public static void main( String[] args ) {
        WordConversion wordConversion = new WordConversion();
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(wordConversion.solution("hit", "cog", words));
    }
}
