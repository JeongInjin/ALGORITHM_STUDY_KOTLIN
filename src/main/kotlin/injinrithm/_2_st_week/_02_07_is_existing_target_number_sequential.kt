package injinrithm._2_st_week

class _02_07_is_existing_target_number_sequential {
    fun solution(target: Int, numbers: IntArray): Boolean {
        var left = 0
        var right = numbers.size - 1

        while (left <= right) {
            val mid = (left + right) / 2

            if (numbers[mid] == target) return true

            if (numbers[mid] > target) { // 왼쪽 탐색
                right = mid - 1
            } else { // 오른쪽 탐색
                left = mid + 1
            }
        }

        return false
    }

    fun solution2(target: Int, numbers: IntArray): Boolean {
        var left = 0;
        var right = numbers.size - 1;
        var findCount = 0

        while (left <= right) {
            findCount++
            val mid = (left + right) / 2

            if (numbers[mid] == target) {
                println("✅ ${findCount}번만에 찾음! target=$target")
                return true
            } else if (numbers[mid] > target) right = mid - 1
            else left = mid + 1
        }

        return false
    }
}
