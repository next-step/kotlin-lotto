package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

internal class StatisticalResultExtractorTest : BehaviorSpec({
    Given("로또 당첨 개수가 ") {
        val lottoWinning = LottoWinning(mapOf(3 to 4))
        val statisticalResultExtractor = StatisticalResultExtractor(lottoWinning)
        When("하나 이상 존재한다면, ") {
            val matchCount = statisticalResultExtractor.getMatchCount(3)
            Then("몇개의 티켓이 존재하는지 가져온다.") {
                matchCount shouldBe 4
            }
        }

        When("하나도 존재하지 않는다면") {
            val matchCount = statisticalResultExtractor.getMatchCount(6)
            Then("0을 리턴한다.") {
                matchCount shouldBe 0
            }
        }
    }

    Given("로또의") {
        val lottoWinning = LottoWinning(mapOf(3 to 2))
        val statisticalResultExtractor = StatisticalResultExtractor(lottoWinning)
        When("당첨 금액에 따른") {
            val totalRateOfReturn = statisticalResultExtractor.getTotalRateOfReturn(20)
            Then("수익률을 계산할 수 있다.") {
                totalRateOfReturn shouldBe 0.5
            }
        }
    }
})
