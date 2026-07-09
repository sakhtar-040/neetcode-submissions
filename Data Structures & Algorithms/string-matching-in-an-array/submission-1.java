class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();

        Arrays.sort(words);

        int i=0;
        int j=0;

        while(i<words.length && j<words.length) {
            if(words[j].contains(words[i]) && i != j) {
                result.add(words[i]);
                i++;
                j=0;
            } else {
                j++;
                if(j == words.length) {
                    i++;
                    j=0;
                }
            }
        }

        return result;
    }
}