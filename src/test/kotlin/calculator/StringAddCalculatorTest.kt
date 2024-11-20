package calculator

import calculator.StringAddCalculator.calculate
import calculator.StringAddCalculator.parse
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

object StringAddCalculator {

    fun parse(text: String): List<Int> {
        return text.split(",", ":").map { it.toInt() }
    }

    fun calculate(text: String): Int {
        return parse(text).sum()
    }
}

class StringAddCalculatorTest : StringSpec({
    "쉼표를 통해 문자에서 숫자를 분리한다" {
        val text = "1,2,3"
        parse(text) shouldBe listOf(1, 2, 3)
    }

    "콜론을 통해 숫자를 분리한다" {
        val text = "1:2:3"
        parse(text) shouldBe listOf(1, 2, 3)
    }

    "분리한 숫자의 합을 반환한다" {
        val text = "1,2,3:4"
        calculate(text) shouldBe 10
    }

    "빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다" {}
    "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다" {}
    "숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다" {}
    "구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다" {}
    """//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다""" {}
    "문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다" {}
})