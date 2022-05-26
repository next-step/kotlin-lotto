package lotto.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoWinningTest {
    @Test
    fun `LottoWinning은 어떤 등수가 몇 개 당첨됐는지를 보관한다`() {
        val lottoWinning = LottoWinning(
            rank = LottoRank.FIRST,
            count = 1
        )

        assertThat(lottoWinning.rank).isEqualTo(LottoRank.FIRST)
        assertThat(lottoWinning.count).isEqualTo(1)
    }
}
