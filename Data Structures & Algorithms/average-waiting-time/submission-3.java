class Solution {
    public double averageWaitingTime(int[][] customers) {
        long finishTime = 0;
    long totalWaitingTime = 0;

    for (int[] customer : customers) {
        int arrival = customer[0];
        int duration = customer[1];

        finishTime = Math.max(finishTime, arrival) + duration;
        totalWaitingTime += finishTime - arrival;
    }

    return (double) totalWaitingTime / customers.length;
    }
}