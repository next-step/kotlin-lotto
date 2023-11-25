package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `로또 한장은 6개의 숫자로 이루어져있다`() {
        val lotto = Lotto(1, 2, 3, 4, 5, 6)
        assertEquals(6, lotto.lottoNumbers.size)
    }

    @Test
    fun `당첨 번호에는 보너스 넘버가 포함되지 않아야한다`() {
        val lotto = Lotto(1, 2, 3, 4, 5, 6)
        val bonusNumber = LottoNumber(6)
        assertEquals(true, lotto.contains(bonusNumber))
    }
}
