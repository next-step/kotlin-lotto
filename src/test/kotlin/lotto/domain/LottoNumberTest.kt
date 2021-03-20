package lotto.domain

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoNumberTest {
    @DisplayName("로또 숫자의 범위를 벗어난 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun validateRange(input: Int) {
        assertThrows<IllegalArgumentException> { LottoNumber(input) }
    }

    @DisplayName("숫자가 아닌 String값으로 입력한 경우 예외 발생")
    @Test
    fun init() {
        assertThrows<NumberFormatException> { LottoNumber("a") }
    }
}
