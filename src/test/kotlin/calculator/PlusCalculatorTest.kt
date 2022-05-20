package calculator

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PlusCalculatorTest : StringSpec({
    "덧셈 계산기 정상 생성" {
        shouldNotThrow<Throwable> { PlusCalculator(PositiveNumbers(listOf())) }
    }

    "양수 일급 컬렉션을 활용한 덧셈을 할수 있다." {
        val plusCalculator = PlusCalculator(PositiveNumbers(listOf(PositiveNumber(1), PositiveNumber(2))))

        plusCalculator.calculate() shouldBe PositiveNumber(3)
    }
})
