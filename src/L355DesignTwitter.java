import java.util.*;

public class L355DesignTwitter {
    public class Twitter {
        private Map<Integer, Set<Integer>> users;
        private Map<Integer, Map<Integer, Integer>> tweets;
        private int timeStamp;

        /**
         * Initialize your data structure here.
         */
        public Twitter() {
            users = new HashMap<>();
            tweets = new HashMap<>();
            timeStamp = 0;
        }

        /**
         * Compose a new tweet.
         */
        public void postTweet(int userId, int tweetId) {
            if (users.get(userId) == null) {
                users.put(userId, new HashSet<>());
                tweets.put(userId, new HashMap<>());
            }
            tweets.get(userId).put(timeStamp++, tweetId);
        }

        /**
         * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
         */
        public List<Integer> getNewsFeed(int userId) {
            List<Integer> res = new ArrayList<>();
            if (users.get(userId) == null) {
                return res;
            }
            Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((e1, e2) -> e2.getKey() - e1.getKey());
            for (Map.Entry<Integer, Integer> e : tweets.get(userId).entrySet()) {
                queue.offer(e);
            }
            for (Integer user : users.get(userId)) {
                for (Map.Entry<Integer, Integer> e : tweets.get(user).entrySet()) {
                    queue.offer(e);
                }
            }
            for (int i = 0; i < 10 && !queue.isEmpty(); i++) {
                res.add(queue.poll().getValue());
            }
            return res;
        }

        /**
         * Follower follows a followee. If the operation is invalid, it should be a no-op.
         */
        public void follow(int followerId, int followeeId) {
            if (followerId == followeeId) {
                return;
            }
            if (users.get(followerId) == null) {
                users.put(followerId, new HashSet<>());
                tweets.put(followerId, new HashMap<>());
            }
            if (users.get(followeeId) == null) {
                users.put(followeeId, new HashSet<>());
                tweets.put(followeeId, new HashMap<>());
            }
            users.get(followerId).add(followeeId);
        }

        /**
         * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
         */
        public void unfollow(int followerId, int followeeId) {
            if (followerId == followeeId) {
                return;
            }
            if (users.get(followerId) == null || users.get(followeeId) == null) {
                return;
            }
            users.get(followerId).remove(followeeId);
        }
    }

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
}
