package lotto.domain.model

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoMatchResultTest : BehaviorSpec({
    given("로또 구매 금액과 당첨 통계가 주어지고") {
        val cash = LottoCash(14000)
        val matchList = listOf(
            LottoMatchCount.THREE,
        )
        `when`("결과를 계산하면") {
            val result = LottoMatchResult(cash, matchList)
            then("3개 일치한 개수는 1이다.") {
                result.three shouldBe 1
            }
            then("4개 일치한 개수는 0이다.") {
                result.four shouldBe 0
            }
            then("5개 일치한 개수는 0이다.") {
                result.five shouldBe 0
            }
            then("6개 일치한 개수는 0이다.") {
                result.six shouldBe 0
            }
            then("총 수익률은 이다.") {
                result.totalReturnRatio shouldBe LottoMatchCount.THREE.reward / cash.value.toFloat()
            }
        }
    }
})
