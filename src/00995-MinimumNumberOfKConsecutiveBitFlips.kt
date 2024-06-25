//995. Minimum Number of K Consecutive Bit Flips
//https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips
//
fun main() {
    println(minKBitFlips(intArrayOf(0, 1, 0), 1))
    println(minKBitFlips(intArrayOf(0, 0, 0, 1, 0, 1, 1, 0), 3))
}

fun minKBitFlips(nums: IntArray, k: Int): Int {
    // Keeps track of flipped states
    val flipped = BooleanArray(nums.size)
    // Tracks valid flips within the past window
    var validFlipsFromPastWindow = 0
    // Counts total flips needed
    var flipCount = 0

    for (i in nums.indices) {
        if (i >= k) {
            // Decrease count of valid flips from the past window if needed
            if (flipped[i - k]) {
                validFlipsFromPastWindow--
            }
        }

        // Check if current bit needs to be flipped
        if (validFlipsFromPastWindow % 2 == nums[i]) {
            // If flipping the window extends beyond the array length, return -1
            if (i + k > nums.size) {
                return -1
            }
            // Increment the count of valid flips and mark current as flipped
            validFlipsFromPastWindow++
            flipped[i] = true
            flipCount++
        }
    }

    return flipCount
}