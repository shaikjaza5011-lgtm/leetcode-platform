import java.util.HashSet;

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> set = new HashSet<>();

        // Store all jewels in the HashSet
        for (char ch : jewels.toCharArray()) {
            set.add(ch);
        }

        int count = 0;

        // Count matching stones
        for (char ch : stones.toCharArray()) {
            if (set.contains(ch)) {
                count++;
            }
        }

        return count;
    }
}
