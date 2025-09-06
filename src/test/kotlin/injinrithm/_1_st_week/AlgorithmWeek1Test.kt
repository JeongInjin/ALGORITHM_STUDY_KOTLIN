package injinrithm._1_st_week

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Algorithm1Week1Test {

    @Test
    fun `최빈값 알파벳 찾기 테스트`() {
        val solution = _01_02_find_max_occurred_alphabet()

        assertThat(solution.result("hello my name is dingcodingco")).isEqualTo('i')
        assertThat(solution.result("ab")).isEqualTo('a')
        assertThat(solution.result("baba")).isEqualTo('a')
        assertThat(solution.result("we love algorithm")).isEqualTo('e')
        assertThat(solution.result("best of best youtube")).isEqualTo('b')
    }

    @Test
    fun `더하기 곱하기 최대값 테스트`() {
        val solution = _01_04_find_max_plus_or_multiply()

        assertThat(solution.result(arrayOf(0, 3, 5, 6, 1, 2, 4))).isEqualTo(728)
        assertThat(solution.result(arrayOf(3, 2, 1, 5, 9, 7, 4))).isEqualTo(8820)
        assertThat(solution.result(arrayOf(1, 1, 1, 3, 3, 2, 5))).isEqualTo(270)
    }

    @Test
    fun `반복되지 않는 첫 문자 테스트`() {
        val solution = _01_05_find_not_repeating_first_character()

        assertThat(solution.result("abadabac")).isEqualTo('d')
        assertThat(solution.result("aabbcddd")).isEqualTo('c')
        assertThat(solution.result("aaaaaaaa")).isEqualTo('_')
    }

    @Test
    fun `소수 찾기 테스트`() {
        val solution = _01_06_find_prime_list_under_number()

        assertThat(solution.result(20)).containsExactly(2, 3, 5, 7, 11, 13, 17, 19)
        assertThat(solution.result(1)).isEmpty()
        assertThat(solution.result(2)).containsExactly(2)
    }

    @Test
    fun `0과 1 뒤집기 테스트`() {
        val solution = _01_07_find_count_to_turn_out_to_all_zero_or_all_one()

        // 기본 테스트
        assertThat(solution.result("0001100")).isEqualTo(1)
        assertThat(solution.result("1111")).isEqualTo(0)
        assertThat(solution.result("00000001")).isEqualTo(1)
        assertThat(solution.result("11001100110011000001")).isEqualTo(4)
        assertThat(solution.result("11101101")).isEqualTo(2)

        // 최적화 버전들 테스트
        assertThat(solution.result2("0001100")).isEqualTo(1)
        assertThat(solution.result2("1111")).isEqualTo(0)
        assertThat(solution.result2("00000001")).isEqualTo(1)
        assertThat(solution.result2("11001100110011000001")).isEqualTo(4)
        assertThat(solution.result2("11101101")).isEqualTo(2)

        assertThat(solution.result3("0001100")).isEqualTo(1)
        assertThat(solution.result3("1111")).isEqualTo(0)
        assertThat(solution.result3("00000001")).isEqualTo(1)
        assertThat(solution.result3("11001100110011000001")).isEqualTo(4)
        assertThat(solution.result3("11101101")).isEqualTo(2)
    }

    @Test
    fun `0과 1 뒤집기 최적화 버전 비교 테스트`() {
        val solution = _01_07_find_count_to_turn_out_to_all_zero_or_all_one()
        val testCases = listOf(
            "0001100",
            "1111",
            "00000001",
            "11001100110011000001",
            "11101101",
            "0",
            "1",
            "01",
            "10",
            "0101010101"
        )

        testCases.forEach { testCase ->
            val result1 = solution.result(testCase)
            val result2 = solution.result2(testCase)
            val result3 = solution.result3(testCase)

            assertThat(result2).isEqualTo(result1)
            assertThat(result3).isEqualTo(result1)
        }
    }
}
