package lotto

import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 11, 25, 45])
    fun `로또 번호는 1부터 45까지만 가능하다`(num: Int) {
        // given
        val number = num

        // when, then
        assertDoesNotThrow { LottoNumber(number) }
    }
}