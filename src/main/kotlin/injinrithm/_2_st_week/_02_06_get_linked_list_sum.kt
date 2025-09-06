package injinrithm._2_st_week

import java.util.*

/**
 * Q.  다음과 같은 두 링크드 리스트를 입력받았을 때, 합산한 값을 반환하시오.
 *
 * 예를 들어 아래와 같은 링크드 리스트를 입력받았다면,
 * 각각 678, 354 이므로 두개의 총합
 * 678 + 354 = 1032 를 반환해야 한다.
 *
 * 단, 각 노드의 데이터는 한자리 수 숫자만 들어갈 수 있다.
 *
 * [6] -> [7] -> [8]
 * [3] -> [5] -> [4]
 */
class _02_06_get_linked_list_sum {

    fun solution(linkedList1: LinkedList<Int>, linkedList2: LinkedList<Int>): Int {
        val num1 = convertToNumber(linkedList1)
        val num2 = convertToNumber(linkedList2)
        return num1 + num2
    }
    
    private fun convertToNumber(list: LinkedList<Int>): Int {
        var result = 0
        
        // LinkedList를 순회하며 숫자 만들기
        for (digit in list) {
            result = result * 10 + digit
        }
        
        return result
    }
}
