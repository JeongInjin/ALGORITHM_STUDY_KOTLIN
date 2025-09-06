package injinrithm._1_st_week

import kotlin.math.min

/**
 * Q.
 * 0과 1로만 이루어진 문자열이 주어졌을 때, 이 문자열에 있는 모든 숫자를 전부 같게 만들려고 한다.
 * 할 수 있는 행동은 문자열에서 연속된 하나 이상의 숫자를 잡고 모두 뒤집는 것이다. 뒤집는 것은 1을 0으로, 0을 1로 바꾸는 것을 의미한다.
 *
 * 예를 들어 S=0001100 일 때,
 *
 * 전체를 뒤집으면 1110011이 된다.
 * 4번째 문자부터 5번째 문자까지 뒤집으면 1111111이 되어서 2번 만에 모두 같은 숫자로 만들 수 있다.
 * 하지만, 처음부터 4번째 문자부터 5번째 문자까지 문자를 뒤집으면 한 번에 0000000이 되어서 1번 만에 모두 같은 숫자로 만들 수 있다.
 *
 * 주어진 문자열을 모두 0 혹은 모두 1로 같게 만드는 최소 횟수를 반환하시오.
 */
class _01_07_find_count_to_turn_out_to_all_zero_or_all_one {
    fun result(str: String): Int {
        var zeroGroups = 0
        var oneGroups = 0
        var current = str[0]

        if (current == '0') zeroGroups++ else oneGroups++

        for (i in 1 until str.length) {
            if (str[i] != current) {
                current = str[i]
                if (current == '0') zeroGroups++ else oneGroups++
            }
        }

        return min(zeroGroups, oneGroups)
    }

    // 최적화 버전들
    fun result2(str: String): Int {
        if (str.isEmpty()) return 0

        var groups = 1
        for (i in 1 until str.length) {
            if (str[i] != str[i - 1]) groups++
        }

        return groups / 2
    }

    fun result3(str: String): Int {
        if (str.isEmpty()) return 0
        return (str.zipWithNext().count { it.first != it.second } + 1) / 2
    }
}

fun main() {

    val result = _01_07_find_count_to_turn_out_to_all_zero_or_all_one().result("0001100")
    val result2 = _01_07_find_count_to_turn_out_to_all_zero_or_all_one().result("11001100110011000001")
}
