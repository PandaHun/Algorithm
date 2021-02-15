package LeetCode;


class RemoveDuplicatesfromSortedArray {

    public int removeDuplicates(int[] nums) {
        int index = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i+1]) {
                nums[index++] = nums[i+1];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicatesfromSortedArray().removeDuplicates(new int[]{1, 1, 2}));
    }
}