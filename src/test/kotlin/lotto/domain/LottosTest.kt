package lotto.domain

import io.kotest.core.spec.style.StringSpec
import lotto.domain.MatchResult.FIRST_PLACE
import lotto.domain.MatchResult.FOURTH_PLACE
import lotto.domain.MatchResult.NOT_WINNING
import lotto.domain.MatchResult.SECOND_PLACE
import lotto.domain.MatchResult.THIRD_PLACE
import lotto.fixture.LottoFixtureGenerator.winningNumberFixture

internal class LottosTest : StringSpec({
    "전체 로또와 당첨 번호를 비교하여 당첨 결과 목록을 반환한다." {
        val bonusNumber = 7
        val winningNumber: WinningNumber = winningNumberFixture(bonusNumber, 1, 2, 3, 4, 5, 6)
        val actual = lottos.match(winningNumber)

        actual.elements.containsAll(listOf(FIRST_PLACE, SECOND_PLACE, THIRD_PLACE, FOURTH_PLACE, NOT_WINNING))
    }
}) {
    companion object {
        val lottos = Lottos.of(
            listOf(
                Lotto.of(setOf(1, 2, 3, 4, 5, 6)),
                Lotto.of(setOf(1, 2, 3, 4, 5, 7)),
                Lotto.of(setOf(1, 2, 3, 4, 7, 8)),
                Lotto.of(setOf(1, 2, 3, 7, 8, 9)),
                Lotto.of(setOf(1, 2, 7, 8, 9, 10)),
                Lotto.of(setOf(1, 7, 8, 9, 10, 11)),
                Lotto.of(setOf(7, 8, 9, 10, 11, 12)),
            )
        )
    }
}
