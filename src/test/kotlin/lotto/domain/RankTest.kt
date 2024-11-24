package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import java.math.BigDecimal

class RankTest : BehaviorSpec({
    Given("Rank에 따라 총 상금을 계산할 때") {
        forAll(
            row(Rank.THIRD, 2, BigDecimal(3_000_000)),
            row(Rank.FOURTH, 3, BigDecimal(150_000)),
            row(Rank.FIRST, 0, BigDecimal(0)),
            row(Rank.FIFTH, 5, BigDecimal(25_000)),
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
            row(6, false, Rank.FIRST),
            row(6, true, Rank.FIRST),
            row(5, true, Rank.SECOND),
            row(5, false, Rank.THIRD),
            row(4, false, Rank.FOURTH),
            row(4, true, Rank.FOURTH),
            row(3, false, Rank.FIFTH),
            row(3, true, Rank.FIFTH),
            row(2, false, Rank.MISS),
            row(2, true, Rank.MISS),
            row(1, false, Rank.MISS),
            row(1, true, Rank.MISS),
            row(0, false, Rank.MISS),
            row(0, true, Rank.MISS),
        ) { matchCount, matchBonus, expectedRank ->
            When("${matchCount}개의 숫자가 매칭되고 보너스 번호 매칭 결과가 ${matchBonus}인 경우") {
                val rank = Rank.from(matchCount, matchBonus)

                Then("Rank는 ${expectedRank}가 반환된다") {
                    rank shouldBe expectedRank
                }
            }
        }
    }
})
