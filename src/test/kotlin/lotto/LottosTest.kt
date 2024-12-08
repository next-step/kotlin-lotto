package lotto

import io.kotest.matchers.shouldBe
import lotto.model.*
import org.junit.jupiter.api.Test

class LottosTest {
    @Test
    fun `당첨 번호와 비교하여 계산한다`() {
        val winningLotto = WinningNumbers.from(listOf(1, 2, 3, 4, 5, 6), 7)

        val lotto1 = Lotto.from(listOf(1, 2, 3, 4, 5, 6)) // 6개 일치
        val lotto2 = Lotto.from(listOf(1, 2, 3, 4, 5, 7)) // 5개 일치, 보너스 일치
        val lotto2bonus = Lotto.from(listOf(1, 2, 3, 4, 5, 8)) // 5개 일치
        val lotto3 = Lotto.from(listOf(1, 2, 3, 4, 8, 9)) // 4개 일치
        val lotto4 = Lotto.from(listOf(1, 2, 3, 10, 11, 12)) // 3개 일치
        val lotto5 = Lotto.from(listOf(1, 2, 13, 14, 15, 16)) // 2개 일치

        val lottos = Lottos.from(listOf(lotto1, lotto2, lotto2bonus, lotto3, lotto4, lotto5))

        val expectedResults =
            LottoMatchResults.from(
                listOf(
                    LottoMatchResult(matchPrize = LottoPrize.THREE, count = 1),
                    LottoMatchResult(matchPrize = LottoPrize.FOUR, count = 1),
                    LottoMatchResult(matchPrize = LottoPrize.FIVE, count = 1),
                    LottoMatchResult(matchPrize = LottoPrize.FIVE_BONUS, count = 1),
                    LottoMatchResult(matchPrize = LottoPrize.SIX, count = 1),
                ),
            )

        lottos.countMatchingLottoNumbers(winningLotto).totalPrizeAmount shouldBe expectedResults.totalPrizeAmount
    }
}
