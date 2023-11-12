package lotto.model

object LottoResultBuilder {
    fun getLottoResults(
        lottoTickets: List<LottoTicket>,
        winningNumbers: List<LottoNumber>,
        bonusNumber: LottoNumber
    ): LottoResults {
        val results = lottoTickets.fold(mutableMapOf()) { results: MutableMap<Prize, Int>, lottoTicket: LottoTicket ->
            val matchCount = getMatchCount(winningNumbers.toIntList(), lottoTicket.numbers.toIntList())
            val isBonus = getIsBonus(matchCount, lottoTicket.numbers, bonusNumber)
            val key = Prize.getKeyWithMatched(matchCount, isBonus)
            results[key] = (results[key] ?: 0) + 1
            results
        }.toMap()
        return LottoResults(results)
    }

    private fun getMatchCount(first: List<Int>, second: List<Int>): Int = first.intersect(second.toSet()).size
    private fun getIsBonus(matchCount: Int, numbers: List<LottoNumber>, bonusNumber: LottoNumber) =
        matchCount == Prize.SECOND.matched && numbers.contains(bonusNumber)
    private fun List<LottoNumber>.toIntList() = this.map { it.number }
}
