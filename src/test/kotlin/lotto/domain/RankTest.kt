package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

internal class RankTest : BehaviorSpec({
    given("로또를 구매했을 때") {
        `when`("5개의 수가 일치하고 보너스 숫자까지 일치한다면") {
            val numberOfMatch = 5
            val isBonusMatch = true
            val result = Rank.valueOf(numberOfMatch, isBonusMatch)

            then("2등 당첨이다.") {
                result shouldBe Rank.SECOND
            }
        }
    }
})
