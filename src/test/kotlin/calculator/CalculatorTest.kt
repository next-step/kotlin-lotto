package calculator

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class CalculatorTest {
    @Test
    internal fun `쉼표를 가진 문자열을 전달했을 경우 쉼표를 구분자로 가진 Caculator객체가 생성된다`() {
        val calculator = Calculator("1,2")
        calculator.separator shouldBe ","
        calculator.numbers shouldBe listOf(1, 2)
        calculator.result shouldBe 3
    }

    @Test
    internal fun `콜론를 가진 문자열을 전달했을 경우 콜론를 구분자로 가진 Caculator객체가 생성된다`() {
        val calculator = Calculator("1:2")
        calculator.separator shouldBe ":"
        calculator.numbers shouldBe listOf(1, 2)
        calculator.result shouldBe 3
    }

    @Test
    internal fun `빈 문자열 또는 null을 입력한 경우 0을 반환해야 한다`() {
        val calculator = Calculator("")
        calculator.result shouldBe 0
    }

    @Test
    internal fun `커스텀 구분자를 사용할 수 있다`() {
        val calculator = Calculator("//;\n1;2;3")
        calculator.separator shouldBe ";"
        calculator.numbers shouldBe listOf(1, 2, 3)
        calculator.result shouldBe 6
    }

    @Test
    internal fun `음수를 전달할 경우 EXCEPTION이 발생한다`() {
        assertThrows<RuntimeException> {
            Calculator("//;\n-1;2;3")
        }
    }

    @Test
    internal fun `숫자 이외의 값을 경우 EXCEPTION이 발생한다`() {
        assertThrows<RuntimeException> {
            Calculator("//;\n.;2;3")
        }
    }

    @Test
    internal fun `연산기호가 충분하지 않을 경우 EXCEPTION이 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Calculator("//;1;2;3")
        }
    }
}
