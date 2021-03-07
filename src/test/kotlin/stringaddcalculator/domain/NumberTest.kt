package stringaddcalculator.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class NumberTest {

    @ParameterizedTest
    @ValueSource(strings = ["-1"])
    fun `Number에 음수를 전달하는 경우`(text: String) {
        Assertions.assertThatExceptionOfType(RuntimeException::class.java).isThrownBy {
            Number(text)
        }
    }
}