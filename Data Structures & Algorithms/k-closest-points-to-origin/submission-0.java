class Solution {
    // initialize max heap
    PriorityQueue<int[]> maxHeap;
    public int[][] kClosest(int[][] points, int k) {
        // add elements in order of distance
        maxHeap = new PriorityQueue<>((a, b) -> dist(b) - dist(a));

        for (int[] point : points) {
            // add points
            maxHeap.add(point);

            // if size exceeds k pop max element
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int res[][] = new int[k][2];
        int i = 0;

        // pushing all elements of  pq to res
        while (!maxHeap.isEmpty()) {
            res[i++] = maxHeap.poll();
        }
        return res;
    }

    // method to calculate distance
    private int dist(int[] points) {
        int x = points[0];
        int y = points[1];
        return x * x + y * y;
    }
}
