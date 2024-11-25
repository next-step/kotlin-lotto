package string.add.calculator

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

@Suppress("NonAsciiCharacters")
class StringAddCalculatorTest {
    private val sut = StringAddCalculator

    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 문자열 또는 null 을 입력할 경우 0을 반환해야 한다`(text: String?) {
        val sum = sut.calculate(text)
        sum shouldBe 0
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "1", "42"])
    fun `숫자 하나를 입력한 경우 해당 숫자를 반환한다`(text: String) {
        val sum = sut.calculate(text)
        sum shouldBe text.toInt()
    }

    @Test
    fun `숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다`() {
        val sum = sut.calculate("1,2")
        sum shouldBe 3
    }

    @Test
    fun `구분자를 쉼표 이외에 콜론을 사용할 수 있다`() {
        val sum = sut.calculate("1,2:3")
        sum shouldBe 6
    }

    @Test
    fun `커스텀 구분자를 지정할 수 있다`() {
        val sum = sut.calculate("//;\n1;2;3")
        sum shouldBe 6
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1,2,3", "1,2,가나다"])
    fun `숫자 이외의 값 또는 음수를 전달하는 경우 예외를 던진다`(text: String) {
        assertThrows<RuntimeException> { sut.calculate(text) }
    }
}
