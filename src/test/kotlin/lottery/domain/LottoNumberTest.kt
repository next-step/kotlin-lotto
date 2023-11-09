package lottery.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoNumberTest {
    @Test
    fun `로또 번호는 음수를 가질 수 없다`() {
        assertThrows<IllegalArgumentException> {
            LottoNumber(-1)
        }
    }

    @Test
    fun `로또 번호는 45 이상의 수를 가질 수 없다`() {
        assertThrows<IllegalArgumentException> {
            LottoNumber(46)
        }
    }
}
