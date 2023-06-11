package calculator

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

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
    }
})
