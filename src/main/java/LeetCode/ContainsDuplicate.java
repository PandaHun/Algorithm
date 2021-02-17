package LeetCode;

import java.util.HashSet;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        HashSet<Integer> hs = new HashSet<>();
        for (int number : nums) {
            if (!hs.add(number)) {
                return true;
            }
        }
        return false;
    }
}
