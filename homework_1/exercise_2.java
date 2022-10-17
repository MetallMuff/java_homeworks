// 27. Remove Element
class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0)
            return 0;
        int index = 0;
        for (int x : nums) {
            if (x != val) {
                nums[index] = x;
                index++;
            }
        }
        return index;
    }
}