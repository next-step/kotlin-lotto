package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class ResultTest : StringSpec({
    "당첨 결과를 계산한다" {
        forAll(
            row(6, Result.FIRST, 2_000_000_000),
            row(5, Result.SECOND, 15_000_000),
            row(4, Result.THIRD, 50_000),
            row(3, Result.FOURTH, 5_000),
            row(2, Result.MISS, 0),
            row(1, Result.MISS, 0),
            row(0, Result.MISS, 0),
        ) { count, result, prize ->
            Result.of(count) shouldBe result
            result.prize shouldBe prize
        }
    }

    "당첨 결과에 대응하는 숫자가 없으면 IllegalArgumentException이 발생한다" {
        forAll(
            row(7),
            row(8),
            row(9),
        ) { count ->
            shouldThrow<IllegalArgumentException> {
                Result.of(count)
            }
        }
    }
})
