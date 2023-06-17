import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class StringCalculatorTest {
    private val calculator = StringCalculator

    @Test
    fun `빈 문자열 또는 null 을 입력하면 0을 반환한다`() {
        calculator.add("") shouldBe 0
        calculator.add(null) shouldBe 0
    }

    @ValueSource(strings = ["1", "2", "3"])
    @ParameterizedTest
    fun `숫자 하나를 입력하면 해당 숫자를 반환한다`(input: String?) {
        calculator.add(input) shouldBe input!!.toInt()
    }

    @Test
    fun `두 개 이상의 숫자를 쉼표 또는 콜론으로 입력하면 덧셈 결과를 반환한다`() {
        calculator.add("1,2,3") shouldBe 6
        calculator.add("1:2,3") shouldBe 6
        calculator.add("1:2:3") shouldBe 6
    }

    @DisplayName("//와 \n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @Test
    fun customDelimiter() {
        calculator.add("//;\n1;2;3") shouldBe 6
        calculator.add("//?\n1?2?3") shouldBe 6
    }

    @ValueSource(strings = ["-1:2", "//!\n1!3!-3"])
    @ParameterizedTest
    fun `입력 값에 음수가 있으면 RuntimeException을 반환한다`(input: String?) {
        Assertions.assertThatExceptionOfType(RuntimeException::class.java).isThrownBy {
            calculator.add(input)
        }
    }

    @ValueSource(strings = ["abc", "1?1?1"])
    @ParameterizedTest
    fun `입력 값이 잘못되면 RuntimeException을 반환한다`(input: String?) {
        Assertions.assertThatExceptionOfType(RuntimeException::class.java).isThrownBy {
            val result = calculator.add(input)
        }
    }
}
