package lotto.component

import lotto.model.LottoNumbers
import lotto.model.LottoPrize
import lotto.model.LottoResult
import lotto.model.WinningNumbers

class Lotto(
    private val lottoResultAnalyzer: LottoResultAnalyzer
) {
    fun draw(lottoNumbers: List<LottoNumbers>, winningNumbers: WinningNumbers, bonusNumber: Int): LottoResult {
        val lottoPrizes: List<LottoPrize> = getLottoPrizes(lottoNumbers, winningNumbers, bonusNumber)
        val revenueRate: Double = lottoResultAnalyzer.getRevenueRate(lottoPrizes)

        return LottoResult(lottoPrizes, revenueRate)
    }

    private fun getLottoPrizes(
        lottoNumbers: List<LottoNumbers>,
        winningNumbers: WinningNumbers,
        bonusNumber: Int
    ): List<LottoPrize> {
        return lottoNumbers
            .map {
                val matchedCount: Int = winningNumbers.match(it)
                val isBonusNumberMatched: Boolean = it.contain(bonusNumber)

                LottoPrize.of(matchedCount, isBonusNumberMatched)
            }
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
