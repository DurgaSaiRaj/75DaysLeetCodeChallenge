import java.util.*;
class Twitter {
    private int time = 0;
    private Map<Integer, List<int[]>> tweets = new HashMap<>();
    private Map<Integer, Set<Integer>> following = new HashMap<>();

    public Twitter() {}

    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{time++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        Set<Integer> users = new HashSet<>(following.getOrDefault(userId, new HashSet<>()));
        users.add(userId);
        for (int u : users) {
            List<int[]> t = tweets.getOrDefault(u, new ArrayList<>());
            for (int[] tw : t) pq.offer(tw);
        }
        List<Integer> res = new ArrayList<>();
        int cnt = 0;
        while (!pq.isEmpty() && cnt < 10) {
            res.add(pq.poll()[1]);
            cnt++;
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        following.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        following.getOrDefault(followerId, new HashSet<>()).remove(followeeId);
    }
}