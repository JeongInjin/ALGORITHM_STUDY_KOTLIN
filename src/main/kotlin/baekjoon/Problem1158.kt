package baekjoon

import java.util.*

/**
 * https://www.acmicpc.net/problem/1158
 * 요세푸스 문제는 다음과 같다.
 *
 * 1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다. 이제 순서대로 K번째 사람을 제거한다.
 * 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다.
 * 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.
 *
 * N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 5,000)
 *
 * 출력
 * 예제와 같이 요세푸스 순열을 출력한다.
 *
 * 예제 입력 1
 * 7 3
 * 예제 출력 1
 * <3, 6, 2, 7, 5, 1, 4>
 */
class Problem1158 {

    fun solution(n: Int, k: Int): String {
        val people = LinkedList<Int>()

        // 1부터 N까지 사람 추가
        for (i in 1..n) {
            people.add(i)
        }

        val result = mutableListOf<Int>()
        var index = 0

        while (people.isNotEmpty()) {
            // 원형 구조: 모듈로 연산으로 원형 처리
            index = (index + k - 1) % people.size

            // K번째 사람 제거
            val removed = people.removeAt(index)
            result.add(removed)
        }

        return "<${result.joinToString(", ")}>"
    }

    // 더 직관적인 방법: 단순 카운팅
    fun solution2(n: Int, k: Int): String {
        val people = LinkedList<Int>()

        // 1부터 N까지 사람 추가
        for (i in 1..n) {
            people.add(i)
        }

        val result = mutableListOf<Int>()
        var currentIndex = 0

        while (people.isNotEmpty()) {
            // K번 세기 (원형이므로 끝에서 처음으로)
            for (i in 1 until k) {
                currentIndex++
                if (currentIndex >= people.size) {
                    currentIndex = 0  // 끝에 도달하면 처음으로
                }
            }

            // K번째 사람 제거
            val removed = people.removeAt(currentIndex)
            result.add(removed)

            // 제거 후 인덱스 조정
            if (currentIndex >= people.size && people.isNotEmpty()) {
                currentIndex = 0
            }
        }

        return "<${result.joinToString(", ")}>"
    }
}

fun main() {
    val problem = Problem1158()
    println(problem.solution(7, 3))
    println(problem.solution2(7, 3))
}
