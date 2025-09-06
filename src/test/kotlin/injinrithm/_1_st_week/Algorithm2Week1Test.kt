package injinrithm._1_st_week

import injinrithm._2_st_week.LinkedListIJ
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import java.util.*

class Algorithm2Week1Test {

    @Test
    fun testEmptyList() {
        val list = LinkedListIJ()
        assertNull(list.get(0))
        assertNull(list.getNode(0))
        list.delete(0)  // 예외 없이 처리되어야 함
    }

    @Test
    fun testSingleNode() {
        val list = LinkedListIJ()
        list.append(100)

        assertEquals(100, list.get(0))
        assertNull(list.get(1))

        list.delete(0)
        assertNull(list.get(0))
    }

    @Test
    fun testAppendOnly() {
        val list = LinkedListIJ()
        list.append(1)
        list.append(2)
        list.append(3)

        assertEquals(1, list.get(0))
        assertEquals(2, list.get(1))
        assertEquals(3, list.get(2))
        assertNull(list.get(3))
    }

    @Test
    fun testPrependOnly() {
        val list = LinkedListIJ()
        list.prepend(3)
        list.prepend(2)
        list.prepend(1)

        assertEquals(1, list.get(0))
        assertEquals(2, list.get(1))
        assertEquals(3, list.get(2))
    }

    @Test
    fun testHeadDeletion() {
        val list = LinkedListIJ()
        list.append(1)
        list.append(2)
        list.append(3)

        list.delete(0)  // head 삭제
        assertEquals(2, list.get(0))
        assertEquals(3, list.get(1))
        assertNull(list.get(2))
    }

    @Test
    fun testMiddleDeletion() {
        val list = LinkedListIJ()
        list.append(1)
        list.append(2)
        list.append(3)

        list.delete(1)  // 중간 삭제
        assertEquals(1, list.get(0))
        assertEquals(3, list.get(1))
        assertNull(list.get(2))
    }

    @Test
    fun testTailDeletion() {
        val list = LinkedListIJ()
        list.append(1)
        list.append(2)
        list.append(3)

        list.delete(2)  // tail 삭제
        assertEquals(1, list.get(0))
        assertEquals(2, list.get(1))
        assertNull(list.get(2))
    }

    @Test
    fun testTailDeletionThenAppend() {
        val list = LinkedListIJ()
        list.append(1)
        list.append(2)
        list.append(3)

        list.delete(2)  // tail 삭제
        list.append(4)  // tail 업데이트 테스트

        assertEquals(1, list.get(0))
        assertEquals(2, list.get(1))
        assertEquals(4, list.get(2))  // 이것이 성공해야 tail 업데이트가 올바름
        assertNull(list.get(3))
    }

    @Test
    fun testInvalidIndices() {
        val list = LinkedListIJ()
        list.append(1)

        assertNull(list.get(-1))
        assertNull(list.get(5))
        assertNull(list.getNode(-1))
        assertNull(list.getNode(5))

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

        assertEquals(1, list.get(0))
        assertEquals(4, list.get(1))
        assertNull(list.get(2))

        // 최종 append 테스트
        list.append(6)
        assertEquals(6, list.get(2))
    }

    @Test
    fun testAddToIndex() {
        val list = LinkedListIJ()

        // 빈 리스트에 index 0 삽입
        list.addToIndex(0, 10)
        assertEquals(10, list.get(0))
        assertNull(list.get(1))

        // index 0에 삽입 (head 앞)
        list.addToIndex(0, 5)
        assertEquals(5, list.get(0))
        assertEquals(10, list.get(1))

        // 중간에 삽입
        list.addToIndex(1, 7)
        assertEquals(5, list.get(0))
        assertEquals(7, list.get(1))
        assertEquals(10, list.get(2))

        // 마지막에 삽입 (tail 업데이트 테스트)
        list.addToIndex(3, 15)
        assertEquals(5, list.get(0))
        assertEquals(7, list.get(1))
        assertEquals(10, list.get(2))
        assertEquals(15, list.get(3))

        // tail 삽입 후 append 테스트
        list.append(20)
        assertEquals(20, list.get(4))
    }

    @Test
    fun testAddToIndexEdgeCases() {
        val list = LinkedListIJ()
        list.append(1)
        list.append(2)
        list.append(3)

        // 음수 인덱스
        list.addToIndex(-1, 999)
        assertEquals(1, list.get(0))  // 변화 없음

        // 범위 초과 인덱스
        list.addToIndex(10, 999)
        assertEquals(3, list.get(2))  // 변화 없음
        assertNull(list.get(3))

        // 유효한 마지막 인덱스 + 1
        list.addToIndex(3, 4)
        assertEquals(4, list.get(3))
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

        assertEquals(0, list.get(0))
        assertEquals(1, list.get(1))
        assertEquals(2, list.get(2))
        assertEquals(3, list.get(3))
        assertEquals(4, list.get(4))
        assertNull(list.get(5))
    }

    @Test
    fun testLinkedListSum() {
        val solution = injinrithm._2_st_week._02_06_get_linked_list_sum()

        // 기본 테스트: 678 + 354 = 1032
        val list1 = LinkedList(listOf(6, 7, 8))
        val list2 = LinkedList(listOf(3, 5, 4))

        val result = solution.solution(list1, list2)
        assertEquals(1032, result)
    }

    @Test
    fun testLinkedListSumSingleDigit() {
        val solution = injinrithm._2_st_week._02_06_get_linked_list_sum()

        val list1 = LinkedList(listOf(5))
        val list2 = LinkedList(listOf(3))

        val result = solution.solution(list1, list2)
        assertEquals(8, result)  // 5 + 3 = 8
    }

    @Test
    fun testLinkedListSumWithZero() {
        val solution = injinrithm._2_st_week._02_06_get_linked_list_sum()

        val list1 = LinkedList(listOf(1, 0, 5))  // 105
        val list2 = LinkedList(listOf(2, 0, 3))  // 203

        val result = solution.solution(list1, list2)
        assertEquals(308, result)  // 105 + 203 = 308
    }

    @Test
    fun testLinkedListSumEmptyLists() {
        val solution = injinrithm._2_st_week._02_06_get_linked_list_sum()

        val list1 = LinkedList<Int>()
        val list2 = LinkedList<Int>()

        val result = solution.solution(list1, list2)
        assertEquals(0, result)  // 0 + 0 = 0
    }

    @Test
    fun testLinkedListSumDifferentLengths() {
        val solution = injinrithm._2_st_week._02_06_get_linked_list_sum()

        val list1 = LinkedList(listOf(1, 2, 3, 4))  // 1234
        val list2 = LinkedList(listOf(5, 6))  // 56

        val result = solution.solution(list1, list2)
        assertEquals(1290, result)  // 1234 + 56 = 1290
    }
}
