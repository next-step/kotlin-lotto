import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource

class StringAddCalculatorTest {

    @ParameterizedTest
    @NullSource
    @EmptySource
    fun `빈 문자열 또는 null을 입력할 경우 0을 반환해야 한다`(input: String?) {
        // given
        val stringAddCalculator = StringAddCalculator(input)
        // when
        val result: Int = stringAddCalculator.calculate()
        // then
        assertThat(0).isEqualTo(result)
    }
    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "3"])
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`(input: String) {
        // given
        val stringAddCalculator = StringAddCalculator(input)
        // when
        val result: Int = stringAddCalculator.calculate()
        // then
        assertThat(result).isEqualTo(input.toInt())
    }
}
