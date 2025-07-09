class Solution {
    public boolean isItPossible(String word1, String word2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (char c : word1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for (char c : word2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        int size1 = map1.size(), size2 = map2.size();
        for (char c1 = 'a'; c1 <= 'z'; c1++) {
            for (char c2 = 'a'; c2 <= 'z'; c2++) {
                if (map1.getOrDefault(c1, 0) > 0 && map2.getOrDefault(c2, 0) > 0) {
                    if (c1 == c2) {
                        if (size1 == size2) {
                            return true;
                        }
                    } else {
                        int count1 = size1, count2 = size2;
                        if (map1.get(c1) == 1) {
                            count1--;
                        }
                        if (!map1.containsKey(c2)) {
                            count1++;
                        }
                        if (map2.get(c2) == 1) {
                            count2--;
                        }
                        if (!map2.containsKey(c1)) {
                            count2++;
                        }
                        if (count1 == count2) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
