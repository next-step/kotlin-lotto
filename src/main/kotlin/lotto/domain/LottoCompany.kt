package lotto.domain

import lotto.constants.ErrorMessages
import lotto.model.LottoResult
import lotto.model.LottoTicket
import lotto.model.Prize

/**
 * 당첨 번호를 갖고, 당첨 여부를 알려주는 클래스.
 * Created by Jaesungchi on 2022.05.25..
 */
class LottoCompany(val winningTicket: LottoTicket) {
    fun convertTicketsToLottoResults(tickets: List<LottoTicket>): List<LottoResult> {
        return convertPrizeToLottoResult(tickets.map { findCorrectLotto(it) })
    }

    private fun findCorrectLotto(ticket: LottoTicket): Prize {
        val matchCounts = ticket.numbers.intersect(winningTicket.numbers.toSet()).size
        return Prize.of(matchCounts)
    }

    private fun convertPrizeToLottoResult(prizes: List<Prize>): List<LottoResult> {
        // TODO 여기서 한단계 더 가봅시다! prizes를 groupingBy를 통하여, LottoResult를 만들고 Prize를 다시 넣어주는 것은 중복된 생성이라고 생각해요.
        // 어떻게 해야 개선을 할 수 있을까요?🤔
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
            return of(winningNumbers)
        }

        fun of(numberList: List<Int>): LottoCompany {
            require(numberList.size == LOTTO_COUNT_LIMITS) { ErrorMessages.WINNING_NUMBER_IS_OVER_BASE }
            return LottoCompany(LottoTicket.of(numberList))
        }
    }
}
