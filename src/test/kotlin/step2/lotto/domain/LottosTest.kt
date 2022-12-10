package step2.lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import step2.lotto.domain.MatchResult.FIRST_PLACE
import step2.lotto.domain.MatchResult.FOURTH_PLACE
import step2.lotto.domain.MatchResult.NOT_WINNING
import step2.lotto.domain.MatchResult.SECOND_PLACE
import step2.lotto.domain.MatchResult.THIRD_PLACE

internal class LottosTest : StringSpec({
    "전체 로또와 당첨 번호를 비교하여 당첨 결과 목록을 반환한다." {
        val winningNumber: WinningNumber = WinningNumber.of(listOf(1, 2, 3, 4, 5, 6))
        val actual = lottos.match(winningNumber)

        actual.containsAll(FIRST_PLACE, SECOND_PLACE, THIRD_PLACE, FOURTH_PLACE, NOT_WINNING)
        actual.firstPlaceCount shouldBe 1
        actual.secondPlaceCount shouldBe 1
        actual.thirdPlaceCount shouldBe 1
        actual.fourthPlaceCount shouldBe 1
        actual.notWinningCount shouldBe 3
    }
}) {
    companion object {
        val lottos = Lottos.of(
            listOf(
                Lotto.of(listOf(1, 2, 3, 4, 5, 6)),
                Lotto.of(listOf(1, 2, 3, 4, 5, 7)),
                Lotto.of(listOf(1, 2, 3, 4, 7, 8)),
                Lotto.of(listOf(1, 2, 3, 7, 8, 9)),
                Lotto.of(listOf(1, 2, 7, 8, 9, 10)),
                Lotto.of(listOf(1, 7, 8, 9, 10, 11)),
                Lotto.of(listOf(7, 8, 9, 10, 11, 12)),
            )
        )
    }
}
