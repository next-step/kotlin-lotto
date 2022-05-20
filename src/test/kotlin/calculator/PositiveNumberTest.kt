package calculator

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class PositiveNumberTest : StringSpec({
    "0이상의 숫자 객체를 생성할수 있다." {
        NUMBERS.forAll { shouldNotThrow<Throwable> { PositiveNumber(it) } }
    }

    "음수가 입력되면 Exception을 던진다." {
        shouldThrow<IllegalArgumentException> { PositiveNumber(-1) }
    }

    "숫자 값을 더할수 있다." {
        val number1 = PositiveNumber(1)
        val number2 = PositiveNumber(2)

        number1 + number2 shouldBe PositiveNumber(3)
    }
}) {
    companion object {
        private val NUMBERS = listOf(0, 1, 5)
    }
}
