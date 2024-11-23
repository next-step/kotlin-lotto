package lotto.statistics

import io.kotest.matchers.collections.shouldContainExactly
import lotto.Lotto
import lotto.Lottos
import lotto.number.Numbers
import lotto.rank.LottoRank
import org.junit.jupiter.api.Test

class WinningStatisticsTest {
    @Test
    fun `로또 번호 목록의 평가 결과를 반환한다`() {
        val lottos = Lottos(listOf(getFirstLotto(), getNoneLotto()))
        WinningStatistics(purchasedLottos = lottos, winningNumbers = WINNING_NUMBERS).ranks shouldContainExactly
            listOf(
                LottoRank.FIRST,
                LottoRank.NONE,
            )
    }

    companion object {
        private fun getFirstLotto(): Lotto = Lotto(Numbers(listOf(1, 2, 3, 4, 5, 6)))

        private fun getNoneLotto(): Lotto = Lotto(Numbers(listOf(1, 2, 0, 0, 0, 0)))

        private val WINNING_NUMBERS = listOf(1, 2, 3, 4, 5, 6)
    }
}
