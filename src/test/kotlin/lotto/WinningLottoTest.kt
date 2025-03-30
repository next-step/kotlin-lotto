package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class WinningLottoTest {
    @Test
    fun `WinningLotto should have a lotto and a lotto number as a bonus number`() {
        // given
        val bonusNumber = LottoNumber(7)
        val lottoNumbers = (1..6).map { LottoNumber(it) }

        // when && then
        assertDoesNotThrow { WinningLotto(Lotto(lottoNumbers), bonusNumber) }
    }
}
