package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import java.math.BigDecimal

class RankTest : BehaviorSpec({
    Given("Rank에 따라 총 상금을 계산할 때") {
        forAll(
            row(Rank.FIVE, 2, BigDecimal(3_000_000)),
            row(Rank.FOUR, 3, BigDecimal(150_000)),
            row(Rank.SIX, 0, BigDecimal(0)),
            row(Rank.THREE, 5, BigDecimal(25_000)),
        ) { rank, count, expectedPrize ->
            When("매칭된 로또가 ${count}개이고 Rank가 ${rank}일 경우") {
                val totalPrize = rank.totalPrize(count)

                Then("총 상금은 ${expectedPrize}원이 계산된다") {
                    totalPrize shouldBe expectedPrize
                }
            }
        }
    }
})
