package lotto.domain

import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class LottoNumberTests {
    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun `로또 번호는 1~45가 아니면 IllegalArgumentException이 발생한다`(number: Int) {
        assertThrows<IllegalArgumentException> { LottoNumber(number) }
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 45])
    fun `로또 번호는 1~45면 Exception이 발생 안한다`(number: Int) {
        assertDoesNotThrow { LottoNumber(number) }
    }

    fun LottoNumber(number: Int): LottoNumber = LottoNumber.from(number)
}
