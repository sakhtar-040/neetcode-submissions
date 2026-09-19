class Solution {
    public static boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 > n2) return false;

        int[] need = new int[26];
        int[] window = new int[26];

        for (int i = 0; i < n1; i++) {
            need[s1.charAt(i) - 'a']++;
            window[s2.charAt(i) - 'a']++;
        }

        if (matches(need, window)) return true;

        for (int right = n1; right < n2; right++) {
            window[s2.charAt(right) - 'a']++;
            window[s2.charAt(right - n1) - 'a']--;

            if (matches(need, window)) return true;
        }

        return false;
    }

    private static boolean matches(int[] a, int[] b) {
    for (int i = 0; i < 26; i++) {
        if (a[i] != b[i]) return false;
    }
    return true;
}
}
