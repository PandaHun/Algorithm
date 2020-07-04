package Programmers;

import java.util.*;

public class Kakao_2020_GemShopping {

    static HashSet<String> gemList = new HashSet<>();
    static HashMap<String, Integer> map = new HashMap<>();
    static Queue<String> queue = new LinkedList<>();

    public static int[] solution(String[] gems) {
        Collections.addAll(gemList, gems);
        int start = 0;
        int left = 0;
        int length = Integer.MAX_VALUE;
        for (int i = 0; i < gems.length; i++) {
            if (!map.containsKey(gems[i])) {
                map.put(gems[i], 1);
            } else {
                map.put(gems[i], map.get(gems[i]) + 1);
            }
            queue.add(gems[i]);
            while (true) {
                String gem = queue.peek();
                if (map.get(gem) > 1) {
                    map.put(gem, map.get(gem) - 1);
                    queue.poll();
                    start++;
                } else {
                    break;
                }
            }
            if (map.size() == gemList.size() && length > queue.size()) {
                length = queue.size();
                left = start;
            }
        }
        return new int[]{left + 1, left + length};
    }

    static int[] binary(String[] gems, List<String> gemList) {
        int size = gemList.size();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < gems.length; i++) {
            if (map.size() < size) {
                if (map.containsKey(gems[i])) {
                    map.remove(gems[i]);
                    map.put(gems[i], i + 1);
                }
                map.put(gems[i], i + 1);
            } else if (map.size() == size) {
                break;
            }
        }
        int min = Collections.min(map.values());
        int max = Collections.max(map.values());
        return new int[]{min, max};
    }
}
