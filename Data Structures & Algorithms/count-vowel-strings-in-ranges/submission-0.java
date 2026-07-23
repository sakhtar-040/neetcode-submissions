class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        String vowels = "aeiou";
        int[] res = new int[queries.length];

        for (int i=0; i<queries.length; i++) {
            int count = 0;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                char[] word = words[j].toCharArray();
                if(vowels.contains(String.valueOf(word[0])) && vowels.contains(String.valueOf(word[word.length - 1]))) {
                    count++;
                }
            }
            res[i] = count;
        }

        return res;
    }
}