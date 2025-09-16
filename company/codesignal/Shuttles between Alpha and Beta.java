
class Solution {
    // For alpha2beta = [0, 200, 500], beta2alpha = [99, 210, 450]
    // and missions = 1, the output should be 310
    public int getTime(int[] alpha2beta, int[] beta2alpha, int missions) {
        int curr = 0, times = 0, i = 0, j = 0;
        while(times < missions) {
            // a -> b
            while(curr > alpha2beta[i]) {
                i++;
            }
            curr = alpha2beta[i]+100; // 到达b

            // b -> a
            while(curr > beta2alpha[j]) {
                j++;
            }
            curr = beta2alpha[j]+100; // 到达a
            
            times++;
        }
        return curr;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.getTime(new int[]{0, 200, 500}, new int[]{99, 210, 450}, 1)); // 310
        System.out.println(sol.getTime(new int[]{109,200,500}, new int[]{99,210,600}, 2)); // 700
    }
}
