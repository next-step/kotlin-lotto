package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import lotto.infrastructure.DefaultProfitRateCalculator

class LottoGameResultTest : StringSpec({
    "로또의 수익률을 계산할 수 있다." {
        forAll(
            row(
                mapOf(
                    LottoRank.FIRST to 1,
                    LottoRank.SECOND to 1,
                    LottoRank.THIRD to 1,
                    LottoRank.FOURTH to 1,
                    LottoRank.NO_RANK to 1,
                ),
                LottoPurchaseAmount(5000),
                406310.0,
            ),
            row(
                mapOf(
                    LottoRank.FIRST to 0,
                    LottoRank.SECOND to 0,
                    LottoRank.THIRD to 0,
                    LottoRank.FOURTH to 1,
                    LottoRank.NO_RANK to 4,
                ),
                LottoPurchaseAmount(5000),
                10.0,
            ),
            row(
                mapOf(
                    LottoRank.FIRST to 0,
                    LottoRank.SECOND to 0,
                    LottoRank.THIRD to 0,
                    LottoRank.FOURTH to 0,
                    LottoRank.NO_RANK to 5,
                ),
                LottoPurchaseAmount(5000),
                0.0,
            ),
            row(
                mapOf(
                    LottoRank.FIRST to 0,
                    LottoRank.SECOND to 0,
                    LottoRank.THIRD to 0,
                    LottoRank.FOURTH to 1,
                    LottoRank.NO_RANK to 13,
                ),
                LottoPurchaseAmount(14000),
                3.57,
            ),
            row(
                mapOf(
                    LottoRank.FIRST to 0,
                    LottoRank.SECOND to 0,
                    LottoRank.THIRD to 0,
                    LottoRank.FIFTH to 1,
                    LottoRank.NO_RANK to 13,
                ),
                LottoPurchaseAmount(14000),
                0.35,
            ),
        ) { lottoResult, purchasePrice, expected ->
            val lottoProfitRate = LottoGameResult(lottoResult, DefaultProfitRateCalculator())
            lottoProfitRate.calculateProfitRate(purchasePrice) shouldBe expected
        }
    }
})
