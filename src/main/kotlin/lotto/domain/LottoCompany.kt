package lotto.domain

import lotto.constants.Messages
import lotto.model.LottoResult
import lotto.model.LottoTicket
import lotto.model.Prize

/**
 * 당첨 번호를 갖고, 당첨 여부를 알려주는 클래스.
 * Created by Jaesungchi on 2022.05.25..
 */
class LottoCompany(winningNumbers: List<Int>) {
    val winningTicket: LottoTicket

    init {
        require(winningNumbers.size == LOTTO_COUNT_LIMITS) { Messages.Error.WINNING_NUMBER_IS_OVER_BASE }
        winningTicket = LottoTicket(winningNumbers)
    }

    fun convertTicketsToLottoResults(tickets: List<LottoTicket>): List<LottoResult> {
        return convertPrizeToLottoResult(tickets.map { findCorrectLotto(it) })
    }

    private fun findCorrectLotto(ticket: LottoTicket): Prize {
        val matchCounts = ticket.numbers.intersect(winningTicket.numbers.toSet()).size
        return Prize.of(matchCounts)
    }

    private fun convertPrizeToLottoResult(prizes: List<Prize>): List<LottoResult> {
        return prizes.groupingBy { it.matchCount }.eachCount().map {
            LottoResult(Prize.of(it.key), it.value)
        }
    }

    companion object {
        private const val LOTTO_COUNT_LIMITS = 6
        fun of(stringWinningNumber: String): LottoCompany {
            val winningNumbers = stringWinningNumber.split(",").map {
                it.trim().toInt()
            }
            return LottoCompany(winningNumbers)
        }
    }
}
