class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] base = new int[26];
    for (char c : chars.toCharArray()) base[c - 'a']++;

    int res = 0;

    for (String w : words) {
        int[] need = new int[26];
        boolean good = true;

        for (char c : w.toCharArray()) {
            int idx = c - 'a';
            need[idx]++;
            if (need[idx] > base[idx]) {
                good = false;
                break;
            }
        }

        if (good) res += w.length();
    }

    return res;
    }
}