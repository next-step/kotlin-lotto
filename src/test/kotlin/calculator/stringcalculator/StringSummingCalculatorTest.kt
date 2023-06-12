package calculator.stringcalculator

import calculator.stringcalculator.config.CalculatorConfig
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class StringSummingCalculatorTest : FreeSpec({
    val calculator = CalculatorConfig.calculator

    "유효한 문자열을 전달할 경우 합계를 반환한다." - {
        listOf(
            "" to 0,
            "1,2" to 3,
            "1,2,3" to 6,
            "1,2:3" to 6,
            "//;\n1;2;3" to 6,
            "//n\n1n2n3" to 6,
            "//abc\n1abc2" to 3
        ).forEach {
            val actual = calculator.calculate(it.first)

            actual.value shouldBe it.second
        }
    }

    "유효하지 않은 문자열을 전달할 경우 예외를 던진다" - {
        listOf(
            "1,2,-3" to IllegalArgumentException::class,
            "a" to IllegalArgumentException::class,
            "a,b,2" to IllegalArgumentException::class,
            "//\n" to IllegalArgumentException::class,
            "//12\n1122" to IllegalArgumentException::class,
            ",2,3" to IllegalArgumentException::class,
            "1,2," to IllegalArgumentException::class,
            "//;\n1;2,3" to IllegalArgumentException::class,
        ).forEach {
            "${it.first} 문자열을 전달하면 ${it.second} 예외를 던진다." {
                val actual = shouldThrowAny { calculator.calculate(it.first) }

                actual::class shouldBe it.second
            }
        }
    }
})
