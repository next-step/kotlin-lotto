package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoPrizeTest : StringSpec({
    "로또 수익률 계산 테스트" {
        forAll(
            row(listOf(123), 1000, 0.12),
            row(listOf(500, 500), 10000, 0.1),
            row(listOf(10000, 10000, 10000), 8000, 3.75),
        ) { prizeList, payment, expectedEarningRate ->
            // given
            val lottoPrize = LottoPrize(prizeList)
            // when
            val actualEarningRate = lottoPrize.earningRate(payment)
            // then
            actualEarningRate shouldBe expectedEarningRate
        }
    }
})
