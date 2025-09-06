package injinrithm._1_st_week

/**
 * Q.  다음과 같은 문자열을 입력받았을 때, 어떤 알파벳이 가장 많이 포함되어 있는지 반환하시오.
 * (단 최빈값을 가진 알파벳이 여러개일 경우 알파벳 순서가 가장 앞에 위치한 알파벳을 출력하시오)
 *
 * 무조건 for 문 한번에 처리하는게 아닌, 최대 갯수가 적다면 최적의 메모리 효율성으로 O(n) 으로 처리하자.
 */
class _01_02_find_max_occurred_alphabet {
    fun result(str: String): Char {
        val letters = str.lowercase().filter { it.isLetter() }
        if (letters.isEmpty()) return throw IllegalArgumentException("알파벳이 없습니다.")

        val charMap = mutableMapOf<Char, Int>()
        for (c in letters) {
            charMap[c] = charMap.getOrDefault(c, 0) + 1
        }

        val maxCount = charMap.values.max()
        return charMap.filter { it.value == maxCount }.keys.min()
    }

    // 더 효율적
    fun result2(str: String): Char {
        val counts = IntArray(26)

        for (c in str.lowercase()) {
            if (c.isLetter()) {
                counts[c - 'a']++
            }
        }

        var maxCount = 0
        var result = 0

        for (i in counts.indices) {
            if (counts[i] > maxCount) {
                maxCount = counts[i]
                result = i
            }
        }

        return ('a' + result)
    }
}

fun main() {
    val solution = _01_02_find_max_occurred_alphabet()
    println("\n=== result (Map 방식) ===")
    println("현재 풀이 값 = ${solution.result("hello my name is injininjin")}")
    println("현재 풀이 값 = ${solution.result("ab")}")
    println("현재 풀이 값 = ${solution.result("bababa")}")
    println("현재 풀이 값 = ${solution.result("babaa")}")
    println("현재 풀이 값 = ${solution.result("babaabb")}")

    println("\n=== result2 (Array 방식) ====")
    println("현재 풀이 값 = ${solution.result2("hello my name is injininjin")}")
    println("현재 풀이 값 = ${solution.result2("ab")}")
    println("현재 풀이 값 = ${solution.result2("bababa")}")
    println("현재 풀이 값 = ${solution.result2("babaa")}")
    println("현재 풀이 값 = ${solution.result2("babaabb")}")
}
