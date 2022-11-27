package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoStatisticsTest : StringSpec({
    "로또 수익률 계산 테스트" {
        forAll(
            row(listOf(WinLottoPrize.FOURTH, WinLottoPrize.THIRD), 100000, 0.55),
            row(listOf(WinLottoPrize.FOURTH), 5000, 1.0),
            row(listOf(WinLottoPrize.THIRD), 5000, 10),
        ) { prizeList, payment, expectedEarningRate ->
            // given
            val lottoStatistics = LottoStatistics(prizeList)
            // when
            val actualEarningRate = lottoStatistics.earningRate(payment)
            // then
            actualEarningRate shouldBe expectedEarningRate
        }
    }

    "로또 당첨 통계 테스트" {
        // given
        val winLottoList = listOf(
            WinLottoPrize.THIRD,
            WinLottoPrize.THIRD,
            WinLottoPrize.FIRST,
        )
        val lottoStatistics = LottoStatistics(winLottoList)

        val expected = listOf(
            LottoStatisticsResult(WinLottoPrize.FIRST, 1),
            LottoStatisticsResult(WinLottoPrize.SECOND, 0),
            LottoStatisticsResult(WinLottoPrize.THIRD, 2),
            LottoStatisticsResult(WinLottoPrize.FOURTH, 0)
        )

        // when
        val actual = lottoStatistics.winLottoStatistics()

        // then
        actual.size shouldBe expected.size
        actual.forEachIndexed { index, result ->
            result.winLottoCount shouldBe expected[index].winLottoCount
            result.winLottoPrize shouldBe expected[index].winLottoPrize
        }
    }
})
