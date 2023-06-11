package calculator

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class StringCalculatorKtTest : FunSpec({

    context("calculate") {
        test("공백을 입력하는 경우 0이 반환된다.") {
            forAll(
                row(""),
                row(" ")
            ) { input ->
                val actual = calculate(input)
                actual shouldBe 0
            }
        }

        test("숫자만 입력되는 경우 숫자를 그대로 반환한다.") {
            val actual = calculate("1")
            actual shouldBe 1
        }

        test("숫자가 아닌 값이 입력되는 경우 예외가 발생한다.") {
            val exception = shouldThrowExactly<IllegalArgumentException> { calculate("a") }
            exception.message shouldBe "숫자가 아닌 문자를 입력할 수 없다"
        }
    }
})
