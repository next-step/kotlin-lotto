package lotto

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class RankTest : BehaviorSpec({
    Given("3개가 맞으면") {
        When("수행") {
            val rank = Rank.valueOf(3)
            Then("5등이 나와야함.") {
                rank shouldBe Rank.FIFTH
            }
        }
    }

    Given("2개가 맞으면") {
        When("수행") {
            val rank = Rank.valueOf(2)
            Then("미스가 나와야함.") {
                rank shouldBe Rank.MISS
            }
        }
    }
})
