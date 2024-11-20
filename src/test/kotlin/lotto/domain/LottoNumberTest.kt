package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoNumberTest {

    @Test
    fun `로또 번호는 1부터 45 사이여야 한다`() {
        assertThrows<IllegalArgumentException> {
            LottoNumber(0)
        }

        assertThrows<IllegalArgumentException> {
            LottoNumber(46)
        }
    }
}
