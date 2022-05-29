package lotto.domain

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
        val realLottoPrice = lottoPrice / LottoPurchase.LOTTO_PRICE * LottoPurchase.LOTTO_PRICE
        return sumOfResult(lottoResults).toDouble() / realLottoPrice
    }

    private fun sumOfResult(lottoResults: List<LottoResult>) = lottoResults.sumOf {
        it.lottoPrize.prizeMoney * it.lottoCount
    }
}
