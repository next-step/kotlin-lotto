package calculator

import calculator.domain.Checker
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class CheckerTest {

    @ParameterizedTest
    @ValueSource(strings = ["", " "])
    internal fun `blank token checker 테스트`(input: String) {
        val expected = 0
        assertThat(Checker.parseInteger(input)).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource("a", "한", "@")
    internal fun `숫자 이외 값 예외 checker 테스트`(input: String) {
        assertThrows<RuntimeException> {
            Checker.parseInteger(input)
        }
    }
}
