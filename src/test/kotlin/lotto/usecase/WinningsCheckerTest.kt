package lotto.usecase

import lotto.domain.BonusNumber
import lotto.domain.Lotto
import lotto.domain.LottoNumbers
import lotto.domain.Rank
import lotto.domain.WinningNumber
import lotto.domain.WinningNumbers
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WinningsCheckerTest {

    private val winningsChecker = WinningsChecker()

    @Test
    fun `로또 당첨결과 1등이 10개일때 firstRanks size 10, 총 상금 200억`() {
        val firstRankLottos = (1..10).map {
            Lotto(
                LottoNumbers(listOf(1, 2, 3, 4, 5, 6)),
                1000
            )
        }

        val blankLottos = (1..10).map {
            Lotto(
                LottoNumbers(listOf(0, 0, 0, 0, 0, 0)),
                1000
            )
        }

        val actual = winningsChecker.confirmWinning(
            lottos = firstRankLottos + blankLottos,
            winningNumber = WinningNumber(
                WinningNumbers(listOf(1, 2, 3, 4, 5, 6)), BonusNumber(8)
            )
        )

        assertEquals(10, actual.getCountByRank(Rank.FIRST))
        assertEquals(20_000_000_000.0, actual.getTotalReward())
    }

    @Test
    fun `로또 당첨결과 2등이 10개일때 secondRanks size 10, 총 상금 1500만원`() {
        val secondRankLottos = (1..10).map {
            Lotto(
                LottoNumbers(listOf(1, 2, 3, 4, 5, 8)),
                1000
            )
        }

        val blankLottos = (1..10).map {
            Lotto(
                LottoNumbers(listOf(0, 0, 0, 0, 0, 0)),
                1000
            )
        }

        val actual = winningsChecker.confirmWinning(
            lottos = secondRankLottos + blankLottos,
            winningNumber = WinningNumber(
                WinningNumbers(listOf(1, 2, 3, 4, 5, 6)), BonusNumber(8)
            )
        )

        assertEquals(10, actual.getCountByRank(Rank.SECOND))
        assertEquals(300_000_000.0, actual.getTotalReward())
    }

    @Test
    fun `로또 당첨결과 3등이 10개일때 thirdRank size 10, 상금 50만원`() {
        val thirdRankLottos = (1..10).map {
            Lotto(
                LottoNumbers(listOf(1, 2, 3, 4, 5, 0)),
                1000
            )
        }

        val blankLottos = (1..10).map {
            Lotto(
                LottoNumbers(listOf(0, 0, 0, 0, 0, 0)),
                1000
            )
        }

        val actual = winningsChecker.confirmWinning(
            lottos = thirdRankLottos + blankLottos,
            winningNumber = WinningNumber(
                WinningNumbers(listOf(1, 2, 3, 4, 5, 6)), BonusNumber(8)
            )
        )

        assertEquals(10, actual.getCountByRank(Rank.THIRD))
        assertEquals(15_000_000.0, actual.getTotalReward())
    }

    @Test
    fun `로또 당첨결과 4등이 10개일때 fourthRanks size 10, 상금 5만원`() {
        val fourthRankLottos = (1..10).map {
            Lotto(
                LottoNumbers(listOf(1, 2, 3, 4, 0, 0)),
                1000
            )
        }

        val blankLottos = (1..10).map {
            Lotto(
                LottoNumbers(listOf(0, 0, 0, 0, 0, 0)),
                1000
            )
        }

        val actual = winningsChecker.confirmWinning(
            lottos = fourthRankLottos + blankLottos,
            winningNumber = WinningNumber(
                WinningNumbers(listOf(1, 2, 3, 4, 5, 6)), BonusNumber(8)
            )
        )

        assertEquals(10, actual.getCountByRank(Rank.FOURTH))
        assertEquals(500_000.0, actual.getTotalReward())
    }

    @Test
    fun `로또 모두 꽝 일때 firstRanks, secondRanks, thirdRanks, fourthRanks size 0`() {
        val fourthRankLottos = (1..10).map {
            Lotto(
                LottoNumbers(listOf(1, 2, 0, 0, 0, 0)),
                1000
            )
        }

        val blankLottos = (1..10).map {
            Lotto(
                LottoNumbers(listOf(0, 0, 0, 0, 0, 0)),
                1000
            )
        }

        val actual = winningsChecker.confirmWinning(
            lottos = fourthRankLottos + blankLottos,
            winningNumber = WinningNumber(
                WinningNumbers(listOf(1, 2, 3, 4, 5, 6)), BonusNumber(8)
            )
        )

        assertEquals(0, actual.getCountByRank(Rank.FIRST))
        assertEquals(0, actual.getCountByRank(Rank.SECOND))
        assertEquals(0, actual.getCountByRank(Rank.THIRD))
        assertEquals(0, actual.getCountByRank(Rank.FOURTH))
    }
}
