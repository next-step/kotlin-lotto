package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import lotto.domain.MatchResult.FIFTH_PLACE
import lotto.domain.MatchResult.FIRST_PLACE
import lotto.domain.MatchResult.FOURTH_PLACE
import lotto.domain.MatchResult.NOT_WINNING
import lotto.domain.MatchResult.SECOND_PLACE
import lotto.domain.MatchResult.THIRD_PLACE

internal class LottoTest : StringSpec({
    "중복된 번호가 포함되는 경우 예외가 발생한다." {
        shouldThrow<IllegalArgumentException> {
            Lotto.of(setOf(1, 1, 1, 1, 1, 1))
        }
    }

    "당첨 번호와 비교하여 당첨 결과를 반환한다." {
        val bonusNumber = 45
        val winningLotto = setOf(1, 2, 3, 4, 5, 6)
        val winningNumber = WinningNumber.of(winningLotto, bonusNumber)

        lottos.forAll { (given: Lotto, expected: MatchResult) ->
            val actual = given.match(winningNumber)
            actual shouldBe expected
        }
    }
}) {
    companion object {
        val lottos = listOf(
            Lotto.of(setOf(1, 2, 3, 4, 5, 6)) to FIRST_PLACE,
            Lotto.of(setOf(1, 2, 3, 4, 5, 45)) to SECOND_PLACE,
            Lotto.of(setOf(1, 2, 3, 4, 5, 7)) to THIRD_PLACE,
            Lotto.of(setOf(1, 2, 3, 4, 7, 8)) to FOURTH_PLACE,
            Lotto.of(setOf(1, 2, 3, 7, 8, 9)) to FIFTH_PLACE,
            Lotto.of(setOf(1, 2, 7, 8, 9, 10)) to NOT_WINNING,
            Lotto.of(setOf(1, 7, 8, 9, 10, 11)) to NOT_WINNING,
            Lotto.of(setOf(7, 8, 9, 10, 11, 12)) to NOT_WINNING,
        )
    }
}
