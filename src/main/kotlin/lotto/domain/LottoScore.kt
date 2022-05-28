package lotto.domain

class LottoScore {
    fun compareNumber(winningTicket: LottoTicket, lottoTickets: List<LottoTicket>): List<LottoResult> {
        val matchCounts = lottoTickets.map { lottoTicket ->
            lottoTicket.get().mapNotNull { lottoNumber ->
                winningTicket.get().find { it.comapare(lottoNumber) }
            }.size
        }

        val compareResult = matchCounts.groupingBy { it }.eachCount()

        return compareResult.map { (matchCount, lottoCount) ->
            LottoPrize.find(matchCount)?.let { LottoPrize ->
                LottoResult(LottoPrize, lottoCount)
            }
        }.filterNotNull()
    }
}
