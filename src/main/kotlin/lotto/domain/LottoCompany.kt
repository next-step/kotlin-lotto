package lotto.domain

import lotto.constants.ErrorMessages

/**
 * 당첨 번호를 갖고, 당첨 여부를 알려주는 클래스.
 * Created by Jaesungchi on 2022.05.25..
 */
class LottoCompany(private val winningTicket: LottoTicket, private val bonusNumber: LottoNumber) {
    init {
        require(bonusNumber !in winningTicket) { ErrorMessages.BONUS_IS_DUPLICATE_WITH_WINNINGS }
    }

    fun convertTicketsToLottoResults(lottoTickets: LottoTickets): LottoResults {
        return LottoResults(lottoTickets.tickets.map { findCorrectLotto(it) })
    }

    private fun findCorrectLotto(ticket: LottoTicket): Prize {
        val matchCounts = ticket.getMatchCount(winningTicket)
        val isCorrectBonus = bonusNumber in ticket
        return Prize.of(matchCounts, isCorrectBonus)
    }

    companion object {
        fun of(stringWinningNumber: () -> String, bonusNumber: () -> Int): LottoCompany {
            val winningNumbers = LottoTicket.of(stringWinningNumber.invoke())
            return LottoCompany(winningNumbers, LottoNumber.of(bonusNumber.invoke()))
        }
    }
}
