class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ok = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            ok[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            ok[ransomNote.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (ok[i] < 0) return false;
        }

        return true;
    }
}