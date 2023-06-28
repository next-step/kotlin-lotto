package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import lotto.domain.Rank

internal class RankTest : BehaviorSpec({

    Given("Rank") {
        When("matchCount가 0~6 사이가 아닐 경우") {
            val matchCounts = listOf(-1, 7, 10)
            Then("IllegalArgumentException 발생") {
                matchCounts.forAll { matchCount ->
                    shouldThrow<IllegalArgumentException> {
                        Rank.of(matchCount)
                    }
                }
            }
        }
    }
})
