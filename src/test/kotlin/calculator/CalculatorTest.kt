package calculator

import calculator.domain.Calculator
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class CalculatorTest {
    @Test
    internal fun `기존 구분자를 가진 문자열을 전달했을 경우 합이 계산 된다`() {
        val calculator = Calculator()
        calculator.calculate("1,2")
        calculator.numbers shouldBe listOf("1", "2")
        calculator.result shouldBe 3

        calculator.calculate("3:4")
        calculator.numbers shouldBe listOf("3", "4")
        calculator.result shouldBe 7
    }

    @Test
    internal fun `빈 문자열 또는 null을 입력한 경우 0을 반환해야 한다`() {
        val calculator = Calculator()
        calculator.calculate("")
        calculator.result shouldBe 0

        calculator.calculate(null)
        calculator.result shouldBe 0
    }

    @Test
    internal fun `커스텀 구분자를 사용할 수 있다`() {
        val calculator = Calculator()
        calculator.calculate("//;\\n1;2;3")
        calculator.numbers shouldBe listOf("1", "2", "3")
        calculator.result shouldBe 6
    }

    @Test
    internal fun `음수를 전달할 경우 EXCEPTION이 발생한다`() {
        assertThrows<RuntimeException> {
            Calculator().calculate("//;\\n-1;2;3")
        }
    }

    @Test
    internal fun `숫자 이외의 값을 경우 EXCEPTION이 발생한다`() {
        assertThrows<RuntimeException> {
            Calculator().calculate("//;\\n.;2;3")
        }
    }

    @Test
    internal fun `연산기호가 충분하지 않을 경우 EXCEPTION이 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Calculator().calculate("//;1;2;3")
        }
    }
}
