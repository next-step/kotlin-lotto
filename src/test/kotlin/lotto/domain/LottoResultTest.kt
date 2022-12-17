package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import java.math.BigDecimal

class LottoResultTest : StringSpec({
    "로또 당첨 통계를 반환한다" {
        val lottoResult = LottoResult(
            listOf(
                LottoRank.FIRST,
                LottoRank.FIRST,
                LottoRank.FOURTH,
                LottoRank.SECOND
            )
        )

        val actual = lottoResult.countByRank()

        forAll(
            row(LottoRank.FIFTH, 0),
            row(LottoRank.FOURTH, 1),
            row(LottoRank.THIRD, 0),
            row(LottoRank.SECOND, 1),
            row(LottoRank.FIRST, 2),
        ) { lottoMatch, expected ->
            actual[lottoMatch] shouldBe expected
        }
    }

    "로또 수익율을 반환한다" {
        val lottoResult = LottoResult(
            listOf(
                LottoRank.FIFTH,
                LottoRank.NONE,
                LottoRank.NONE,
                LottoRank.NONE,
                LottoRank.NONE,
                LottoRank.NONE,
                LottoRank.NONE,
                LottoRank.NONE,
                LottoRank.NONE,
                LottoRank.NONE,
                LottoRank.NONE,
                LottoRank.NONE,
                LottoRank.NONE,
                LottoRank.NONE,
            )
        )

        lottoResult.profit(Payment(14000)) shouldBe BigDecimal.valueOf(0.35)
    }
})
