package lotto.component

import lotto.model.LottoNumbers
import lotto.model.LottoPrize
import lotto.model.LottoResult
import lotto.model.WinningNumbers

class Lotto(
    private val lottoResultAnalyzer: LottoResultAnalyzer
) {
    fun draw(lottoNumbers: List<LottoNumbers>, winningNumbers: WinningNumbers): LottoResult {
        val lottoPrizes: List<LottoPrize> = getLottoPrizes(lottoNumbers, winningNumbers)
        val revenueRate: Double = lottoResultAnalyzer.getRevenueRate(lottoNumbers.size, LOTTO_PRICE, lottoPrizes)

        return LottoResult(lottoPrizes, revenueRate)
    }

    private fun getLottoPrizes(lottoNumbers: List<LottoNumbers>, winningNumbers: WinningNumbers): List<LottoPrize> {
        return lottoNumbers
            .map { winningNumbers.match(it) }
            .map { LottoPrize.of(it) }
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
