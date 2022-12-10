package step2.lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class LottosTest : StringSpec({
    "전체 로또와 당첨 번호를 비교하여 당첨 결과 목록을 반환한다." {
        val winningNumber: WinningNumber = WinningNumber.of(listOf(1, 2, 3, 4, 5, 6))
        val actual = lottos.match(winningNumber)

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
