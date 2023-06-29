package lotto.domain

import lotto.dto.PurchasedLotteryPapers
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoShopMatcherTest {

    private lateinit var lottoMatcher: LottoMatcher

    @BeforeEach
    fun setUp() {
        lottoMatcher = LottoMatcher()
    }

    @Test
    fun `로또 번호와 당첨 번호를 가지고 당첨 통계를 낸다`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val winningNumber = LotteryPaper(lottoNumbers)

        val lotteryPaperList = listOf(
            LotteryPaper(listOf(1, 2, 3, 4, 5, 6)),
            LotteryPaper(listOf(2, 3, 4, 5, 6, 7)),
            LotteryPaper(listOf(3, 4, 5, 6, 7, 8)),
            LotteryPaper(listOf(4, 5, 6, 7, 8, 9))
        )

        val purchasedLotteryPapers = PurchasedLotteryPapers(lotteryPaperList)
        val bonusBall = BonusBall(10, winningNumber)
        val countLottoWinner = lottoMatcher.countLottoWinner(
            winningNumber,
            purchasedLotteryPapers,
            bonusBall
        )

        val actual = countLottoWinner.getMatchLottoResult()
        val answer = mapOf(
            PrizeLevel.FIFTH to 1,
            PrizeLevel.FOURTH to 1,
            PrizeLevel.THIRD to 1,
            PrizeLevel.FIRST to 1,
        )

        Assertions.assertThat(actual).isEqualTo(answer)
    }
}
