package lotto.step4

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.doubles.shouldBeExactly
import io.kotest.matchers.maps.shouldContainExactly
import io.kotest.matchers.shouldBe
import lotto.step4.domain.LottoPurchaseManager.Companion.LOTTO_PRICE
import lotto.step4.domain.Rank
import lotto.step4.domain.Ranks

class RanksTest : FunSpec({
    // given
    val rankMap =
        mapOf(
            Rank.FIRST to 1L,
            Rank.SECOND to 2L,
            Rank.FOURTH to 3L,
        )
    val ranks = Ranks(rankMap)

    test("countOf는 특정 Rank에 대한 개수를 정확히 반환해야 한다") {
        // when, then
        ranks.countOf(Rank.FIRST) shouldBe 1L
        ranks.countOf(Rank.SECOND) shouldBe 2L
        ranks.countOf(Rank.FOURTH) shouldBe 3L
        ranks.countOf(Rank.THIRD) shouldBe 0L
        ranks.countOf(Rank.MISS) shouldBe 0L
    }

    test("asMap은 내부 rankMap을 정확히 반환해야 한다") {
        // when, then
        ranks.asMap() shouldContainExactly rankMap
    }

    test("profit은 총 수익률을 정확히 계산해야 한다") {
        // given
        val lottoPrice = LOTTO_PRICE
        val expectedTotalWinningAmount =
            Rank.FIRST.winningAmount.value * rankMap[Rank.FIRST]!! +
                Rank.SECOND.winningAmount.value * rankMap[Rank.SECOND]!! +
                Rank.FOURTH.winningAmount.value * rankMap[Rank.FOURTH]!!
        val expectedTotalPurchaseAmount = lottoPrice.multiply(6).value
        val expectedProfit = expectedTotalWinningAmount.toDouble() / expectedTotalPurchaseAmount

        // when, then
        ranks.profit() shouldBeExactly expectedProfit
    }
})
