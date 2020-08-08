package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoGameTest {
    @Test
    fun make_many_lotto() {
        val amount = Amount(10, 0)

        val lottoGame = LottoGame(amount)

        assertThat(lottoGame.lottoList.size).isEqualTo(10)
    }

    @Test
    fun has_manual_lotto() {
        val manualLotto = listOf(Lotto(setOf(1,2,3,4,5,6)))
        val amount = Amount(10, manualLotto.size)

        val lottoGame = LottoGame(amount, manualLotto)

        assertThat(lottoGame.lottoList.size).isEqualTo(10)
    }
}
