package injinrithm._1_st_week

/**
 * Q. 정수를 입력 했을 때, 그 정수 이하의 소수를 모두 반환하시오.
 *
 * 소수는 자신보다 작은 두 개의 자연수를 곱하여 만들 수 없는 1보다 큰 자연수이다.
 */
class _01_06_find_prime_list_under_number {
    fun result(num: Int): IntArray {
        if (num < 2) return IntArray(0)

        val isPrime = BooleanArray(num + 1) { true }
        isPrime[0] = false
        isPrime[1] = false

        // 에라토스테네스의 체
        for (i in 2..kotlin.math.sqrt(num.toDouble()).toInt()) {
            if (isPrime[i]) {
                for (j in i * i..num step i) {
                    isPrime[j] = false
                }
            }
        }

        return (2..num).filter { isPrime[it] }.toIntArray()
    }
}

fun main() {
    val solution = _01_06_find_prime_list_under_number()

//    println("result 1: ${solution.result(1).contentToString()}")
//    println("result 2: ${solution.result(2).contentToString()}")
//    println("result 3: ${solution.result(3).contentToString()}")
//    println("result 4: ${solution.result(4).contentToString()}")
//    println("result 5: ${solution.result(5).contentToString()}")
//    println("result 10: ${solution.result(10).contentToString()}")
//    println("result 20: ${solution.result(20).contentToString()}")
    println("result 100: ${solution.result(100).contentToString()}")
//    println("result 200: ${solution.result(200).contentToString()}")

}
