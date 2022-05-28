package calculator.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class PositiveNumberTests {
    @ParameterizedTest(name = "`{0}`을 PositiveNumber로 변환하면 RuntimeException 발생")
    @ValueSource(doubles = [-1.0, -3.3])
    fun `음수를 PositiveNumber로 변환하면 RuntimeException 예외 처리를 한다`(number: Double) {
        assertThrows<RuntimeException> { PositiveNumber(number) }
    }

    @ParameterizedTest(name = "`{0}`은 PositiveNumber로 변환 가능")
    @ValueSource(doubles = [1.0, 3.24])
    fun `양수는 PositiveNumber로 변환 가능하다`(number: Double) {
        val actual = PositiveNumber(number)
        assertThat(actual.toDouble()).isEqualTo(number)
    }
}
