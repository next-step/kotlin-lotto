package calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThatExceptionOfType

class CalculatorTest : StringSpec({
    "빈문자열을 입력할 경우 0을 반환해야 한다" {
        val stringCalculator = StringCalculator("")

        stringCalculator.calculate() shouldBe 0
    }

    "Null 을 입력할 경우 0을 반환해야 한다" {
        val stringCalculator = StringCalculator(null)

        stringCalculator.calculate() shouldBe 0
    }

    "숫자하나를 문자열로 입력할 경우 해당 숫자를 반환한다" {
        // given, when
        val stringCalculator = StringCalculator("5")

        // then
        stringCalculator.calculate() shouldBe 5
    }

    " , 구분자를 구분하여 숫자를 합하여 반환" {
        // given, when
        val stringCalculator = StringCalculator("1,3,4")

        // then
        stringCalculator.calculate() shouldBe (1 + 3 + 4)
    }

    " ,|: 구분자를 구분하여 숫자를 합하여 반환" {
        // given, when
        val stringCalculator = StringCalculator("1,3:4")

        // then
        stringCalculator.calculate() shouldBe (1 + 3 + 4)
    }

    "\"//\" \"\\n\"사이에 위체하는 문자를 커스텀 구분자로 추출하여 숫자를 합하여 반환" {
        // given, when
        val stringCalculator = StringCalculator("//;\n1;3;4")

        // then
        stringCalculator.calculate() shouldBe (1 + 3 + 4)
    }

    "구분자를 기준으로 분리한 문자에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw" {
        // given, when
        val stringCalculator = StringCalculator("1,-3,4")

        // then
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { stringCalculator.calculate() }
    }
})
