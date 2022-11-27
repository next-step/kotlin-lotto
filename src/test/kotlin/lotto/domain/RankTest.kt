package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
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

        `when`("보너스 숫자가 일치하지만 4개 이하의 개수가 일치한다면") {
            val numberOfMatches = listOf(3, 4)
            val isBonusMatch = true

            numberOfMatches.forAll {
                val result = Rank.valueOf(it, isBonusMatch)

                then("4등 이하 당첨이다.") {
                    val ranks = listOf(Rank.FOURTH, Rank.FIFTH)
                    ranks.contains(result) shouldBe true
                }
            }
        }

        `when`("2개 이하의 수가 일치하거나 아무 숫자도 일치하지 않는다면") {
            val numberOfMatches = listOf(2, 1, 0)

            numberOfMatches.forAll {
                val result = Rank.valueOf(it, false)
                then("아무 등수도 당첨되지 않는다.") {
                    result shouldBe Rank.MISS
                }
            }
        }
    }
})
