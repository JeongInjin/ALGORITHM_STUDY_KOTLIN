package injinrithm._1_st_week

/**
 * Q. 다음과 같이 0 혹은 양의 정수로만 이루어진 배열이 있을 때,
 * 왼쪽부터 오른쪽으로 하나씩 모든 숫자를 확인하며 숫자 사이에 '✕'
 * 혹은 '+' 연산자를 넣어 결과적으로 가장 큰 수를 구하는 프로그램을 작성하시오.
 */
class _01_04_find_max_plus_or_multiply {

    fun result(array: Array<Int>): Int {
        if (array.isEmpty()) return 0

        var result = array[0]

        for (i in 1 until array.size) {
            val current = array[i]
            result = maxOf(result + current, result * current)
        }

        return result
    }
}

fun main() {
    val solution = _01_04_find_max_plus_or_multiply()
    println("정답 = 728 현재 풀이 값 = ${solution.result(arrayOf(0, 3, 5, 6, 1, 2, 4))}") // 728
    println("정답 = 8820 현재 풀이 값 = ${solution.result(arrayOf(3, 2, 1, 5, 9, 7, 4))}") // 8820
    println("정답 = 270 현재 풀이 값 = ${solution.result(arrayOf(1, 1, 1, 3, 3, 2, 5))}") // 270
}
