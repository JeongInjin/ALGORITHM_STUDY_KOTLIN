package leetcode

/**
 * 1. Two Sum
 * https://leetcode.com/problems/two-sum/
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
class Solution01 {

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        nums.forEachIndexed { i, num ->
            val diff = target - num
            map[diff]?.let { return intArrayOf(it, i) }
            map[num] = i
        }
        return intArrayOf()
    }

    fun twoSum0(nums: IntArray, target: Int): IntArray {
        nums.forEachIndexed { i, num ->
            for (j in i + 1 until nums.size) {
                if (num + nums[j] == target) return intArrayOf(i, j)
            }
        }
        return intArrayOf()
    }

    fun twoSum1(nums: IntArray, target: Int): IntArray {
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                if (nums[i] + nums[j] == target) {
                    return intArrayOf(i, j)
                }
            }
        }
        return intArrayOf()
    }

    fun twoSum2(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()

        for (i in nums.indices) {
            val complement = target - nums[i]
            if (map.containsKey(complement)) {
                return intArrayOf(map[complement]!!, i)
            }
            map[nums[i]] = i
        }

        return intArrayOf()
    }

    fun twosum3(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        nums.forEachIndexed { i, num ->
            val diff = target - num
            if (map.getOrDefault(diff, -1) != -1) {
                return intArrayOf(map[diff]!!, i)
            }
            map[num] = i
        }
        return intArrayOf()
    }
}

fun main() {
    val solution = Solution01()
//    val nums = intArrayOf(2, 7, 11, 15)
//    val target = 9

    val nums = intArrayOf(3, 2, 4)
    val target = 6
    val result = solution.twoSum(nums, target)
    println("Result: [${result[0]}, ${result[1]}]")
    println("Target: $target,  Sum: ${nums[result[0]] + nums[result[1]]}")
}
