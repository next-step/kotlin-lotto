package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.equality.shouldBeEqualToComparingFields
import io.kotest.matchers.shouldBe
import lotto.common.IntegerNumber

class LottoStatisticsServiceTest : StringSpec({

    "당첨자 통계 통합 결과 테스트" {
        // given
        val payment = Payment(IntegerNumber(15000))
        forAll(
            row(
                LottoRank.FOURTH,
                listOf(
                    LottoStatisticsResult(LottoRank.FIFTH, IntegerNumber(0)),
                    LottoStatisticsResult(LottoRank.FOURTH, IntegerNumber(1)),
                    LottoStatisticsResult(LottoRank.THIRD, IntegerNumber(0)),
                    LottoStatisticsResult(LottoRank.SECOND, IntegerNumber(0)),
                    LottoStatisticsResult(LottoRank.FIRST, IntegerNumber(0)),
                )
            ),
            row(
                LottoRank.FIRST,
                listOf(
                    LottoStatisticsResult(LottoRank.FIFTH, IntegerNumber(0)),
                    LottoStatisticsResult(LottoRank.FOURTH, IntegerNumber(0)),
                    LottoStatisticsResult(LottoRank.THIRD, IntegerNumber(0)),
                    LottoStatisticsResult(LottoRank.SECOND, IntegerNumber(0)),
                    LottoStatisticsResult(LottoRank.FIRST, IntegerNumber(1)),
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
