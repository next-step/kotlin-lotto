package lotto.step4

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.step4.domain.LottoProfitManager
import lotto.step4.domain.LottoPurchaseManager.Companion.LOTTO_PRICE
import lotto.step4.domain.Rank

class LottoProfitManagerTest : FunSpec({
    test("로또 수익률을 계산한다.") {
        // given
        val givenRankMap =
            mutableMapOf<Rank, Long>()
                .also { map ->
                    map[Rank.FIRST] = 0
                    map[Rank.SECOND] = 0
                    map[Rank.THIRD] = 1
                    map[Rank.FOURTH] = 0
                    map[Rank.FIFTH] = 1
                    map[Rank.MISS] = 15
                }

        // when
        val result = LottoProfitManager.computeProfit(rankMap = givenRankMap)

        // then
        val totalPurchaseAmount = LOTTO_PRICE.multiply(givenRankMap.values.sum())
        val totalWinningAmount =
            givenRankMap.entries.sumOf { (rank, count) ->
                rank.winningAmount.value * count
            }
        result shouldBe (totalWinningAmount.toDouble() / totalPurchaseAmount.value)
    }
})
