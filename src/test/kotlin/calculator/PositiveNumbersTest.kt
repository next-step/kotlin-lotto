package calculator

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PositiveNumbersTest : StringSpec({
    "양수 일급 컬랙션을 생성할 수 있다." {
        shouldNotThrow<Throwable> { PositiveNumbers(listOf(PositiveNumber(1), PositiveNumber(2))) }
    }

    "숫자들의 총 합을 구할수 있다." {
        val positiveNumbers = PositiveNumbers(listOf(PositiveNumber(1), PositiveNumber(2), PositiveNumber(3)))

        positiveNumbers.add() shouldBe PositiveNumber(6)
    }
})
