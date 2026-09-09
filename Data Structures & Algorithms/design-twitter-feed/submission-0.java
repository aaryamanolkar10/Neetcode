class Twitter {

    // user -> people they follow
    HashMap<Integer, Set<Integer>> following;

    // user -> list of their tweets
    HashMap<Integer, List<Tweet>> tweets;

    int time;

    class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    public Twitter() {
        following = new HashMap<>();
        tweets = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {

        tweets.putIfAbsent(userId, new ArrayList<>());

        tweets.get(userId).add(new Tweet(tweetId, time++));

        // Make sure user exists in following map
        following.putIfAbsent(userId, new HashSet<>());
    }

    public List<Integer> getNewsFeed(int userId) {

        List<Integer> result = new ArrayList<>();

        // Max heap based on tweet time
        PriorityQueue<TweetInfo> pq = new PriorityQueue<>(
            (a, b) -> b.tweet.time - a.tweet.time
        );

        // Add user's own tweets
        if (tweets.containsKey(userId)) {
            List<Tweet> list = tweets.get(userId);

            int index = list.size() - 1;

            pq.offer(new TweetInfo(userId, index, list.get(index)));
        }

        // Add tweets of people user follows
        if (following.containsKey(userId)) {

            for (int followee : following.get(userId)) {

                if (tweets.containsKey(followee)) {

                    List<Tweet> list = tweets.get(followee);

                    int index = list.size() - 1;

                    pq.offer(
                        new TweetInfo(followee, index, list.get(index))
                    );
                }
            }
        }

        // Get 10 most recent tweets
        while (!pq.isEmpty() && result.size() < 10) {

            TweetInfo current = pq.poll();

            result.add(current.tweet.tweetId);

            // Get the next older tweet from the same user
            if (current.index > 0) {

                int nextIndex = current.index - 1;

                List<Tweet> list = tweets.get(current.userId);

                pq.offer(
                    new TweetInfo(
                        current.userId,
                        nextIndex,
                        list.get(nextIndex)
                    )
                );
            }
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {

        following.putIfAbsent(followerId, new HashSet<>());

        following.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }


    // Stores information about a tweet currently in the heap
    class TweetInfo {

        int userId;
        int index;
        Tweet tweet;

        TweetInfo(int userId, int index, Tweet tweet) {
            this.userId = userId;
            this.index = index;
            this.tweet = tweet;
        }
    }
}