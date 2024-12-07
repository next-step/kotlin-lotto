package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class LottoRankTest : FreeSpec({
    "from 테스트" - {
        "matchCount와 containsBonusNumber 값을 이용해 LottoRank를 결정한다" - {
            mapOf(
                Pair(6, false) to LottoRank.FIRST,
                Pair(5, true) to LottoRank.SECOND,
                Pair(5, false) to LottoRank.THIRD,
                Pair(4, true) to LottoRank.FORTH,
                Pair(3, true) to LottoRank.FIFTH,
            ).forEach { (conditionPair, expectedRank) ->
                val matchCount = conditionPair.first
                val containsBonusNumber = conditionPair.second

                "입력값: matchCount=$matchCount, containsBonusNumber=$containsBonusNumber, expectedRank: $expectedRank" {
                    LottoRank.determineRank(matchCount, containsBonusNumber) shouldBe expectedRank
                }
            }
        }

        "일치하는 조건이 아닌 경우 예외를 발생시킨다" - {
            listOf(
                Pair(0, false),
                Pair(0, true),
                Pair(2, true),
                Pair(2, false),
                Pair(7, true),
                Pair(7, false),
            ).forEach { (matchCount, containsBonusNumber) ->
                "입력값: matchCount=$matchCount, containsBonusNumber=$containsBonusNumber" {
                        shouldThrow<InvalidLottoRankConditionException> { LottoRank.determineRank(matchCount, true) }
                    }
                }
        }
    }

    "isInTheRank 테스트" - {
        "matchCount가 FORTH 이상 FIRST이하인 경우 true를 반환한다" - {
            listOf(4, 5, 6)
                .forEach { matchCount ->
                    "입력값: $matchCount" {
                        LottoRank.isInTheRank(matchCount) shouldBe true
                    }
                }
        }

        "matchCount가 FORTH 미만인 경우 false를 반환한다" - {
            listOf(0, 1, 2)
                .forEach { matchCount ->
                    "입력값: $matchCount" {
                        LottoRank.isInTheRank(matchCount) shouldBe false
                    }
                }
        }
    }
})
