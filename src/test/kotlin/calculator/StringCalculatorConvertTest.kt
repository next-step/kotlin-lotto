package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage

class StringCalculatorConvertTest : StringSpec({

    "구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다." {
        val positiveNumbers = StringCalculatorConvert.convertNumbers(
            stringCalculatorText = "0,1:2,3:4"
        )

        positiveNumbers.elements shouldBe IntArray(5) { it }
    }

    "지정된 구분자 외에 구분자를 입력하면 IllegalArgumentException 예외가 발생한다." {
        val expect = "1^"

        val exception = shouldThrow<IllegalArgumentException> {
            StringCalculatorConvert.convertNumbers(
                stringCalculatorText = "0,$expect:2,3:4"
            )
        }

        exception shouldHaveMessage CalculatorErrorCode.INVALID_NUMBERS.message(expect)
    }

    "숫자 하나를 문자열로 입력할 경우 숫자 하나만 반환한다." {
        val expect = "1"

        val positiveNumbers = StringCalculatorConvert.convertNumbers(
            stringCalculatorText = expect
        )

        val elements = positiveNumbers.elements

        elements.size shouldBe 1
        elements.firstOrNull() shouldBe expect.toIntOrNull()
    }

    "빈 문자열 값을 입력할 경우 0을 반환해야 한다." {
        val positiveNumbers = StringCalculatorConvert.convertNumbers(
            stringCalculatorText = ",3"
        )

        positiveNumbers.elements.firstOrNull() shouldBe 0
    }

    """//와 \n 문자 사이에 커스텀 구분자를 지정할 수 있다.""" {
        val positiveNumbers = StringCalculatorConvert.convertNumbers(
            stringCalculatorText = "//;\n0;1;2"
        )

        positiveNumbers.elements shouldBe IntArray(3) { it }
    }
})
