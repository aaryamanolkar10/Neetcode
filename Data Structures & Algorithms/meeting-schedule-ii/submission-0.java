class Solution {
    public int minMeetingRooms(List<Interval> intervals) {

        if (intervals.size() == 0) {
            return 0;
        }

        // Sort meetings by start time
        intervals.sort(Comparator.comparingInt(a -> a.start));

        // Min heap → stores ending times
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (Interval meeting : intervals) {

            // If the earliest room is free
            if (!minHeap.isEmpty() &&
                minHeap.peek() <= meeting.start) {

                minHeap.poll();
            }

            // Assign current meeting to a room
            minHeap.add(meeting.end);
        }

        return minHeap.size();
    }
}