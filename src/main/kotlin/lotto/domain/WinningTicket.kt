package lotto.domain

class WinningTicket(
    private val winningNumbers: LottoNumbers,
    private val bonusNumber: LottoNumber
) {

    fun getMatchingResult(myTickets: LottoTickets): LottoResult {
        return myTickets.values
            .map { numbers -> Pair(numbers.countMatchingNumbers(winningNumbers), numbers.containNumber(bonusNumber)) }
            .groupingBy { LottoRank.of(it.first, it.second) }
            .eachCount()
            .let { LottoResult(it) }
    }
}
