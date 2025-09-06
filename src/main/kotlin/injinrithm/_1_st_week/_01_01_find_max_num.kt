package injinrithm._1_st_week

// Q. 다음과 같이 숫자로 이루어진 배열이 있을 때, 이 배열 내에서 가장 큰 수를 반환하시오.
class _01_01_find_max_num {
    fun result(array: IntArray): Int {
        return array.max()
    }

    fun result2(array: IntArray): Int {
        var maxNumber = array[0]
        for (i in 1 until array.size) {
            if (maxNumber < array[i]) {
                maxNumber = array[i]
            }
        }
        return maxNumber
    }
}


fun main() {
    val solution = _01_01_find_max_num()
    val array = intArrayOf(3, 5, 6, 1, 2, 4)
    val array1 = intArrayOf(6, 6, 6)
    val array2 = intArrayOf(6, 9, 2, 7, 1888)

    println("정답 = 6 / 현재 풀이 값 = ${solution.result(array)}")
    println("정답 = 6 / 현재 풀이 값 = ${solution.result(array1)}")
    println("정답 = 1888 / 현재 풀이 값 = ${solution.result(array2)}")

    println("================================")

    println("정답 = 6 / 현재 풀이 값 = ${solution.result2(array)}")
    println("정답 = 6 / 현재 풀이 값 = ${solution.result2(array1)}")
    println("정답 = 1888 / 현재 풀이 값 = ${solution.result2(array2)}")
}
