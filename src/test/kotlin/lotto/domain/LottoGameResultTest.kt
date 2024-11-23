package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

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
                400311.0,
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
                1.0,
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
                0.35,
            ),
        ) { lottoResult, purchasePrice, expected ->
            val lottoGameResult = LottoGameResult(lottoResult)
            val lottoProfitRate = lottoGameResult.makeLottoProfitRate(purchasePrice.toLottoPurchaseCount())
            lottoProfitRate.rate shouldBe expected
        }
    }
})

// class LottoGameResult(private val lottoResult: Map<LottoRank, Int>) {
//    fun makeLottoProfitRate(purchaseCount: LottoPurchaseCount): LottoProfitRate {
//        val totalPrize = lottoResult.map { it.key.prize * it.value }.sum()
//        return LottoProfitRate(totalPrize, purchaseCount)
//    }
// }
