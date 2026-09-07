class Solution {
    PriorityQueue<Integer> pq;
    public int lastStoneWeight(int[] stones) {
        pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            pq.offer(stone);
        }
        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();

            if (x != y) {
                pq.offer(x - y);
            }
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}
