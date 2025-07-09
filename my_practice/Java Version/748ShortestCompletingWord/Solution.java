class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : licensePlate.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                map.put(c, map.getOrDefault(c, 0) + 1);
            } else if (c >= 'A' && c <= 'Z') {
                c = Character.toLowerCase(c);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }

        String res = "";
        for (String word : words) {
            if (meet(word, map)) {
                if (res.equals("") || word.length() < res.length()) {
                    res = word;
                }
            }
        }
        return res;
    }

    private boolean meet(String word, Map<Character, Integer> map) {
        int[] count = new int[26];
        for (char c : word.toCharArray()) {
            count[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] < map.getOrDefault((char) (i + 'a'), 0)) {
                System.out.println("i: " + i + ", count[i]: " + count[i]);
                return false;
            }
        }
        return true;
    }
}