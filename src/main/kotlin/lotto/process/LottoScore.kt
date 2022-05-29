package lotto.process

import lotto.model.LottoPrice
import lotto.model.LottoPrize
import lotto.model.LottoResult
import lotto.model.LottoTicket

class LottoScore {
    fun compareNumber(winningTicket: LottoTicket, lottoTickets: List<LottoTicket>): List<LottoResult> {
        val matchCounts = lottoTickets.map { lottoTicket ->
            lottoTicket.compareEqualCount(winningTicket)
        }

        val compareResult = matchCounts.groupingBy { it }.eachCount()

        return LottoPrize.values().map { lottoPrize ->
            val lottoCount = compareResult.getOrDefault(lottoPrize.matchCount, 0)
            LottoResult(lottoPrize, lottoCount)
        }
    }

    fun rateOfResult(lottoPrice: LottoPrice, lottoResults: List<LottoResult>): Double {
        return sumOfResult(lottoResults).toDouble() / lottoPrice.get()
    }

    private fun sumOfResult(lottoResults: List<LottoResult>) = lottoResults.sumOf {
        it.lottoPrize.prizeMoney * it.lottoCount
    }
}
