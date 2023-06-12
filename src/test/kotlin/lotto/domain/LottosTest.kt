package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoNumbersFixtureMaker.createLottoNumbers

class LottosTest : FunSpec({

    test("당첨 번호 객체를 전달하면 당첨 통계 정보를 반환한다.") {
        val winningNumber = WinningNumbers(createLottoNumbers(listOf(1, 2, 3, 4, 5, 6)))
        val lottos = listOf(
            createLottoNumbers(items = listOf(1, 2, 3, 4, 5, 6)).let(::Lotto),
            createLottoNumbers(items = listOf(1, 2, 3, 4, 5, 6)).let(::Lotto),
            createLottoNumbers(items = listOf(1, 2, 3, 4, 7, 8)).let(::Lotto),
            createLottoNumbers(items = listOf(1, 2, 3, 7, 8, 9)).let(::Lotto),
            createLottoNumbers(items = listOf(1, 2, 7, 8, 9, 10)).let(::Lotto),
            createLottoNumbers(items = listOf(1, 7, 8, 9, 10, 11)).let(::Lotto)
        ).let(::Lottos)

        val actual = lottos.winningStatistics(winningNumber)

        actual[Rank.FIRST] shouldBe 2
        actual[Rank.SECOND] shouldBe 0
        actual[Rank.THIRD] shouldBe 1
        actual[Rank.FOURTH] shouldBe 1
        actual[Rank.MISS] shouldBe 2
    }
})
