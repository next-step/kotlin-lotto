package string_calculator

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class StringAddCalculatorTest : StringSpec({
    "빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다." {
        listOf(
            null,
            ""
        ).forAll {
            // given
            val calculator = StringAddCalculator()

            // when
            val actual = calculator.add(it)

            // then
            actual shouldBe StringNumber(0)
        }
    }

    "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다." {
        // given
        val text = "1"
        val calculator = StringAddCalculator()

        // when
        val actual = calculator.add(text)

        // then
        actual shouldBe StringNumber(1)
    }

    "숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다." {
        // given
        val text = "1,2"
        val calculator = StringAddCalculator()

        // when
        val actual = calculator.add(text)

        // then
        actual shouldBe StringNumber(3)
    }

    "구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다." {
        // given
        val text = "1,2:3"
        val calculator = StringAddCalculator()

        // when
        val actual = calculator.add(text)

        // then
        actual shouldBe StringNumber(6)
    }

    "//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다." {
        // given
        val text = "//;\n1;2;3"
        val calculator = StringAddCalculator()

        // when
        val actual = calculator.add(text)

        // then
        actual shouldBe StringNumber(6)
    }

    "문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다." {
        // given
        val text = "-1"
        val calculator = StringAddCalculator()

        // when // then
        shouldThrowExactly<RuntimeException> { calculator.add(text) }
    }
})
