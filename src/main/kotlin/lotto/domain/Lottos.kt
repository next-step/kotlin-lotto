package lotto.domain

data class LottoTicket(
    val lottoNumbers: List<Int>
) {
    fun matchCount(winningNumber: WinningNumber): Int {
        return lottoNumbers.count { lottoNumber ->
            winningNumber.winningNumbers.contains(lottoNumber)
        }
    }
}

data class LottoTickets(
    val lottoCount: Int,
    val lottoTickets: List<LottoTicket>
) {
    private val listMatchCount = mutableListOf<Int>()

    fun match(winningNumbers: WinningNumber): List<Int> {
         lottoTickets.map { lottoTicket ->
            val matchCount = lottoTicket.matchCount(winningNumbers)
             listMatchCount.plus(matchCount)
        }
        return listMatchCount.sorted()
    }
}
