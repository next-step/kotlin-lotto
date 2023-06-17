package lottery.domain.lottery.rank

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import lottery.domain.rank.Rank
import lottery.domain.rank.Rank.Companion.fillMissRankWithDefault
import lottery.domain.rank.Rank.FIFTH
import lottery.domain.rank.Rank.FIRST
import lottery.domain.rank.Rank.FOURTH
import lottery.domain.rank.Rank.NOTHING
import lottery.domain.rank.Rank.SECOND
import lottery.domain.rank.Rank.THIRD
import java.lang.IllegalArgumentException

class RankTest : FunSpec({

    context("of") {
        forAll(
            row(0, true, NOTHING),
            row(1, true, NOTHING),
            row(2, true, NOTHING),
            row(3, true, FIFTH),
            row(4, true, FOURTH),
            row(5, false, THIRD),
            row(5, true, SECOND),
            row(6, true, FIRST)
        ) { matchCount, isBonus, expected ->
            test("matchCount($matchCount), isBonus($isBonus)인 경우 rank가 $expected 된다") {
                val actual = Rank.of(matchCount = matchCount, isBonus = isBonus)
                actual shouldBe expected
            }
        }

        forAll(
            row(-1),
            row(7)
        ) { input ->
            test("룰에서 벗어난 값 $input 이 입력되는 경우 예외가 발생한다.") {
                val exception = shouldThrowExactly<IllegalArgumentException> {
                    Rank.of(
                        matchCount = input,
                        isBonus = true
                    )
                }
                exception.message shouldBe "로또 룰에 벗어난 수는 입력될 수 없다"
            }
        }
    }

    context("calculatePrice") {
        test("갯수를 받아 총 수익을 계산한다") {
            val actual = THIRD.calculatePrice(count = 2)
            actual shouldBe 3_000_000
        }
    }

    context("fillMissRankWithDefault") {
        test("Rank의 value가 없는 것은 0으로 채워 반환한다") {
            val ranks = mapOf(NOTHING to 1, FOURTH to 1, SECOND to 1)

            val actual = ranks.fillMissRankWithDefault()
            actual[THIRD] shouldBe 0
            actual[FIRST] shouldBe 0
        }
    }
})
