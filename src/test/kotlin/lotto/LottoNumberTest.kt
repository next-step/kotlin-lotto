package lotto

import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {
    @ValueSource(ints = [1, 2, 3, 40, 45])
    @ParameterizedTest
    fun `Return LottoNumber when number is in between 1 and 45`(number: Int) {
        // given && when && then
        assertDoesNotThrow { LottoNumber.of(number) }
    }

    @ValueSource(ints = [-1, 0, 46])
    @ParameterizedTest
    fun `Throw IllegalArgumentException when number is not in between 1 and 45`(number: Int) {
        // given && when && then
        assertThrows<IllegalArgumentException> { LottoNumber.of(number) }
    }
}
