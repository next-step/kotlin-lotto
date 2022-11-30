package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoResultTest : DescribeSpec ({
    describe("로또 추첨 결과 테스트") {
        it("결제금액과 추첨 결과만 있으면 수익률을 계산할 수 있다.") {
            val purchasePrice = 14000
            val matchesResult = listOf<Map<String, Int>>(
                mapOf("matchThreeNumbers" to 1),
                mapOf("matchFourNumbers" to 0),
                mapOf("matchFiveNumbers" to 0),
                mapOf("matchSixNumbers" to 0)
            )

            val lottoResult = LottoResult(purchasePrice, matchesResult)

            lottoResult.calculateReturnRate() shouldBe 0.35
        }
    }
})