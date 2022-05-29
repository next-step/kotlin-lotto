package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

class LottoScore {
    fun compareNumber(winningTicket: LottoTicket, lottoTickets: List<LottoTicket>): List<LottoResult> {
        val matchCounts = lottoTickets.map { lottoTicket ->
            lottoTicket.countIntersect(winningTicket)
        }

        val compareResult = matchCounts.groupingBy { it }.eachCount()

        return LottoPrize.values().map { lottoPrize ->
            val lottoCount = compareResult.getOrDefault(lottoPrize.matchCount, 0)
            LottoResult(lottoPrize, lottoCount)
        }
    }

    fun rateOfResult(lottoPrice: LottoPrice, lottoResults: List<LottoResult>): BigDecimal {
        val realLottoPrice = lottoPrice / LottoPurchase.LOTTO_PRICE * LottoPurchase.LOTTO_PRICE
        return BigDecimal(sumOfResult(lottoResults).toDouble()).divide(BigDecimal(realLottoPrice), 2, RoundingMode.HALF_UP)
    }

    private fun sumOfResult(lottoResults: List<LottoResult>) = lottoResults.sumOf {
        it.lottoPrize.prizeMoney * it.lottoCount
    }
}
