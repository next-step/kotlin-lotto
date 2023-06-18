package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class StringAddCalculatorTest : FreeSpec({
    "쉼표 또는 콜론을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다." - {
        forAll(
            row("", 0),
            row("1,2", 3),
            row("1,2,3", 6),
            row("1,2:3", 6),
            row("1,2:3,4", 10),
            row("1:2:3:4:5", 15),
        ) { input, expected ->

            val result = StringAddCalculator.calculate(input)

            result shouldBe expected
        }
    }

    "'//'와 '\\n' 사이에 커스텀 구분자를 지정할 수 있다" - {
        forAll(
            row("//a\\n1a2a3a4", 10),
            row("//;\\n1;2;3;4", 10),
            row("//$\\n1$2$3$4", 10),
        ) { input, expected ->

            val result = StringAddCalculator.calculate(input)

            result shouldBe expected
        }
    }

    "문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다." - {
        forAll(
            row("//a\\n-3a2a3a4"),
            row("//;\\n1;2;asd;4"),
            row("//$\\n1$2$#$4"),
            row("1,2:3,-4"),
            row("1:2:3d:4:5"),
        ) { input ->
            shouldThrow<RuntimeException> {
                StringAddCalculator.calculate(input)
            }
        }
    }
})
