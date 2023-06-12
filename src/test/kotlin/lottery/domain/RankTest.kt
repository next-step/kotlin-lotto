package lottery.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import lottery.domain.Rank.Companion.fillMissRankWithDefault
import lottery.domain.Rank.FIRST
import lottery.domain.Rank.FOURTH
import lottery.domain.Rank.NOTHING
import lottery.domain.Rank.SECOND
import lottery.domain.Rank.THIRD
import java.lang.IllegalArgumentException

class RankTest : FunSpec({

    context("from") {
        forAll(
            row(0, NOTHING),
            row(1, NOTHING),
            row(2, NOTHING),
            row(3, FOURTH),
            row(4, THIRD),
            row(5, SECOND),
            row(6, FIRST)
        ) { input, expected ->
            test("$input 가 matchCount인 경우 rank가 $expected 된다") {
                val actual = Rank.from(input)
                actual shouldBe expected
            }
        }

        forAll(
            row(-1),
            row(7)
        ) { input ->
            test("룰에서 벗어난 값 $input 이 입력되는 경우 예외가 발생한다.") {
                val exception = shouldThrowExactly<IllegalArgumentException> { Rank.from(input) }
                exception.message shouldBe "로또 룰에 벗어난 수는 입력될 수 없다"
            }
        }
    }

    context("calculatePrice") {
        test("갯수를 받아 총 수익을 계산한다") {
            val actual = THIRD.calculatePrice(2)
            actual shouldBe 100_000
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
