class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (valueDiff < 0) {
            return false;
        }

        //key is buket ID, and value is the element of that buket
        Map<Long, Long> buckets = new HashMap<>();

        //every buket is length valueDiff + 1
        long w = (long) valueDiff + 1;

        for (int i = 0; i < nums.length; i++) {
            long num = (long) nums[i];
            long bucketId = getBucketId(num, w);

            //case1, when current buket not empty, then current number in bucket and our num in this loop are meeting the requirements of duplicate
            if (buckets.containsKey(bucketId)) {
                return true;
            }

            //case2. check num and left bucket
            if (buckets.containsKey(bucketId - 1) && Math.abs(num - buckets.get(bucketId - 1)) < w) {
                return true;
            }

            //case3. check num and right bucket
            if (buckets.containsKey(bucketId + 1) && Math.abs(num - buckets.get(bucketId + 1)) < w) {
                return true;
            }

            //if above three cases not meet
            buckets.put(bucketId, num);

            if (i >= indexDiff) {
                long oldNum = (long) nums[i - indexDiff];
                long oldBucketId = getBucketId(oldNum, w);
                buckets.remove(oldBucketId);
            }
        }
        return false;
    }

    private long getBucketId(long num, long w) {
        return num < 0 ? (num + 1) / w - 1 : num / w;
    }
}