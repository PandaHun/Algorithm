package Programmers;

import java.util.LinkedList;
import java.util.List;

public class Kakao_2018_Cache {

    static final int MISS = 5;
    static final int HIT = 1;

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if (cacheSize == 0) {
            return cities.length * MISS;
        }
        List<String> cache = new LinkedList<>();
        for (String cityTemp : cities) {
            String city = cityTemp.toLowerCase();
            if (cache.contains(city)) {
                cache.remove(city);
                cache.add(city);
                answer += HIT;
            } else if (cache.size() < cacheSize) {
                cache.add(city);
                answer += MISS;
            } else {
                if (cacheSize > 0) {
                    cache.remove(0);
                    cache.add(city);
                }
                answer += MISS;
            }
        }
        return answer;
    }
}
