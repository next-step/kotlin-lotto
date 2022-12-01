package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import lotto.createLotto
import lotto.createWinningNumber
import java.math.BigDecimal

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

    "로또 수익율을 반환한다" {
        val lottoResult = LottoResult(
            listOf(
                createLotto(8, 21, 23, 41, 42, 43),
                createLotto(3, 5, 11, 16, 32, 38),
                createLotto(7, 11, 16, 35, 36, 44),
                createLotto(1, 8, 11, 31, 41, 42),
                createLotto(13, 14, 16, 38, 42, 45),
                createLotto(7, 11, 30, 40, 42, 43),
                createLotto(2, 13, 22, 32, 38, 45),
                createLotto(23, 25, 33, 36, 39, 41),
                createLotto(1, 3, 5, 14, 22, 45),
                createLotto(5, 9, 38, 41, 43, 44),
                createLotto(2, 8, 9, 18, 19, 21),
                createLotto(13, 14, 18, 21, 23, 35),
                createLotto(17, 21, 29, 37, 42, 45),
                createLotto(3, 8, 27, 30, 35, 44)
            ),
            createWinningNumber(1, 2, 3, 4, 5, 6)
        )

        lottoResult.profit(Payment(14000)) shouldBe BigDecimal.valueOf(0.35)
    }
})
