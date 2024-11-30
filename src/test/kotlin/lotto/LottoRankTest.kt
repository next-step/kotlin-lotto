package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoRankTest : FreeSpec({
    "from 테스트" - {
        "matchCount에 맞는 LottoRank를 반환한다" - {
            mapOf(
                6 to LottoRank.FIRST,
                5 to LottoRank.SECOND,
                4 to LottoRank.THIRD,
                3 to LottoRank.FORTH,
            ).forEach { (matchCount, expectedRank) ->
                "입력값: $matchCount, expectedRank: $expectedRank" {
                    LottoRank.from(matchCount) shouldBe expectedRank
                }
            }
        }

        "일치하는 matchCount가 없으면 예외를 발생시킨다" - {
            listOf(2, 7)
                .forEach { matchCount ->
                    "입력값: $matchCount" {
                        shouldThrow<InvalidMatchCountException> { LottoRank.from(matchCount) }
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