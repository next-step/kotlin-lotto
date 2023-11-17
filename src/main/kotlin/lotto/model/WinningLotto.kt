package lotto.model

class WinningLotto (private val winningNumbers: List<LottoNumber>, private val bonusNumber: LottoNumber) {
    fun getLottoResult(
        lottoTickets: List<LottoTicket>
    ): LottoResult {
        val results = lottoTickets.fold(mutableMapOf()) { results: MutableMap<Prize, Int>, lottoTicket: LottoTicket ->
            val key = getResultKey(winningNumbers, lottoTicket.numbers, bonusNumber)
            results[key] = (results[key] ?: 0) + 1
            results
        }.toMap()
        return LottoResult(results)
    }

    private fun getResultKey(
        winningNumbers: List<LottoNumber>,
        lottoTicketNumbers: List<LottoNumber>,
        bonusNumber: LottoNumber
    ): Prize {
        val matchCount = getMatchCount(winningNumbers.toIntList(), lottoTicketNumbers.toIntList())
        val isBonus = Prize.isBonus(matchCount, lottoTicketNumbers.contains(bonusNumber))
        return Prize.getKeyWithMatched(matchCount, isBonus)
    }

    private fun getMatchCount(first: List<Int>, second: List<Int>): Int = first.intersect(second.toSet()).size

    private fun List<LottoNumber>.toIntList() = this.map { it.number }
}
