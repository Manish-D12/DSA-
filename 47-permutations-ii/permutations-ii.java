class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> counter = new HashMap<>();
        for (int n : nums) counter.merge(n, 1, Integer::sum);
        backtrack(new ArrayList<>(), nums.length, counter, res);
        return res;
    }

    private void backtrack(List<Integer> cur, int n, Map<Integer, Integer> counter, List<List<Integer>> res) {
        if (cur.size() == n) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (Map.Entry<Integer, Integer> e : counter.entrySet()) {
            int count = e.getValue();
            if (count == 0) continue;
            int num = e.getKey();
            cur.add(num);
            e.setValue(count - 1);
            backtrack(cur, n, counter, res);
            cur.remove(cur.size() - 1);
            e.setValue(count);
        }
    }
}