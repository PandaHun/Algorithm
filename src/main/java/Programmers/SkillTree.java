package Programmers;

public class SkillTree {

    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB" ,"BDA"};
        System.out.println(solution(skill, skill_trees));
    }

                public static int solution(String skill, String[] skill_trees) {
                    int answer = skill_trees.length;
                    int length = skill.length();
                    int before = 0;
                    int current = 0;
                    for(int k = 0 ; k < skill_trees.length ; k++) {
                        String now = skill_trees[k];
                        before = now.indexOf(skill.charAt(0));
                        for (int i = 1; i < length; i++) {
                            current  = now.indexOf(skill.charAt(i));
                            if((before > current && current != -1) || (before == -1 && current != -1)) {
                                answer--;
                                break;
                            }
                            before = current;
            }
        }
        return answer;
    }
}
