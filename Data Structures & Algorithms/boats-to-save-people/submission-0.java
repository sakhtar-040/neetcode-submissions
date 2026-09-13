class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int count=0;
        Arrays.sort(people);

        int i=0;
        int j=people.length-1;

        while (i<=j){
            int sum = people[i]+people[j];

            if(sum > limit) {
                if(people[j] <= limit) {
                    count++;
                    j--;
                }
            } else {
                count++;
                i++;
                j--;
            }
        }

        return count;
    }
}