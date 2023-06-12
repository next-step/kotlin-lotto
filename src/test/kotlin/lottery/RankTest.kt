package lottery

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

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
})
