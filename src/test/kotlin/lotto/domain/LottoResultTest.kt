package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import java.math.BigDecimal

class LottoResultTest : StringSpec({
    "로또 당첨 통계를 반환한다" {
        val winningNumber = WinningNumber(1, 2, 3, 4, 5, 6, bonusBall = 7)

        val lottoResult = winningNumber.match(
            listOf(
                Lotto(1, 2, 3, 4, 7, 8),
                Lotto(1, 2, 3, 4, 5, 7),
                Lotto(1, 2, 3, 4, 5, 6),
                Lotto(1, 2, 3, 4, 5, 6)
            )
        )

        val actual = lottoResult.countByRank()

        forAll(
            row(LottoRank.FIFTH, 0),
            row(LottoRank.FOURTH, 1),
            row(LottoRank.THIRD, 1),
            row(LottoRank.FIRST, 2),
        ) { lottoMatch, expected ->
            actual[lottoMatch] shouldBe expected
        }
    }

    "로또 수익율을 반환한다" {
        val winningNumber = WinningNumber(1, 2, 3, 4, 5, 6, bonusBall = 7)

        val lottoResult = winningNumber.match(
            listOf(
                Lotto(8, 21, 23, 41, 42, 43),
                Lotto(3, 5, 11, 16, 32, 38),
                Lotto(7, 11, 16, 35, 36, 44),
                Lotto(1, 8, 11, 31, 41, 42),
                Lotto(13, 14, 16, 38, 42, 45),
                Lotto(7, 11, 30, 40, 42, 43),
                Lotto(2, 13, 22, 32, 38, 45),
                Lotto(23, 25, 33, 36, 39, 41),
                Lotto(1, 3, 5, 14, 22, 45),
                Lotto(5, 9, 38, 41, 43, 44),
                Lotto(2, 8, 9, 18, 19, 21),
                Lotto(13, 14, 18, 21, 23, 35),
                Lotto(17, 21, 29, 37, 42, 45),
                Lotto(3, 8, 27, 30, 35, 44)
            )
        )

        lottoResult.profit(Payment(14000)) shouldBe BigDecimal.valueOf(0.35)
    }
})
