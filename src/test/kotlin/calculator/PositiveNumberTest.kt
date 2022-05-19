package calculator

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll

class PositiveNumberTest : StringSpec({
    "0이상의 숫자 객체를 생성할수 있다." {
        NUMBERS.forAll { shouldNotThrow<Throwable> { PositiveNumber(it) } }
    }

    "음수가 입력되면 Exception을 던진다." {
        shouldThrow<IllegalArgumentException> { PositiveNumber(-1) }
    }
}) {
    companion object {
        private val NUMBERS = listOf(0, 1, 5)
    }
}
