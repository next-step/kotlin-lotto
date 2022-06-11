package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoResultTest : StringSpec({
    "수익률을 계산한다" {
        // given
        val purchasedMoney = PurchasedMoney(5_000)
        val lottoResult = LottoResult(
            mapOf(
                Rank.FIRST to 0,
                Rank.SECOND to 0,
                Rank.THIRD to 1,
                Rank.FOURTH to 1,
            )
        )

        // when
        val actual = lottoResult.calculateEarningRate(purchasedMoney)

        // then
        actual shouldBe 11.00
    }
})
