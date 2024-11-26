package lotto

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe

class RankTest : BehaviorSpec({
    Given("당첨은 일치갯수와 추가번호 일치여부로 판단한다") {
        listOf(
            6 to (false to Rank.FIRST),
            6 to (true to Rank.FIRST),
            5 to (false to Rank.THIRD),
            4 to (false to Rank.FOURTH),
            3 to (false to Rank.FIFTH),
        ).forEach { (matchCount, bonusAndExpected) ->
            When("당첨번호가 $matchCount 개 이고 추가번호 일치가 ${bonusAndExpected.first}일 때") {
                val rank = Rank.match(matchCount, bonusAndExpected.first)
                Then("결과는 ${bonusAndExpected.second}이어야 한다") {
                    rank shouldBe bonusAndExpected.second
                }
            }
        }
    }

    Given("2등은 보너스번호를 추가 확인한다") {
        listOf(
            5 to (true to Rank.SECOND),
            5 to (false to Rank.THIRD),
        ).forEach { (matchCount, bonusAndExpected) ->
            val (isBonus, expected) = bonusAndExpected
            When("당첨번호가 $matchCount 개이고 추가번호가 $isBonus 일 때") {
                val rank = Rank.match(matchCount, isBonus)
                Then("결과는 $expected 이어야 한다") {
                    rank shouldBe expected
                }
            }
        }
    }

    Given("2등은 추가번호가 있다") {
        val rank = Rank.SECOND

        rank.isBonus.shouldBeTrue()
    }

    Given("prizeRanks 상금목록을 알 수 있다") {
        val prizeRanks = Rank.prizeRanks

        prizeRanks.shouldContainAll(
            Rank.FIRST,
            Rank.SECOND,
            Rank.THIRD,
            Rank.FOURTH,
            Rank.FIFTH,
        )
    }
})
