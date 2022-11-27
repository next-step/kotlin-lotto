package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

internal class RankTest : StringSpec({
    "일치 갯수에 따라 수익률 계산 하다." {
        val matchReward = mapOf(
            Reward.FIVE_PLACE to 1,
            Reward.FOURTH_PLACE to 0,
            Reward.THIRD_PLACE to 0,
            Reward.FIST_PLACE to 0,
        )
        val rank = Rank(matchReward)

        forAll(
            row(14, 0.36),
            row(10, 0.5),
        ) { purchaseCount, incomeRate ->
            val actualIncomeRate = rank.getIncomeRate(purchaseCount)

            val formattedActual = String.format("%.2f", actualIncomeRate)
            val formattedExpect = String.format("%.2f", incomeRate)

            formattedActual shouldBe formattedExpect
        }
    }
})
