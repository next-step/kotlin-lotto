package lotto.step3

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.step3.domain.LottoProfitManager
import lotto.step3.domain.LottoPurchaseManager.Companion.LOTTO_PRICE
import lotto.step3.domain.Rank

class LottoProfitManagerTest : FunSpec({
    test("로또 수익률을 계산한다.") {
        // given
        val givenRankMap =
            mutableMapOf<Rank, Int>()
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
        val totalPurchaseAmount = givenRankMap.values.sum() * LOTTO_PRICE
        val totalWinningAmount =
            givenRankMap.entries.sumOf { (rank, count) ->
                rank.winningAmount * count
            }
        result shouldBe (totalWinningAmount.toDouble() / totalPurchaseAmount)
    }
})
