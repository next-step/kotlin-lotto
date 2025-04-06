package lotto.domain

import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {
    @ValueSource(ints = [1, 10, 20, 30, 40, 45])
    @ParameterizedTest
    fun `lotto number is correct`(number: Int) {
        assertDoesNotThrow {
            LottoNumber(number)
        }
    }

    @ValueSource(ints = [-1, 0, 46, 100])
    @ParameterizedTest
    fun `lotto number is incorrect`(number: Int) {
        assertThrows<IllegalArgumentException> {
            LottoNumber(number)
        }
    }
}
