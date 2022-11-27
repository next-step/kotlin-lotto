package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.equality.shouldBeEqualToComparingFields
import io.kotest.matchers.shouldBe

class LottoStatisticsTest : StringSpec({

    "당첨자 통계 결과 테스트" {
        // given
        val payment = 15000
        forAll(
            row(
                WinLottoPrize.FOURTH,
                listOf(
                    LottoStatisticsResult(WinLottoPrize.FIRST, 0),
                    LottoStatisticsResult(WinLottoPrize.SECOND, 0),
                    LottoStatisticsResult(WinLottoPrize.THIRD, 0),
                    LottoStatisticsResult(WinLottoPrize.FOURTH, 1),
                )
            ),
            row(
                WinLottoPrize.FIRST,
                listOf(
                    LottoStatisticsResult(WinLottoPrize.FIRST, 1),
                    LottoStatisticsResult(WinLottoPrize.SECOND, 0),
                    LottoStatisticsResult(WinLottoPrize.THIRD, 0),
                    LottoStatisticsResult(WinLottoPrize.FOURTH, 0),
                )
            )
        ) { lottoResult, expected ->
            val result = LottoStatistics.statistics(payment, listOf(lottoResult))
            val actualWinLottoStatisticsResult = result.winLottoStatisticsResult
            // when
            actualWinLottoStatisticsResult.size shouldBe expected.size
            // then
            actualWinLottoStatisticsResult.forEachIndexed { index, lottoStatisticsResult ->
                lottoStatisticsResult shouldBeEqualToComparingFields expected[index]
            }
        }
    }
})
