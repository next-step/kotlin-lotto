package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoPrizeTest : StringSpec({
    "로또 수익률 계산 테스트" {
        forAll(
            row(listOf(WinLottoPrize.FOURTH, WinLottoPrize.THIRD), 100000, 0.55),
            row(listOf(WinLottoPrize.FOURTH), 5000, 1.0),
            row(listOf(WinLottoPrize.THIRD), 5000, 10),
        ) { prizeList, payment, expectedEarningRate ->
            // given
            val lottoReward = LottoReward(prizeList)
            // when
            val actualEarningRate = lottoReward.earningRate(payment)
            // then
            actualEarningRate shouldBe expectedEarningRate
        }
    }
})
