import java.util.*;
class RandomizedCollection {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    Random rand = new Random();

    public RandomizedCollection() {}

    public boolean insert(int val) {
        boolean absent = !map.containsKey(val) || map.get(val).isEmpty();
        map.computeIfAbsent(val, k -> new LinkedHashSet<>()).add(list.size());
        list.add(val);
        return absent;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).isEmpty()) return false;
        int removeIdx = map.get(val).iterator().next();
        map.get(val).remove(removeIdx);
        int last = list.get(list.size() - 1);
        if (removeIdx != list.size() - 1) {
            list.set(removeIdx, last);
            map.get(last).remove(list.size() - 1);
            map.get(last).add(removeIdx);
        }
        list.remove(list.size() - 1);
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}