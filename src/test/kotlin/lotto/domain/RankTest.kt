package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

internal class RankTest : BehaviorSpec({
    given("일치하는 개수가") {
        `when`("3개라면") {
            val numberOfMatch = 3
            val result = Rank.valueOf(numberOfMatch)

            then("4등을 반환한다.") {
                result shouldBe Rank.FOURTH
            }
        }

        `when`("등수에 없는 수라면") {
            val numberOfMatch = 1
            val result = Rank.valueOf(numberOfMatch)

            then("Null 을 반환한다.") {
                result shouldBe null
            }
        }
    }
})
