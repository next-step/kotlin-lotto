package calculator

import io.kotest.core.spec.style.FreeSpec

internal class StringAddCalculatorTest : FreeSpec({

    "계산기 객체를 생성하고 add 메소드를 호출할 수 있다" {
        val calculator = StringAddCalculator()

        calculator.add("text")
    }
})
