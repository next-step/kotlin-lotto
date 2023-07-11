package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class RanksTest : FunSpec({
    context("총 수익금을 계산한다.") {
        withData(
            Ranks(
                listOf(
                    Rank.MISS,
                    Rank.MISS,
                    Rank.MISS,
                    Rank.FIFTH,
                    Rank.FOURTH,
                    Rank.THIRD,
                    Rank.FIRST,
                    Rank.FIRST,
                ),
            ) to 4_001_555_000L,
            Ranks(
                listOf(
                    Rank.MISS,
                    Rank.MISS,
                    Rank.MISS,
                    Rank.FIFTH,
                ),
            ) to 5000L,
        ) { (ranks, expectedTotalPrizeMoney) ->
            ranks.calculateTotalPrizeMoney() shouldBe expectedTotalPrizeMoney
        }
    }
})
