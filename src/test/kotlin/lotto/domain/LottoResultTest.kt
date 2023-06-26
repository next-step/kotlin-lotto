package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoResultTest : FunSpec({
    context("결과에 대한 수익률을 계산해 반환한다.") {
        test("구매금액이 14000이고 5등에 당첨한 경우 수익률은 0.35이다.") {
            // given
            val lottoResult = LottoResult(mapOf(LottoRank.FIFTH to 1))
            val purchaseAmount = 14000
            val expected = 0.35

            // when
            val actual = lottoResult.calculateProfitRate(purchaseAmount)

            // then
            actual shouldBe expected
        }

        test("구매금액이 14000이고 4등에 당첨한 경우 수익률은 3.57이다.") {
            // given
            val lottoResult = LottoResult(mapOf(LottoRank.FOURTH to 1))
            val purchaseAmount = 14000
            val expected = 3.57

            // when
            val actual = lottoResult.calculateProfitRate(purchaseAmount)

            // then
            actual shouldBe expected
        }
    }
})
