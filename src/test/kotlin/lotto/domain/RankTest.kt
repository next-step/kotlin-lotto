package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.row
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class RankTest : FunSpec({
    context("로또 등수를 확인한다.") {
        withData(
            row(6, false, Rank.FIRST),
            row(5, true, Rank.SECOND),
            row(5, false, Rank.THIRD),
            row(4, false, Rank.FOURTH),
            row(3, false, Rank.FIFTH),
            row(2, false, Rank.MISS),
        ) { (matchCount, matchBonus, expectedRank) ->
            val actual = Rank.of(matchCount, matchBonus)
            actual shouldBe expectedRank
        }
    }

    context("로또 일치 개수별 당첨금을 확인한다.") {
        withData(
            0 to 0,
            1 to 0,
            2 to 0,
            3 to 5_000,
            4 to 50_000,
            5 to 1_500_000,
            6 to 2_000_000_000,
        ) { (matchCount, expectedMoney) ->
            val money = Rank.of(matchCount, false).winningMoney
            money shouldBe expectedMoney
        }
    }

    context("로또가 5개 일치하고 보너스볼이 일치하면 상금이 30,000,000원이다.") {
        val money = Rank.of(5, true).winningMoney
        money shouldBe 30_000_000
    }
})
