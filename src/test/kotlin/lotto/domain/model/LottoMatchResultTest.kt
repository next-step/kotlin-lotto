package lotto.domain.model

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoMatchResultTest : BehaviorSpec({
    given("로또 구매 금액과 당첨 통계가 주어지고") {
        val cash = LottoCash(14000)
        val rankList = listOf(
            Rank.FIFTH,
        )
        `when`("결과를 계산하면") {
            val result = LottoMatchResult(cash, rankList)
            then("3개 일치한 개수는 1이다.") {
                val matchCount = 3
                result.count(Rank.valueOf(matchCount)) shouldBe 1
            }
            then("4개 일치한 개수는 0이다.") {
                val matchCount = 4
                result.count(Rank.valueOf(matchCount)) shouldBe 0
            }
            then("5개 일치한 개수는 0이다.") {
                val matchCount = 5
                result.count(Rank.valueOf(matchCount)) shouldBe 0
            }
            then("6개 일치한 개수는 0이다.") {
                val matchCount = 6
                result.count(Rank.valueOf(matchCount)) shouldBe 0
            }
            then("총 수익률은 0.36이다.") {
                String.format("%.2f", result.totalReturnRatio) shouldBe "0.36"
            }
        }
    }
})
