package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.fixture.createLottoNumbers
import lotto.fixture.of

class LottosTest : FunSpec({

    test("당첨 번호 객체를 전달하면 당첨 통계 정보를 반환한다.") {
        val winningNumber = WinningNumbers(createLottoNumbers(1, 2, 3, 4, 5, 6))
        val lottos = listOf(
            Lotto.of(1, 2, 3, 4, 5, 6),
            Lotto.of(1, 2, 3, 4, 5, 6),
            Lotto.of(1, 2, 3, 4, 7, 8),
            Lotto.of(1, 2, 3, 7, 8, 9),
            Lotto.of(1, 2, 7, 8, 9, 10),
            Lotto.of(1, 7, 8, 9, 10, 11)
        ).let(::Lottos)

        val actual = lottos.winningStatistics(winningNumber)

        actual[Rank.FIRST] shouldBe 2
        actual[Rank.SECOND] shouldBe 0
        actual[Rank.THIRD] shouldBe 1
        actual[Rank.FOURTH] shouldBe 1
        actual[Rank.MISS] shouldBe 2
    }
})
