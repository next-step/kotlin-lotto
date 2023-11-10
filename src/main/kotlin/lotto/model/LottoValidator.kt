package lotto.model

import lotto.collection.LottoNumber
import lotto.collection.LottoResults
import lotto.collection.LottoTicket


object LottoValidator {
    fun validate(lottoTickets: List<LottoTicket>, winningNumbers: List<LottoNumber>): LottoResults {
        return LottoResults(getMatchedList(lottoTickets, winningNumbers))
    }

    private fun getMatchedList(lottoTickets: List<LottoTicket>, winningNumbers: List<LottoNumber>): List<Int> {
        val result = MutableList(LottoTicket.NUMBER_COUNT + 1) { 0 }
        lottoTickets.forEach { lottoTicket ->
            getMatchCount(winningNumbers, lottoTicket).let { matchCount -> result[matchCount]++ }
        }
        return result.toList()
    }

    private fun getMatchCount(winningNumbers: List<LottoNumber>, lottoTicket: LottoTicket): Int =
        lottoTicket.numbers.intersect(winningNumbers.toSet()).size
}
