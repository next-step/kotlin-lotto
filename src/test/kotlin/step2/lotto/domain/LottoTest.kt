package step2.lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import step2.lotto.domain.MatchResult.FIRST_PLACE
import step2.lotto.domain.MatchResult.FOURTH_PLACE
import step2.lotto.domain.MatchResult.NOT_WINNING
import step2.lotto.domain.MatchResult.SECOND_PLACE
import step2.lotto.domain.MatchResult.THIRD_PLACE

internal class LottoTest : StringSpec({
    "당첨 번호와 비교하여 당첨 결과를 반환한다." {
        val given = Lotto.of(setOf(1, 2, 3, 4, 5, 6))
        winningNumber.forAll { (winningNumber: WinningNumber, expected: MatchResult) ->
            val actual = given.match(winningNumber)
            actual shouldBe expected
        }
    }

    "중복된 번호가 포함되는 경우 예외가 발생한다." {
        shouldThrow<IllegalArgumentException> {
            Lotto.of(setOf(1, 1, 1, 1, 1, 1))
        }
    }
}) {
    companion object {
        val winningNumber = listOf(
            WinningNumber.of(listOf(1, 2, 3, 4, 5, 6)) to FIRST_PLACE,
            WinningNumber.of(listOf(1, 2, 3, 4, 5, 7)) to SECOND_PLACE,
            WinningNumber.of(listOf(1, 2, 3, 4, 7, 8)) to THIRD_PLACE,
            WinningNumber.of(listOf(1, 2, 3, 7, 8, 9)) to FOURTH_PLACE,
            WinningNumber.of(listOf(1, 2, 7, 8, 9, 10)) to NOT_WINNING,
            WinningNumber.of(listOf(1, 7, 8, 9, 10, 11)) to NOT_WINNING,
            WinningNumber.of(listOf(7, 8, 9, 10, 11, 12)) to NOT_WINNING,
        )
    }
}
