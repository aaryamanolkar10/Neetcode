class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {

        if (intervals.size() == 0) {
            return true;
        }

        // Sort by start time
        intervals.sort(Comparator.comparingInt(a -> a.start));

        // Check consecutive meetings
        for (int i = 1; i < intervals.size(); i++) {

            Interval previous = intervals.get(i - 1);
            Interval current = intervals.get(i);

            // Overlap
            if (previous.end > current.start) {
                return false;
            }
        }

        return true;
    }
}