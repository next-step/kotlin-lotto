package lotto2.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoRankingsTest : StringSpec({

    "당첨 통계는 총 당첨된 횟수만큼 계산되어 반환한다." {
        forAll(
            row(
                LottoRankings(
                    mapOf(
                        LottoRanking.FIRST to 1,
                        LottoRanking.SECOND to 2,
                        LottoRanking.THIRD to 3,
                        LottoRanking.FOURTH to 4,
                        LottoRanking.FIFTH to 5,
                        LottoRanking.MISS to 77
                    )
                )
            )
        ) { lottoRankings: LottoRankings ->
            val winningStatistics = lottoRankings.getWinningStatistics()

            winningStatistics.get(LottoRanking.FIRST) shouldBe 1
            winningStatistics.get(LottoRanking.SECOND) shouldBe 2
            winningStatistics.get(LottoRanking.THIRD) shouldBe 3
            winningStatistics.get(LottoRanking.FOURTH) shouldBe 4
            winningStatistics.get(LottoRanking.FIFTH) shouldBe 5
            winningStatistics.get(LottoRanking.MISS) shouldBe 77
        }
    }

    "당첨 통계는 한번도 당첨되지 않은 등수에는 0으로 반환한다." {
        forAll(
            row(
                LottoRankings(
                    mapOf(
                        LottoRanking.FIRST to 1,
                        LottoRanking.MISS to 77
                    )
                )
            )
        ) { lottoRankings: LottoRankings ->
            val winningStatistics = lottoRankings.getWinningStatistics()

            winningStatistics.get(LottoRanking.FIRST) shouldBe 1
            winningStatistics.get(LottoRanking.SECOND) shouldBe 0
            winningStatistics.get(LottoRanking.THIRD) shouldBe 0
            winningStatistics.get(LottoRanking.FOURTH) shouldBe 0
            winningStatistics.get(LottoRanking.FIFTH) shouldBe 0
            winningStatistics.get(LottoRanking.MISS) shouldBe 77
        }
    }

    "수익률 통계는 투자금액과 총 당첨금액을 비교하여 1을 기준으로 반환한다." {
        forAll(
            row(10000, LottoRankings(mapOf(LottoRanking.THIRD to 1, LottoRanking.MISS to 9)), 150.0),
            row(10000, LottoRankings(mapOf(LottoRanking.FOURTH to 1, LottoRanking.MISS to 9)), 5.0),
            row(10000, LottoRankings(mapOf(LottoRanking.FIFTH to 1, LottoRanking.MISS to 9)), 0.5),
            row(10000, LottoRankings(mapOf(LottoRanking.MISS to 10)), 0.0)
        ) { totalInvestment: Int, lottoRankings: LottoRankings, expect: Double ->
            val profitRate = lottoRankings.getProfitRate(totalInvestment)

            profitRate shouldBe expect
        }
    }
})
