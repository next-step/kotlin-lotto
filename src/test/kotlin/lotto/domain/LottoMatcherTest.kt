package lotto.domain

import lotto.dto.LotteryPapers
import lotto.dto.LottoMatchResult
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoMatcherTest {

    private lateinit var lottoMatcher: LottoMatcher

    @BeforeEach
    fun setUp() {
        lottoMatcher = LottoMatcher()
    }

    @Test
    fun `로또 번호와 당첨 번호를 가지고 당첨 통계를 낸다`() {
        // given
        val numberList = listOf(1, 2, 3, 4, 5, 6)
        val lottoNumbers = numberList.map { LottoNumber(it) }
        val winningNumber = WinningNumber(LotteryPaper(lottoNumbers), LottoNumber(10))
        val lotteryPaperList = LottoTestHelper.generateLotteryPaperLists()

        // when
        val lotteryPapers = LotteryPapers(lotteryPaperList)

        val countLottoWinner = lottoMatcher.countLottoWinner(
            winningNumber,
            lotteryPapers
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

    @Test
    fun `로또 등수 리스트를 입력받아서 통계를 낸다`() {
        // given
        val listOfPrizeLevel = listOf(
            PrizeLevel.NONE,
            PrizeLevel.FOURTH,
            PrizeLevel.NONE,
            PrizeLevel.FIRST,
            PrizeLevel.FIRST,
            PrizeLevel.SECOND
        )

        // when
        val actual = LottoMatchResult.countPrizeLevels(listOfPrizeLevel)
        val answer = mapOf(
            PrizeLevel.FIRST to 2,
            PrizeLevel.SECOND to 1,
            PrizeLevel.FOURTH to 1
        )

        // then
        Assertions.assertThat(actual).isEqualTo(answer)
    }
}
