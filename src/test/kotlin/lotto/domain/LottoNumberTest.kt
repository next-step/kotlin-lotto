package lotto.domain

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {
    @ValueSource(ints = [0, 46])
    @ParameterizedTest
    fun `로또 번호는 1과 45 사이의 값이 아니면 안된다`(number: Int) {
        assertThrows<IllegalArgumentException> {
            LottoNumber(number)
        }
    }
}
