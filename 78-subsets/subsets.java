class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int start, int[] nums, List<Integer> cur, List<List<Integer>> res) {
        res.add(new ArrayList<>(cur));   
        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            backtrack(i + 1, nums, cur, res);  
            cur.remove(cur.size() - 1);       
        }
    }
}