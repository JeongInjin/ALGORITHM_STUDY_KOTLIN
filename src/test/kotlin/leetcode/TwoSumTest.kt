package leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class TwoSumTest {
    
    @Test
    fun `test two sum with example 1`() {
        val solution = TwoSum()
        val nums = intArrayOf(2, 7, 11, 15)
        val target = 9
        val expected = intArrayOf(0, 1)
        val result = solution.twoSum(nums, target)
        assertContentEquals(expected, result)
    }
    
    @Test
    fun `test two sum with example 2`() {
        val solution = TwoSum()
        val nums = intArrayOf(3, 2, 4)
        val target = 6
        val expected = intArrayOf(1, 2)
        val result = solution.twoSum(nums, target)
        assertContentEquals(expected, result)
    }
    
    @Test
    fun `test two sum with example 3`() {
        val solution = TwoSum()
        val nums = intArrayOf(3, 3)
        val target = 6
        val expected = intArrayOf(0, 1)
        val result = solution.twoSum(nums, target)
        assertContentEquals(expected, result)
    }
}
