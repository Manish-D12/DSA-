class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] need = new int[128];
        for (char c : t.toCharArray()) need[c]++;
        int required = t.length();   // total chars still needed (with dupes)

        int left = 0, minLen = Integer.MAX_VALUE, minStart = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (need[c] > 0) required--;   // this char helped cover t
            need[c]--;

            while (required == 0) {         // window covers all of t
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }
                char lc = s.charAt(left);
                need[lc]++;
                if (need[lc] > 0) required++;  // removing lc breaks coverage
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}