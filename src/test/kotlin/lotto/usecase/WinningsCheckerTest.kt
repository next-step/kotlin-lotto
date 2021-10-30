package lotto.usecase

import lotto.domain.Lotto
import lotto.domain.WinningNumber
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WinningsCheckerTest {

    private val winningsChecker = WinningsChecker()

    @Test
    fun `로또 10장 샀을 때 총 가격이 10000원`() {
        val lottos = (1..10).map {
            Lotto(
                listOf(1, 2, 3, 4, 5, 6),
                1000
            )
        }

        val actual = winningsChecker.confirmWinning(
            lottos = lottos,
            winningNumber = WinningNumber(listOf(1, 2, 3, 4, 5, 6))
        )

        assertEquals(10000, actual.totalPurchaseAmount)
    }

    @Test
    fun `로또 20장 샀을 때 총 가격이 20000원`() {
        val lottos = (1..20).map {
            Lotto(
                listOf(1, 2, 3, 4, 5, 6),
                1000
            )
        }

        val actual = winningsChecker.confirmWinning(
            lottos = lottos,
            winningNumber = WinningNumber(listOf(1, 2, 3, 4, 5, 6))
        )

        assertEquals(20000, actual.totalPurchaseAmount)
    }

    @Test
    fun `로또 당첨결과 1등이 10개일때 firstRanks size 10, 총 상금 200억`() {
        val firstRankLottos = (1..10).map {
            Lotto(
                listOf(1, 2, 3, 4, 5, 6),
                1000
            )
        }

        val blankLottos = (1..10).map {
            Lotto(
                listOf(0, 0, 0, 0, 0, 0),
                1000
            )
        }

        val actual = winningsChecker.confirmWinning(
            lottos = firstRankLottos + blankLottos,
            winningNumber = WinningNumber(listOf(1, 2, 3, 4, 5, 6))
        )

        assertEquals(10, actual.firstRank)
        assertEquals(20_000_000_000, actual.totalReward)
    }

    @Test
    fun `로또 당첨결과 2등이 10개일때 secondRanks size 10, 총 상금 1500만원`() {
        val secondRankLottos = (1..10).map {
            Lotto(
                listOf(1, 2, 3, 4, 5, 0),
                1000
            )
        }

        val blankLottos = (1..10).map {
            Lotto(
                listOf(0, 0, 0, 0, 0, 0),
                1000
            )
        }

        val actual = winningsChecker.confirmWinning(
            lottos = secondRankLottos + blankLottos,
            winningNumber = WinningNumber(listOf(1, 2, 3, 4, 5, 6))
        )

        assertEquals(10, actual.secondRank)
        assertEquals(15_000_000, actual.totalReward)
    }

    @Test
    fun `로또 당첨결과 3등이 10개일때 thirdRank size 10, 상금 50만원`() {
        val thirdRankLottos = (1..10).map {
            Lotto(
                listOf(1, 2, 3, 4, 0, 0),
                1000
            )
        }

        val blankLottos = (1..10).map {
            Lotto(
                listOf(0, 0, 0, 0, 0, 0),
                1000
            )
        }

        val actual = winningsChecker.confirmWinning(
            lottos = thirdRankLottos + blankLottos,
            winningNumber = WinningNumber(listOf(1, 2, 3, 4, 5, 6))
        )

        assertEquals(10, actual.thirdRank)
        assertEquals(500_000, actual.totalReward)
    }

    @Test
    fun `로또 당첨결과 4등이 10개일때 fourthRanks size 10, 상금 5만원`() {
        val fourthRankLottos = (1..10).map {
            Lotto(
                listOf(1, 2, 3, 0, 0, 0),
                1000
            )
        }

        val blankLottos = (1..10).map {
            Lotto(
                listOf(0, 0, 0, 0, 0, 0),
                1000
            )
        }

        val actual = winningsChecker.confirmWinning(
            lottos = fourthRankLottos + blankLottos,
            winningNumber = WinningNumber(listOf(1, 2, 3, 4, 5, 6))
        )

        assertEquals(10, actual.fourthRank)
        assertEquals(50_000, actual.totalReward)
    }

    @Test
    fun `로또 모두 꽝 일때 firstRanks, secondRanks, thirdRanks, fourthRanks size 0`() {
        val fourthRankLottos = (1..10).map {
            Lotto(
                listOf(1, 2, 0, 0, 0, 0),
                1000
            )
        }

        val blankLottos = (1..10).map {
            Lotto(
                listOf(0, 0, 0, 0, 0, 0),
                1000
            )
        }

        val actual = winningsChecker.confirmWinning(
            lottos = fourthRankLottos + blankLottos,
            winningNumber = WinningNumber(listOf(1, 2, 3, 4, 5, 6))
        )

        assertEquals(0, actual.firstRank)
        assertEquals(0, actual.secondRank)
        assertEquals(0, actual.thirdRank)
        assertEquals(0, actual.fourthRank)
    }
}
