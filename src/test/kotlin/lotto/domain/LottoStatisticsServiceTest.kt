package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.equality.shouldBeEqualToComparingFields
import io.kotest.matchers.shouldBe
import lotto.application.common.Number

class LottoStatisticsServiceTest : StringSpec({

    "당첨자 통계 통합 결과 테스트" {
        // given
        val payment = Payment(Number(15000))
        forAll(
            row(
                LottoRank.FOURTH,
                listOf(
                    LottoStatisticsResult(LottoRank.FIFTH, Number(0)),
                    LottoStatisticsResult(LottoRank.FOURTH, Number(1)),
                    LottoStatisticsResult(LottoRank.THIRD, Number(0)),
                    LottoStatisticsResult(LottoRank.SECOND, Number(0)),
                    LottoStatisticsResult(LottoRank.FIRST, Number(0)),
                )
            ),
            row(
                LottoRank.FIRST,
                listOf(
                    LottoStatisticsResult(LottoRank.FIFTH, Number(0)),
                    LottoStatisticsResult(LottoRank.FOURTH, Number(0)),
                    LottoStatisticsResult(LottoRank.THIRD, Number(0)),
                    LottoStatisticsResult(LottoRank.SECOND, Number(0)),
                    LottoStatisticsResult(LottoRank.FIRST, Number(1)),
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
