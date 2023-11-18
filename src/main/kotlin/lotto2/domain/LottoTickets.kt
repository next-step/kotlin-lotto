package lotto2.domain

class LottoTickets(private val tickets: List<LottoTicket>) {

    fun size(): Int = tickets.size

    fun getAllLottoNumbers(): List<LottoNumbers> {
        return tickets.map { it.numbers }
    }

    fun getRankingsCount(
        winningNumbers: LottoNumbers,
        bonusNumber: Int
    ): Map<LottoRanking, Int> {
        return tickets.map { checkRanking(it, winningNumbers, bonusNumber) }
            .groupingBy { it }
            .eachCount()
    }

    private fun checkRanking(
        lottoTicket: LottoTicket,
        winningNumbers: LottoNumbers,
        bonusNumber: Int
    ): LottoRanking {
        val matchedNumberSize = winningNumbers.countMatchingNumbers(lottoTicket.numbers)
        val isBonusMatched = lottoTicket.isNumberMatched(bonusNumber)

        return LottoRanking.valueOf(matchedNumberSize, isBonusMatched)
    }
}
