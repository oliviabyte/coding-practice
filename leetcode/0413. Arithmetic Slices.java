class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
    // nums = [1,2,3] res = 1
    // nums = [1,2,3,4] res = 1+2 =3
    // nums = [1,2,3,4,5] res = 3+3 = 6
    // nums = [1,2,3,4,5,6] res = 3+3+4 = 10
    // nums = [1,2,3,4,5,6,7] res = 3+3+4+5 = 15

        // if nums[right] == nums[left] right++
        // if nums[right] != nums[left] {count += right - left
        //          left = right;}

        // edge case
        int n = nums.length;
        if(n <= 3) return 0;

        // init
        int left = 0, count = 0;

        // traverse
        for(int right = 0; right <= nums.length; right++) {
            int len = right - left;
            if(right == nums.length || nums[right-1] - nums[right-2] != nums[right] - nums[right-1]) {
                count += (len - 1) * (len - 2)/2;
                left = right;
            }
        }
        return count;
    }
}