package injinrithm._1_st_week

import injinrithm._2_st_week.LinkedListIJ
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.*

class Algorithm2Week1Test {

    @Test
    fun testEmptyList() {
        val list = LinkedListIJ()
        assertThat(list.get(0)).isNull()
        assertThat(list.getNode(0)).isNull()
        list.delete(0)  // 예외 없이 처리되어야 함
    }

    @Test
    fun testSingleNode() {
        val list = LinkedListIJ()
        list.append(100)

        assertThat(list.get(0)).isEqualTo(100)
        assertThat(list.get(1)).isNull()

        list.delete(0)
        assertThat(list.get(0)).isNull()
    }

    @Test
    fun testAppendOnly() {
        val list = LinkedListIJ()
        list.append(1)
        list.append(2)
        list.append(3)

        assertThat(list.get(0)).isEqualTo(1)
        assertThat(list.get(1)).isEqualTo(2)
        assertThat(list.get(2)).isEqualTo(3)
        assertThat(list.get(3)).isNull()
    }

    @Test
    fun testPrependOnly() {
        val list = LinkedListIJ()
        list.prepend(3)
        list.prepend(2)
        list.prepend(1)

        assertThat(list.get(0)).isEqualTo(1)
        assertThat(list.get(1)).isEqualTo(2)
        assertThat(list.get(2)).isEqualTo(3)
    }

    @Test
    fun testHeadDeletion() {
        val list = LinkedListIJ()
        list.append(1)
        list.append(2)
        list.append(3)

        list.delete(0)  // head 삭제
        assertThat(list.get(0)).isEqualTo(2)
        assertThat(list.get(1)).isEqualTo(3)
        assertThat(list.get(2)).isNull()
    }

    @Test
    fun testMiddleDeletion() {
        val list = LinkedListIJ()
        list.append(1)
        list.append(2)
        list.append(3)

        list.delete(1)  // 중간 삭제
        assertThat(list.get(0)).isEqualTo(1)
        assertThat(list.get(1)).isEqualTo(3)
        assertThat(list.get(2)).isNull()
    }

    @Test
    fun testTailDeletion() {
        val list = LinkedListIJ()
        list.append(1)
        list.append(2)
        list.append(3)

        list.delete(2)  // tail 삭제
        assertThat(list.get(0)).isEqualTo(1)
        assertThat(list.get(1)).isEqualTo(2)
        assertThat(list.get(2)).isNull()
    }

    @Test
    fun testTailDeletionThenAppend() {
        val list = LinkedListIJ()
        list.append(1)
        list.append(2)
        list.append(3)

        list.delete(2)  // tail 삭제
        list.append(4)  // tail 업데이트 테스트

        assertThat(list.get(0)).isEqualTo(1)
        assertThat(list.get(1)).isEqualTo(2)
        assertThat(list.get(2)).isEqualTo(4)
        assertThat(list.get(3)).isNull()
    }

    @Test
    fun testInvalidIndices() {
        val list = LinkedListIJ()
        list.append(1)

        assertThat(list.get(-1)).isNull()
        assertThat(list.get(5)).isNull()
        assertThat(list.getNode(-1)).isNull()
        assertThat(list.getNode(5)).isNull()

        list.delete(-1)  // 예외 없이 처리
        list.delete(5)   // 예외 없이 처리
    }

    @Test
    fun testMixedOperations() {
        val list = LinkedListIJ()

        // 복합 작업
        list.append(2)      // [2]
        list.prepend(1)     // [1, 2]
        list.append(4)      // [1, 2, 4]
        list.delete(1)      // [1, 4]
        list.prepend(0)     // [0, 1, 4]
        list.append(5)      // [0, 1, 4, 5]
        list.delete(0)      // [1, 4, 5]
        list.delete(2)      // [1, 4]

        assertThat(list.get(0)).isEqualTo(1)
        assertThat(list.get(1)).isEqualTo(4)
        assertThat(list.get(2)).isNull()

        // 최종 append 테스트
        list.append(6)
        assertThat(list.get(2)).isEqualTo(6)
    }

    @Test
    fun testAddToIndex() {
        val list = LinkedListIJ()

        // 빈 리스트에 index 0 삽입
        list.addToIndex(0, 10)
        assertThat(list.get(0)).isEqualTo(10)
        assertThat(list.get(1)).isNull()

        // index 0에 삽입 (head 앞)
        list.addToIndex(0, 5)
        assertThat(list.get(0)).isEqualTo(5)
        assertThat(list.get(1)).isEqualTo(10)

        // 중간에 삽입
        list.addToIndex(1, 7)
        assertThat(list.get(0)).isEqualTo(5)
        assertThat(list.get(1)).isEqualTo(7)
        assertThat(list.get(2)).isEqualTo(10)

        // 마지막에 삽입 (tail 업데이트 테스트)
        list.addToIndex(3, 15)
        assertThat(list.get(0)).isEqualTo(5)
        assertThat(list.get(1)).isEqualTo(7)
        assertThat(list.get(2)).isEqualTo(10)
        assertThat(list.get(3)).isEqualTo(15)

        // tail 삽입 후 append 테스트
        list.append(20)
        assertThat(list.get(4)).isEqualTo(20)
    }

    @Test
    fun testAddToIndexEdgeCases() {
        val list = LinkedListIJ()
        list.append(1)
        list.append(2)
        list.append(3)

        // 음수 인덱스
        list.addToIndex(-1, 999)
        assertThat(list.get(0)).isEqualTo(1)  // 변화 없음

        // 범위 초과 인덱스
        list.addToIndex(10, 999)
        assertThat(list.get(2)).isEqualTo(3)  // 변화 없음
        assertThat(list.get(3)).isNull()

        // 유효한 마지막 인덱스 + 1
        list.addToIndex(3, 4)
        assertThat(list.get(3)).isEqualTo(4)
    }

    @Test
    fun testAddToIndexWithOtherOperations() {
        val list = LinkedListIJ()

        // 복합 테스트
        list.append(2)          // [2]
        list.addToIndex(0, 1)   // [1, 2]
        list.addToIndex(2, 4)   // [1, 2, 4]
        list.addToIndex(2, 3)   // [1, 2, 3, 4]
        list.prepend(0)         // [0, 1, 2, 3, 4]
        list.delete(2)          // [0, 1, 3, 4]
        list.addToIndex(2, 2)   // [0, 1, 2, 3, 4]

        assertThat(list.get(0)).isEqualTo(0)
        assertThat(list.get(1)).isEqualTo(1)
        assertThat(list.get(2)).isEqualTo(2)
        assertThat(list.get(3)).isEqualTo(3)
        assertThat(list.get(4)).isEqualTo(4)
        assertThat(list.get(5)).isNull()
    }

    @Test
    fun testLinkedListSum() {
        val solution = injinrithm._2_st_week._02_06_get_linked_list_sum()

        // 기본 테스트: 678 + 354 = 1032
        val list1 = LinkedList(listOf(6, 7, 8))
        val list2 = LinkedList(listOf(3, 5, 4))

        val result = solution.solution(list1, list2)
        assertThat(result).isEqualTo(1032)
    }

    @Test
    fun testLinkedListSumSingleDigit() {
        val solution = injinrithm._2_st_week._02_06_get_linked_list_sum()

        val list1 = LinkedList(listOf(5))
        val list2 = LinkedList(listOf(3))

        val result = solution.solution(list1, list2)
        assertThat(result).isEqualTo(8)  // 5 + 3 = 8
    }

    @Test
    fun testLinkedListSumWithZero() {
        val solution = injinrithm._2_st_week._02_06_get_linked_list_sum()

        val list1 = LinkedList(listOf(1, 0, 5))  // 105
        val list2 = LinkedList(listOf(2, 0, 3))  // 203

        val result = solution.solution(list1, list2)
        assertThat(result).isEqualTo(308)  // 105 + 203 = 308
    }

    @Test
    fun testLinkedListSumEmptyLists() {
        val solution = injinrithm._2_st_week._02_06_get_linked_list_sum()

        val list1 = LinkedList<Int>()
        val list2 = LinkedList<Int>()

        val result = solution.solution(list1, list2)
        assertThat(result).isEqualTo(0)  // 0 + 0 = 0
    }

    @Test
    fun testLinkedListSumDifferentLengths() {
        val solution = injinrithm._2_st_week._02_06_get_linked_list_sum()

        val list1 = LinkedList(listOf(1, 2, 3, 4))  // 1234
        val list2 = LinkedList(listOf(5, 6))  // 56

        val result = solution.solution(list1, list2)
        assertThat(result).isEqualTo(1290)  // 1234 + 56 = 1290
    }

    @Test
    fun testBinarySearchSolution() {
        val solution = injinrithm._2_st_week._02_07_is_existing_target_number_sequential()

        // 주어진 테스트 케이스
        val findingTarget = 14
        val findingNumbers = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)

        assertThat(solution.solution(findingTarget, findingNumbers)).isTrue()
    }

    @Test
    fun testBinarySearchSolution2() {
        val solution = injinrithm._2_st_week._02_07_is_existing_target_number_sequential()

        // 주어진 테스트 케이스
        val findingTarget = 14
        val findingNumbers = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)

        assertThat(solution.solution2(findingTarget, findingNumbers)).isTrue()
    }

    @Test
    fun testBothBinarySearchSolutions() {
        val solution = injinrithm._2_st_week._02_07_is_existing_target_number_sequential()
        val numbers = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)

        // 존재하는 숫자들
        for (target in 1..16) {
            assertThat(solution.solution(target, numbers)).isTrue()
            assertThat(solution.solution2(target, numbers)).isTrue()
        }

        // 존재하지 않는 숫자들
        assertThat(solution.solution(0, numbers)).isFalse()
        assertThat(solution.solution2(0, numbers)).isFalse()
        assertThat(solution.solution(17, numbers)).isFalse()
        assertThat(solution.solution2(17, numbers)).isFalse()
    }
}
