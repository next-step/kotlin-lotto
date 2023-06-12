package lottery

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class RankTest : FunSpec({

    context("from") {
        forAll(
            row(0, Rank.NOTHING),
            row(1, Rank.NOTHING),
            row(2, Rank.NOTHING),
            row(3, Rank.FOURTH),
            row(4, Rank.THIRD),
            row(5, Rank.SECOND),
            row(6, Rank.FIRST)
        ) { input, expected ->
            test("$input 가 matchCount인 경우 rank가 $expected 된다") {
                val actual = Rank.from(input)
                actual shouldBe expected
            }
        }
    }
})
