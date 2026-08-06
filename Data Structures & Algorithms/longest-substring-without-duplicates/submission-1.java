class Solution {
    public int lengthOfLongestSubstring(String s) {
        // initialize variables and data types
        int n = s.length();
        HashSet<Character> seen = new HashSet<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < n; right++) {
            while (seen.contains(s.charAt(right))) {
                // already visited
                seen.remove(s.charAt(left));
                left++;
            }
            seen.add(s.charAt(right)); // if not visited
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
