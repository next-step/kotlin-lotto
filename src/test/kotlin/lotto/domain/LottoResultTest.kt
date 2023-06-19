package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoResultTest : BehaviorSpec({
    given("3등, 3등, 미당첨, 4등의 경우") {
        val lottoRanks = listOf(LottoRank.THIRD, LottoRank.THIRD, LottoRank.NONE, LottoRank.FOURTH)
        val lottoResult = LottoResult(lottoRanks)

        `when`("로또 당첨 통계를 구하면") {
            val statistic = lottoResult.getLottoRankStatistic()
            then("3등 2개, 4등 1개, 미당첨 1개의 결과를 리턴한다.") {
                statistic[LottoRank.FIRST] shouldBe 0
                statistic[LottoRank.SECOND] shouldBe 0
                statistic[LottoRank.THIRD] shouldBe 2
                statistic[LottoRank.FOURTH] shouldBe 1
                statistic[LottoRank.NONE] shouldBe 1
            }
        }

        `when`("로또 당첨 수익률을 구하면") {
            val profitRate = lottoResult.getProfitRate(1000)
            then("수익률을 26.25를 리턴한다.") {
                profitRate shouldBe 26.25
            }
        }
    }
})
