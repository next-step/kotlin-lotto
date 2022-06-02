package lotto

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun `로또 번호는 1 이상 45 이하 숫자이다`(invalidNumber: Int) {
        assertThrows<IllegalArgumentException> { LottoNumber(invalidNumber) }
    }
}
