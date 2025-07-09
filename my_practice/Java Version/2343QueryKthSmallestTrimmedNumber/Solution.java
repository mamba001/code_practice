class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int n = queries.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int[] q = queries[i];
            res[i] = process(nums.clone(), q);
        }
        return res;
    }

    private int process(String[] nums, int[] q) {
        int trim = q[1], k = q[0];
        int len = nums[0].length();
        
        PriorityQueue<Node> maxHeap = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node a, Node b) {
                if (b.val.compareTo(a.val) > 0) {
                    return 1;
                } else if (b.val.compareTo(a.val) < 0) {
                    return -1;
                } else {
                    if (a.index < b.index) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        });
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i].substring(len - trim);
            maxHeap.add(new Node(nums[i], i));
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return maxHeap.peek().index;
    }
}

class Node {
    int index;
    String val;
    public Node(String val, int index) {
        this.val = val;
        this.index = index;
    }
}