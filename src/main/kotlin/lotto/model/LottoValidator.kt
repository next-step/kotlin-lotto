package lotto.model

import lotto.collection.LottoTicket

class LottoValidator {
    companion object {
        fun validate(lottoTickets: List<LottoTicket>, winningNumbers: List<Int>, ticketLength: Int): List<Int> {
            val result = MutableList(ticketLength + 1) { 0 }
            lottoTickets.forEach {
                result[it.matchCount(winningNumbers)]++
            }
            return result.toList()
        }
    }
}
