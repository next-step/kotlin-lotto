package lotto.domain

import lotto.model.LottoTicket
import lotto.model.Prize

/**
 * 당첨 번호를 갖고, 당첨 여부를 알려주는 클래스.
 * Created by Jaesungchi on 2022.05.25..
 */
class LottoCompany(stringWinningNumber: String) {
    val winningNumber: List<Int>

    init {
        winningNumber = stringWinningNumber.split(",").map {
            it.trim().toInt()
        }
        require(winningNumber.size == LOTTO_COUNT_LIMITS)
    }

    fun findCorrectLotto(ticket: LottoTicket): Prize {
        val union = ticket.numbers + winningNumber
        val matchCounts = ticket.numbers.size + winningNumber.size - union.distinct().size
        return Prize.of(matchCounts)
    }

    companion object {
        private const val LOTTO_COUNT_LIMITS = 6
    }
}
