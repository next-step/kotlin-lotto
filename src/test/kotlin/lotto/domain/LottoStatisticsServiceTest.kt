package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.equality.shouldBeEqualToComparingFields
import io.kotest.matchers.shouldBe

class LottoStatisticsServiceTest : StringSpec({

    "당첨자 통계 통합 결과 테스트" {
        // given
        val payment = Payment(15000)
        forAll(
            row(
                LottoRank.FOURTH,
                listOf(
                    LottoStatisticsResult(LottoRank.FIFTH, 0),
                    LottoStatisticsResult(LottoRank.FOURTH, 1),
                    LottoStatisticsResult(LottoRank.THIRD, 0),
                    LottoStatisticsResult(LottoRank.SECOND, 0),
                    LottoStatisticsResult(LottoRank.FIRST, 0),
                )
            ),
            row(
                LottoRank.FIRST,
                listOf(
                    LottoStatisticsResult(LottoRank.FIFTH, 0),
                    LottoStatisticsResult(LottoRank.FOURTH, 0),
                    LottoStatisticsResult(LottoRank.THIRD, 0),
                    LottoStatisticsResult(LottoRank.SECOND, 0),
                    LottoStatisticsResult(LottoRank.FIRST, 1),
                )
            )
        ) { lottoResult, expected ->
            val lottoStatisticsService = LottoStatisticsService(payment, listOf(lottoResult))
            val result = lottoStatisticsService.statistics()
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
