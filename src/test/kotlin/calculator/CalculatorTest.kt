package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.lang.RuntimeException

class CalculatorTest : StringSpec({
    "문자열 계산기는 숫자를 전달하면 합을 구한다." {
        Calculator().sum(listOf(1, 2, 3)) shouldBe 6
    }

    "문자열 계산기에 음수를 전달하는 경우 예외를 던진다." {
        shouldThrow<RuntimeException> { Calculator().sum(listOf(-1, 2, 3)) }
    }
})
