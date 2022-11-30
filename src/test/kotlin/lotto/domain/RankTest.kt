package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

internal class RankTest : BehaviorSpec({

    given("구입한 로또와 당첨번호의") {
        `when`("보너스 숫자가 일치할 때") {
            val isBonusMatch = true

            and("5개의 수가 일치한다면") {
                val numberOfMatch = 5

                then("2등이다.") {
                    val result = Rank.valueOf(numberOfMatch, isBonusMatch)
                    result shouldBe Rank.SECOND
                }
            }

            and("4개의 수가 일치한다면") {
                val numberOfMatch = 4

                then("4등이다.") {
                    val result = Rank.valueOf(numberOfMatch, isBonusMatch)
                    result shouldBe Rank.FOURTH
                }
            }
        }

        `when`("보너스 숫자가 일치하지 않을 때") {
            val isBonusMatch = false

            and("2개 이하의 수가 일치한다면") {
                val numberOfMatches = listOf(0, 1, 2)
                numberOfMatches.forAll {

                    then("꽝이다.") {
                        val result = Rank.valueOf(it, isBonusMatch)
                        result shouldBe Rank.MISS
                    }
                }
            }
            and("3개의 수가 일치한다면 ") {
                val numberOfMatch = 3

                then("5등이다.") {
                    val result = Rank.valueOf(numberOfMatch, isBonusMatch)
                    result shouldBe Rank.FIFTH
                }
            }
            and("4개의 수가 일치한다면 ") {
                val numberOfMatch = 4

                then("4등이다.") {
                    val result = Rank.valueOf(numberOfMatch, isBonusMatch)
                    result shouldBe Rank.FOURTH
                }
            }
            and("5개의 수가 일치한다면 ") {
                val numberOfMatch = 5

                then("3등이다.") {
                    val result = Rank.valueOf(numberOfMatch, isBonusMatch)
                    result shouldBe Rank.THIRD
                }
            }
            and("6개의 수가 일치한다면") {
                val numberOfMatch = 6

                then("1등이다.") {
                    val result = Rank.valueOf(numberOfMatch, isBonusMatch)
                    result shouldBe Rank.FIRST
                }
            }
        }
    }
})
