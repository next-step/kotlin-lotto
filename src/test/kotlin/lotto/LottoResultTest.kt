package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoResultTest : StringSpec({
    "로또 당첨 통계를 반환한다" {
        val lottoResult = LottoResult(
            listOf(
                createLotto(1, 2, 3, 4, 7, 8),
                createLotto(1, 2, 3, 4, 5, 7),
                createLotto(1, 2, 3, 4, 5, 6),
                createLotto(1, 2, 3, 4, 5, 6)
            ),
            createWinningNumber(1, 2, 3, 4, 5, 6)
        )

        val actual = lottoResult.countByLottoMatch()

        forAll(
            row(LottoMatch.THREE, 0),
            row(LottoMatch.FOUR, 1),
            row(LottoMatch.FIVE, 1),
            row(LottoMatch.SIX, 2),
        ) { lottoMatch, expected ->
            actual[lottoMatch] shouldBe expected
        }
    }
})
