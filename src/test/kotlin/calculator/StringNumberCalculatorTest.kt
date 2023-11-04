package calculator

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class StringNumberCalculatorTest : FunSpec({
    val parser = StringNumberParser()
    val calculator = StringNumberCalculator(parser)

    test("계산기 정상 동작 테스트") {
        forAll(
            row(null, 0),
            row("", 0),
            row(" ", 0),
            row("1", 1),
            row("1,2", 3),
            row("1:2", 3),
            row("1,2,3", 6),
            row("1:2:3", 6),
            row("1,2:3", 6),
            row("//!\\n", 0),
            row("//!\\n ", 0),
            row("//!\\n1", 1),
            row("//!\\n1,2", 3),
            row("//!\\n1:2", 3),
            row("//!\\n1,2,3", 6),
            row("//!\\n1:2:3", 6),
            row("//!\\n1,2:3", 6),
            row("//!\\n1!2!3", 6),
            row("//!\\n1!2,3", 6),
            row("//!\\n1!2:3", 6),
        ) { input, answer ->
            val result = calculator.calculate(input)

            result shouldBe answer
        }
    }
})
