package lotto.statistics

import io.kotest.matchers.collections.shouldContainExactly
import lotto.Lottos
import lotto.ball.BonusBall
import lotto.number.LottoNumber
import lotto.number.Numbers
import lotto.rank.LottoRank
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class WinningStatisticsTest {
    private lateinit var winningNumber: WinningNumber

    @BeforeEach
    fun beforeEach() {
        winningNumber =
            WinningNumber(
                numbers = Numbers(WINNING_NUMBERS),
                bonusBall = BonusBall(LottoNumber(BONUS_NUMBER)),
            )
    }

    @Test
    fun `로또 번호 목록의 평가 결과를 반환한다`() {
        val lottos =
            Lottos(
                listOf(
                    getLotto(fromInts = listOf(1, 2, 3, 4, 5, 6)),
                    getLotto(fromInts = listOf(1, 2, 3, 4, 5, BONUS_NUMBER)),
                    getLotto(fromInts = listOf(1, 2, 3, 4, 5, NOT_MATCHED_NUMBER)),
                    getLotto(fromInts = listOf(1, 2), size = 4, defaultValue = NOT_MATCHED_NUMBER),
                ),
            )
        WinningStatistics(purchasedLottos = lottos, winningNumber = winningNumber).ranks shouldContainExactly
            listOf(
                LottoRank.FIRST,
                LottoRank.SECOND,
                LottoRank.THIRD,
                LottoRank.NONE,
            )
    }

    companion object {
        private const val BONUS_NUMBER = 7
        private const val NOT_MATCHED_NUMBER = 45
        private val WINNING_NUMBERS = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }
    }
}
