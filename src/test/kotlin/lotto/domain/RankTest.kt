package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

internal class RankTest : BehaviorSpec({
    given("fromOfNull() 함수에") {
        `when`("numberOfMatch 에 있는 수를 인자로 넣으면") {
            val numberOfMatch = 3
            val result = Rank.fromOrNull(numberOfMatch)

            then("랭크(등수) 정보를 반환한다.") {
                result shouldBe Rank.FOURTH
            }
        }

        `when`("numberOfMatch 에 없는 수를 인자로 넣으면") {
            val numberOfMatch = 1
            val result = Rank.fromOrNull(numberOfMatch)

            then("Null 을 반환한다.") {
                result shouldBe null
            }
        }
    }
})
