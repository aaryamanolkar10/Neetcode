class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        // Initialize all unique characters
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                graph.putIfAbsent(ch, new HashSet<>());
                indegree.putIfAbsent(ch, 0);
            }
        }

        // Build graph by comparing adjacent words
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            int len = Math.min(w1.length(), w2.length());
            int j = 0;

            while (j < len && w1.charAt(j) == w2.charAt(j)) {
                j++;
            }

            // Invalid prefix case
            if (j == len) {
                if (w1.length() > w2.length()) {
                    return "";
                }
                continue;
            }

            char from = w1.charAt(j);
            char to = w2.charAt(j);

            if (graph.get(from).add(to)) {
                indegree.put(to, indegree.get(to) + 1);
            }
        }

        // Topological sort using BFS
        Queue<Character> queue = new LinkedList<>();

        for (char ch : indegree.keySet()) {
            if (indegree.get(ch) == 0) {
                queue.offer(ch);
            }
        }

        StringBuilder order = new StringBuilder();

        while (!queue.isEmpty()) {
            char ch = queue.poll();
            order.append(ch);

            for (char next : graph.get(ch)) {
                indegree.put(next, indegree.get(next) - 1);

                if (indegree.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }

        // Cycle detection
        return order.length() == indegree.size()
                ? order.toString()
                : "";
    }
}