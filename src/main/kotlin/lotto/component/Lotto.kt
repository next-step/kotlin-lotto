package lotto.component

import lotto.model.*

class Lotto(
    private val lottoResultAnalyzer: LottoResultAnalyzer
) {
    fun draw(lottoNumbers: List<LottoNumbers>, winningNumbers: WinningNumbers, bonusNumber: LottoNumber): LottoResult {
        val lottoPrizes: List<LottoPrize> = getLottoPrizes(lottoNumbers, winningNumbers, bonusNumber)
        val revenueRate: Double = lottoResultAnalyzer.getRevenueRate(lottoPrizes)

        return LottoResult(lottoPrizes, revenueRate)
    }

    private fun getLottoPrizes(
        lottoNumbers: List<LottoNumbers>,
        winningNumbers: WinningNumbers,
        bonusNumber: LottoNumber
    ): List<LottoPrize> {
        return lottoNumbers
            .map {
                val matchedCount: Int = winningNumbers.match(it)
                val isBonusNumberMatched: Boolean = it.contain(bonusNumber)

                LottoPrize.of(matchedCount, isBonusNumberMatched)
            }
    }

    companion object {
        private const val LOTTO_PRICE = 1000

        fun purchaseLottoCount(purchasePrice: PurchasePrice): Int {
            return purchasePrice.purchasePrice / LOTTO_PRICE
        }

        fun getLottoTotalPrice(count: Int): Int {
            return count * LOTTO_PRICE
        }
    }
}