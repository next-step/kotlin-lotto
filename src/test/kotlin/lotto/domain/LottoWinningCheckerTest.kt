package lotto.domain

import lotto.domain.model.Lotto
import lotto.domain.model.LottoRank
import lotto.domain.model.Lottos
import lotto.domain.model.WinningNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoWinningCheckerTest {
    @Test
    fun `LottoWinningChecker는 로또 번호들과 당첨 번호를 받아 LottoResult를 반환한다`() {
        val lottos = Lottos(
            listOf(
                Lotto(listOf(8, 21, 23, 41, 42, 43)),
                Lotto(listOf(8, 21, 23, 41, 42, 44)),
                Lotto(listOf(8, 21, 23, 41, 43, 44)),
                Lotto(listOf(8, 21, 23, 41, 1, 2)),
                Lotto(listOf(8, 21, 23, 1, 2, 3))
            )
        )

        val winningNumbers = WinningNumbers(listOf(8, 21, 23, 41, 42, 43))

        val lottoResult = LottoWinningChecker.check(lottos, winningNumbers)

        assertThat(lottoResult[LottoRank.FOURTH].count).isEqualTo(1)
        assertThat(lottoResult[LottoRank.THIRD].count).isEqualTo(1)
        assertThat(lottoResult[LottoRank.SECOND].count).isEqualTo(2)
        assertThat(lottoResult[LottoRank.FIRST].count).isEqualTo(1)
    }
}
