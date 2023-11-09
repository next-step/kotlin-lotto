package lotto.component

import lotto.model.*
import kotlin.math.round

class Lotto {
    fun draw(lottoTickets: List<LottoTicket>, winningNumbers: WinningNumbers): LottoResult {
        val lottoPrizes = getLottoPrizes(lottoTickets, winningNumbers)
        val revenueRate = getRevenueRate(lottoTickets, lottoPrizes)

        return LottoResult(lottoPrizes, revenueRate)
    }

    private fun getLottoPrizes(lottoTickets: List<LottoTicket>, winningNumbers: WinningNumbers): List<LottoPrize> {
        return lottoTickets
            .map { winningNumbers.match(it.lottoNumbers) }
            .map { LottoPrize.create(it) }
    }

    private fun getRevenueRate(lottoTickets: List<LottoTicket>, lottoPrizes: List<LottoPrize>): Double {
        val totalRevenue = getTotalRevenue(lottoPrizes)
        val totalPrice = getTotalPrice(lottoTickets)

        // 소수점 2자리 반올림.
        return round(totalRevenue.toDouble() / totalPrice * 100) / 100
    }

    private fun getTotalRevenue(lottoPrizes: List<LottoPrize>): Int {
        return lottoPrizes.sumOf { it.prize }
    }

    private fun getTotalPrice(lottoTickets: List<LottoTicket>): Int {
        return lottoTickets.size * LOTTO_PRICE
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
