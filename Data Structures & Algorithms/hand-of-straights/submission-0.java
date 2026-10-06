class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if (hand.length % groupSize != 0) {
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Store frequency of each card
        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        while (!map.isEmpty()) {

            // Smallest card must start the next group
            int first = map.firstKey();

            // Try to create a consecutive group
            for (int i = 0; i < groupSize; i++) {

                int card = first + i;

                if (!map.containsKey(card)) {
                    return false;
                }

                // Decrease frequency
                map.put(card, map.get(card) - 1);

                // Remove when frequency becomes 0
                if (map.get(card) == 0) {
                    map.remove(card);
                }
            }
        }

        return true;
    }
}