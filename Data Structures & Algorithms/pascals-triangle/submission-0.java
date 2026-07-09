class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            result.add(new ArrayList<>(Collections.nCopies(i, 1)));
        }

        for(int i = 2; i < result.size(); i++) {
            List<Integer> prev = result.get(i-1);
            List<Integer> curr = result.get(i);
            for(int j=1; j<curr.size()-1; j++) {
                curr.set(j, prev.get(j-1) + prev.get(j));
            }
        }

        return  result;
    }
}