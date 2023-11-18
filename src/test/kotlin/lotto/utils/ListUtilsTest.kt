package lotto.utils

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.comparables.shouldBeLessThan

class ListUtilsTest : FunSpec({
    test("정수 리스트의 랜덤한 숫자가 정렬되어 반환되는지 테스트") {
        val numbers = (1..10).toList()
        val n = 6
        val sort = true

        val result = numbers.shuffleAndTake(n, sort)

        result.windowed(2, 1)
            .forEach {
                val firstNumber = it[0]
                val secondNumber = it[1]

                firstNumber shouldBeLessThan secondNumber
            }
    }
})
