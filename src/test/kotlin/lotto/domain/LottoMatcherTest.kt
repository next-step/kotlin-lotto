package lotto.domain

import lotto.dto.PurchasedLotteryPapers
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoMatcherTest {

    private lateinit var lottoMatcher: LottoMatcher

    @BeforeEach
    fun setUp() {
        lottoMatcher = LottoMatcher()
    }

    private fun createPurchasedLotteryPapers(): List<LotteryPaper> {
        return listOf(
            createLotteryPaper(1, 2, 3, 4, 5, 6),
            createLotteryPaper(2, 3, 4, 5, 6, 7),
            createLotteryPaper(3, 4, 5, 6, 7, 8),
            createLotteryPaper(4, 5, 6, 7, 8, 9)
        )
    }

    private fun createLotteryPaper(vararg numbers: Int): LotteryPaper {
        return LotteryPaper(numbers.map { LottoNumber(it) })
    }

    @Test
    fun `로또 번호와 당첨 번호를 가지고 당첨 통계를 낸다`() {
        // given
        val numberList = listOf(1, 2, 3, 4, 5, 6)
        val lottoNumbers = numberList.map { LottoNumber(it) }
        val winningNumber = WinningNumber(LotteryPaper(lottoNumbers), LottoNumber(10))
        val lotteryPaperList = createPurchasedLotteryPapers()

        // when
        val purchasedLotteryPapers = PurchasedLotteryPapers(lotteryPaperList)

        val countLottoWinner = lottoMatcher.countLottoWinner(
            winningNumber,
            purchasedLotteryPapers
        )

        // then
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
