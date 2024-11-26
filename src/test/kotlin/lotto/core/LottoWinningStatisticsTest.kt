package lotto.core

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoWinningStatisticsTest {
    @Test
    fun `보조 생성자를 테스트한다`() {
        val lottos = Lottos(listOf(Lotto((4..10).toList()), Lotto((3..9).toList())))
        lottos.forEach {
            it.checkWinningStates(WinningNumbers((1..6).toList()))
        }

        val lottoWinningStatistics = LottoWinningStatistics(lottos, 0.2f)

        lottoWinningStatistics.rank[WinningRank.RANK4] shouldBe 1
        lottoWinningStatistics.rank[WinningRank.RANK3] shouldBe 1
    }
}
