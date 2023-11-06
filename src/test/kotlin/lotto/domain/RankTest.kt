package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class RankTest : BehaviorSpec({

    Given("일치 하는 숫자가 주어지면") {
        When("Rank 는") {
            Then("일치하는 숫자에 매칭하는 로또 등수를 반한다.") {
                forAll(
                    row(6, false, Rank.FIRST),
                    row(5, true, Rank.SECOND),
                    row(5, false, Rank.THREE),
                    row(4, true, Rank.FOURTH),
                    row(4, false, Rank.FOURTH),
                    row(3, true, Rank.FIFTH),
                    row(3, false, Rank.FIFTH),
                    row(2, true, Rank.OUT_OF_RANK),
                    row(2, false, Rank.OUT_OF_RANK),
                ) { matchCount, matchBonus, expected ->
                    Rank.from(matchCount, matchBonus) shouldBe expected
                }
            }
        }
    }
})
