class Solution {
    public double averageWaitingTime(int[][] customers) {
        int arrivalTime = 0;
        int startTime = 0;
        int finishedTime = 0;
        int[] waitingTime = new int[customers.length];
        double avgWaitingTime = 0;

        for (int i = 0; i < customers.length; i++) {
            arrivalTime = customers[i][0];
            startTime = Math.max(arrivalTime, finishedTime);
            finishedTime = startTime + customers[i][1];
            waitingTime[i] = finishedTime -  arrivalTime;
        }

        for (int num : waitingTime) {
            avgWaitingTime += num;
        }

        return avgWaitingTime / waitingTime.length;
    }
}