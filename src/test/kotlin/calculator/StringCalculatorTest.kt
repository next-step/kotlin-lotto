package calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringCalculatorTest : StringSpec({
    "쉼표로 구분되는 숫자들을 더한다." {
        val expression = "1,2,3"
        val sut = StringCalculator()

        val actual = sut.calulate(expression)

        actual shouldBe 6.0
    }

    "콜론으로 구분되는 숫자들을 더한다." {
        val expression = "1:2:3"
        val sut = StringCalculator()

        val actual = sut.calulate(expression)

        actual shouldBe 6.0
    }

    "쉼표와 콜론으로 구분되는 숫자들을 더한다." {
        val expression = "1,2:3"
        val sut = StringCalculator()

        val actual = sut.calulate(expression)

        actual shouldBe 6.0
    }

    "커스텀 구분자로 구분되는 숫자들을 더한다." {
        val expression = "//;\n1;2;3"
        val sut = StringCalculator()

        val actual = sut.calulate(expression)

        actual shouldBe 6.0
    }
})
