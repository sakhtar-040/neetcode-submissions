class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ok = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            ok[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            int idx = ransomNote.charAt(i) - 'a';
            if (--ok[idx] < 0) return false;
        }

        return true;
    }
}