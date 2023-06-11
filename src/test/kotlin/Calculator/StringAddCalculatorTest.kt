package Calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringAddCalculatorTest : StringSpec({
    val stringAddCalculator = StringAddCalculator()

    "계산 성공" {
        mapOf(
            null to 0, "" to 0,
            "1" to 1,
            "1,2" to 3,
            "1,2:3" to 6,
            "//;\n1;2;3" to 6
        ).forEach { (input, answer) ->
            stringAddCalculator.calculate(input) shouldBe answer
        }
    }

    "양수가 아니면 에러" {
        shouldThrow<RuntimeException> {
            listOf("-1,2,3", "a,b").forEach {
                stringAddCalculator.calculate(it)
            }
        }
    }
//
//    @ParameterizedTest
//    @ValueSource(strings = ["-1,2,3", "a,b"])
//    fun calculate_negative(input: String?) {
//        assertThatThrownBy { stringAddCalculator!!.calculate(input) }
//            .isInstanceOf(RuntimeException::class.java)
//    }
})

