class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {

        // Sort intervals by start
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Store queries along with their original index
        int[][] q = new int[queries.length][2];

        for (int i = 0; i < queries.length; i++) {
            q[i][0] = queries[i]; // query value
            q[i][1] = i;          // original index
        }

        // Sort queries by value
        Arrays.sort(q, (a, b) -> a[0] - b[0]);

        // Min heap: [interval size, interval end]
        PriorityQueue<int[]> minHeap =
            new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int[] result = new int[queries.length];

        Arrays.fill(result, -1);

        int i = 0;

        for (int[] query : q) {

            int x = query[0];

            // Add all intervals whose start <= query
            while (i < intervals.length &&
                   intervals[i][0] <= x) {

                int start = intervals[i][0];
                int end = intervals[i][1];

                int length = end - start + 1;

                minHeap.offer(new int[]{length, end});

                i++;
            }

            // Remove intervals that cannot contain query
            while (!minHeap.isEmpty() &&
                   minHeap.peek()[1] < x) {

                minHeap.poll();
            }

            // Smallest valid interval
            if (!minHeap.isEmpty()) {
                result[query[1]] = minHeap.peek()[0];
            }
        }

        return result;
    }
}