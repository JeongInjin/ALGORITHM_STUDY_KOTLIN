package injinrithm._1_st_week

/**
 * Q. 다음과 같이 영어로 되어 있는 문자열이 있을 때, 이 문자열에서 반복되지 않는 첫번째 문자를 반환하시오.
 * 만약 그런 문자가 없다면 _ 를 반환하시오.
 */
class _01_05_find_not_repeating_first_character {
    fun result(str: String): Char {
        var result = '_'
        val charArray = IntArray(26)
        for (i in str) {
            if (i.isLetter()) {
                charArray[i - 'a']++
            }
        }

        for (i in str) {
            if (i.isLetter() && charArray[i - 'a'] == 1) {
                result = i
                break
            }
        }

        return result
    }
    
    fun result2(str: String): Char {
        val charArray = IntArray(26)
        
        str.forEach { if (it.isLetter()) charArray[it - 'a']++ }
        
        return str.firstOrNull { it.isLetter() && charArray[it - 'a'] == 1 } ?: '_'
    }
}

fun main() {
    val solution = _01_05_find_not_repeating_first_character()
    println("정답 = d 현재 풀이 값 = ${solution.result("abadabac")}")
    println("정답 = c 현재 풀이 값 = ${solution.result("aabbcddd")}")
    println("정답 = _ 현재 풀이 값 = ${solution.result("aaaaaaaa")}")
    
    println("\n=== result2 (최적화) ===")
    println("정답 = d 현재 풀이 값 = ${solution.result2("abadabac")}")
    println("정답 = c 현재 풀이 값 = ${solution.result2("aabbcddd")}")
    println("정답 = _ 현재 풀이 값 = ${solution.result2("aaaaaaaa")}")
}
