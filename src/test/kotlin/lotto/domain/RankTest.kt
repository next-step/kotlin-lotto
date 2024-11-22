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
            row(Rank.MISS, 10, BigDecimal(0)),
        ) { rank, count, expectedPrize ->
            When("매칭된 로또가 ${count}개이고 Rank가 ${rank}일 경우") {
                val totalPrize = rank.totalPrize(count)

                Then("총 상금은 ${expectedPrize}원이 계산된다") {
                    totalPrize shouldBe expectedPrize
                }
            }
        }
    }
    Given("매칭된 숫자에 따라 Rank를 판별할 때") {
        forAll(
            row(6, Rank.SIX),
            row(5, Rank.FIVE),
            row(4, Rank.FOUR),
            row(3, Rank.THREE),
            row(2, Rank.MISS),
            row(0, Rank.MISS),
        ) { matchCount, expectedRank ->
            When("${matchCount}개의 숫자가 매칭되었을 경우") {
                val rank = Rank.from(matchCount)

                Then("Rank는 ${expectedRank}가 반환된다") {
                    rank shouldBe expectedRank
                }
            }
        }
    }
})
