package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

/**
 * @see LottoRewardCash
 */
class LottoRewardCashTest : FunSpec({

    context("fun calculateYield()") {
        val inputCash = Cash(1000)
        val lottoRewardCash = LottoRewardCash(5000)

        test("수익률을 계산한다.") {
            lottoRewardCash.calculateYield(inputCash) shouldBe 5L
        }
    }
})
