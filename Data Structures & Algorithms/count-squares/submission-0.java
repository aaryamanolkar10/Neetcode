class CountSquares {
    private Map<Integer, Map<Integer, Integer>> points;

    public CountSquares() {
        points = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0], y = point[1];

        points.putIfAbsent(y, new HashMap<>());
        Map<Integer, Integer> row = points.get(y);

        row.put(x, row.getOrDefault(x, 0) + 1);
    }

    public int count(int[] point) {
        int x = point[0], y = point[1];
        int ans = 0;

        if (!points.containsKey(y)) {
            return 0;
        }

        for (int col : points.get(y).keySet()) {
            if (col == x) continue;

            int side = col - x;
            int freq = points.get(y).get(col);

            // Square above
            ans += freq
                    * getCount(x, y + side)
                    * getCount(col, y + side);

            // Square below
            ans += freq
                    * getCount(x, y - side)
                    * getCount(col, y - side);
        }

        return ans;
    }

    private int getCount(int x, int y) {
        if (!points.containsKey(y)) return 0;
        return points.get(y).getOrDefault(x, 0);
    }
}