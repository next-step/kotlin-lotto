package lotto.component

import lotto.model.*
import kotlin.math.round

class Lotto {
    fun draw(lottoNumbers: List<LottoNumbers>, winningNumbers: WinningNumbers): LottoResult {
        val lottoPrizes = getLottoPrizes(lottoNumbers, winningNumbers)
        val revenueRate = getRevenueRate(lottoNumbers, lottoPrizes)

        return LottoResult(lottoPrizes, revenueRate)
    }

    private fun getLottoPrizes(lottoNumbers: List<LottoNumbers>, winningNumbers: WinningNumbers): List<LottoPrize> {
        return lottoNumbers
            .map { winningNumbers.match(it) }
            .map { LottoPrize.of(it) }
    }

    private fun getRevenueRate(lottoNumbers: List<LottoNumbers>, lottoPrizes: List<LottoPrize>): Double {
        val totalRevenue = getTotalRevenue(lottoPrizes)
        val totalPrice = getTotalPrice(lottoNumbers)

        // 소수점 2자리 반올림.
        return round(totalRevenue.toDouble() / totalPrice * 100) / 100
    }

    private fun getTotalRevenue(lottoPrizes: List<LottoPrize>): Int {
        return lottoPrizes.sumOf { it.prize }
    }

    private fun getTotalPrice(lottoNumbers: List<LottoNumbers>): Int {
        return lottoNumbers.size * LOTTO_PRICE
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
