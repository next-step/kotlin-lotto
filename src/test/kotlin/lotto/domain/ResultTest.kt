package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class ResultTest : StringSpec({
    "당첨 결과를 계산한다" {
        forAll(
            row(6, false, Result.FIRST, Money(2_000_000_000)),
            row(5, true, Result.SECOND, Money(30_000_000)),
            row(5, false, Result.THIRD, Money(1_500_000)),
            row(4, false, Result.FOURTH, Money(50_000)),
            row(3, false, Result.FIFTH, Money(5_000)),
            row(2, false, Result.MISS, Money(0)),
        ) { count, isBonus, result, prize ->
            Result.of(count, isBonus) shouldBe result
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
