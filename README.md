# Algorithm Study with Kotlin

코틀린으로 알고리즘 문제를 풀어보는 스터디 프로젝트입니다.

## 프로젝트 구조

```
algorithm_study/
├── src/
│   ├── main/kotlin/
│   │   ├── leetcode/          # LeetCode 문제 풀이
│   │   ├── baekjoon/          # 백준 문제 풀이
│   │   └── Main.kt
│   └── test/kotlin/
│       ├── leetcode/          # LeetCode 테스트
│       └── baekjoon/          # 백준 테스트
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

## 사용법

### 프로젝트 빌드
```bash
./gradlew build
```

### 테스트 실행
```bash
./gradlew test
```

### 특정 문제 실행
```bash
./gradlew run
```

## 문제 추가 가이드

### LeetCode 문제 추가
1. `src/main/kotlin/leetcode/` 디렉토리에 문제 파일 생성
2. 파일명: `ProblemName.kt` (예: `TwoSum.kt`)
3. 클래스명과 함수명을 명확하게 작성
4. 문제 링크와 설명을 주석으로 추가

### 백준 문제 추가
1. `src/main/kotlin/baekjoon/` 디렉토리에 문제 파일 생성
2. 파일명: `Problem{번호}.kt` (예: `Problem1000.kt`)
3. main 함수로 입출력 처리
4. 테스트를 위한 별도 함수 작성

### 테스트 작성
- 각 문제에 대해 `src/test/kotlin/` 하위에 테스트 파일 작성
- JUnit5와 Kotlin Test를 사용
- 다양한 테스트 케이스 포함

## 예제

### LeetCode 예제 (Two Sum)
```kotlin
class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        // 구현
    }
}
```

### 백준 예제 (A+B)
```kotlin
fun main() {
    val (a, b) = readLine()!!.split(" ").map { it.toInt() }
    println(a + b)
}
```

## 참고 사이트
- [LeetCode](https://leetcode.com/)
- [백준 온라인 저지](https://www.acmicpc.net/)
