class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;          // no carry, done
            }
            digits[i] = 0;              // was 9 → becomes 0, carry continues
        }
        // all were 9s (e.g. 999 → 1000)
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}