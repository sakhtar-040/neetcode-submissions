class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int satisfied = 0;
        int maxSatisfied = 0;
        
        for(int i=0; i<customers.length; i++) {
            if(grumpy[i] == 0) {
                satisfied += customers[i];
            }
        }
        
        int additionalSatisfied = 0;
        for(int i=0; i<minutes; i++) {
            if(grumpy[i] == 1) {
                additionalSatisfied += customers[i];
            }
        }
        maxSatisfied = additionalSatisfied;
        
        for(int i=minutes; i<customers.length; i++) {
            if(grumpy[i] == 1) {
                additionalSatisfied += customers[i];
            }
            if(grumpy[i-minutes] == 1) {
                additionalSatisfied -= customers[i-minutes];
            }
            maxSatisfied = Math.max(maxSatisfied, additionalSatisfied);
        }
        
        return satisfied + maxSatisfied;
    }
}