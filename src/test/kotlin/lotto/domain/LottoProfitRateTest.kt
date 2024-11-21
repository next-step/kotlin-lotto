package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoProfitRateTest : StringSpec({
    "수익률은 당첨금 / 구입 금액으로 계산한 값을 소수점 셋째 자리에서 버린다." {
        forAll(
            row(5_000, 2_000, 2.5),
            row(50_000, 3_000, 16.66),
            row(150_000, 7_000, 21.42),
            row(1_500_000, 13_000, 115.38),
        ) { purchasePrice, prize, expected ->
            val lottoProfitRate = LottoProfitRate(purchasePrice, LottoPurchaseAmount(prize))
            lottoProfitRate.rate shouldBe expected
        }
    }
})
