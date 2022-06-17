package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoGameTest {

    @Test
    fun `LottoGame should be count rank`() {
        val lottos = listOf(Lotto((1..6).map { LottoNumber.of(it) }))
        val winningNumbers = Lotto((1..6).map { LottoNumber.of(it) })
        val bonusNumber = LottoNumber.of(10)

        val lottoGame = LottoGame(lottos, winningNumbers, bonusNumber)

        assertThat(lottoGame.countOfRank(Rank.FIRST)).isEqualTo(1)
    }

    @Test
    fun `LottoGame은 profit을 계산할 수 있어야 한다`() {
        val lottos = listOf(Lotto((1..6).map { LottoNumber.of(it) }))
        val winningNumbers = Lotto((1..6).map { LottoNumber.of(it) })
        val bonusNumber = LottoNumber.of(10)

        val lottoGame = LottoGame(lottos, winningNumbers, bonusNumber)

        assertThat(lottoGame.profit).isEqualTo(2000000.0)
    }
}
