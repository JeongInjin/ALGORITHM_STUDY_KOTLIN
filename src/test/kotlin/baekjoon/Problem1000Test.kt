package baekjoon

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Problem1000Test {
    
    @Test
    fun `test A plus B with example 1`() {
        val input = "1 2"
        val expected = 3
        val result = solve1000(input)
        assertEquals(expected, result)
    }
    
    @Test
    fun `test A plus B with example 2`() {
        val input = "5 7"
        val expected = 12
        val result = solve1000(input)
        assertEquals(expected, result)
    }
    
    @Test
    fun `test A plus B with negative numbers`() {
        val input = "-1 1"
        val expected = 0
        val result = solve1000(input)
        assertEquals(expected, result)
    }
}
