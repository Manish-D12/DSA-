class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);              // sort so duplicates sit next to each other
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int remain, int start,
                           List<Integer> current, List<List<Integer>> result) {
        if (remain == 0) {                    // found a valid combination
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // skip duplicates at the same tree level
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            // candidates sorted: once we overshoot, all later ones overshoot too
            if (candidates[i] > remain) break;

            current.add(candidates[i]);
            // i + 1, not i, because each number is used at most once
            backtrack(candidates, remain - candidates[i], i + 1, current, result);
            current.remove(current.size() - 1);   // undo the choice
        }
    }
}