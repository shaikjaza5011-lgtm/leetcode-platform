class Solution {
    public boolean checkIfPangram(String sentence) {

        boolean[] letters = new boolean[26];

        for (int i = 0; i < sentence.length(); i++) {
            letters[sentence.charAt(i) - 'a'] = true;
        }

        for (int i = 0; i < 26; i++) {
            if (!letters[i]) {
                return false;
            }
        }

        return true;
    }
}
