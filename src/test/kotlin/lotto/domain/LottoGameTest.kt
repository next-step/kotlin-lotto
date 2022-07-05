package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoGameTest {

    @Test
    fun `LottoGame은 profit을 계산할 수 있어야 한다`() {
        val lottos = LottoPaper(listOf(Lotto(1, 2, 3, 4, 5, 6)))
        val winningLotto = WinningLotto(Lotto(1, 2, 3, 4, 5, 6), LottoNumber.of(10))

        val lottoGame = LottoGame(lottos, winningLotto)

        assertThat(lottoGame.profit).isEqualTo(2000000.0)
    }
}
