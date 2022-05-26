package lotto.domain

import lotto.model.LottoResult
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

    fun convertTicketsToLottoResults(tickets: List<LottoTicket>): List<LottoResult> {
        return convertPrizeToLottoResult(tickets.mapNotNull { findCorrectLotto(it) })
    }

    private fun findCorrectLotto(ticket: LottoTicket): Prize? {
        val matchCounts = ticket.numbers.intersect(winningNumber.toSet()).size
        return Prize.of(matchCounts)
    }

    private fun convertPrizeToLottoResult(prizes: List<Prize>): List<LottoResult> {
        val lottoResults = mutableListOf<LottoResult>()
        lottoResults.add(
            LottoResult(
                Prize.FOURTH_PLACE,
                prizes.filter { it.matchCount == FOURTH_PLACE_MATCH_COUNT }.size
            )
        )

        lottoResults.add(
            LottoResult(
                Prize.THIRD_PLACE,
                prizes.filter { it.matchCount == THIRD_PLACE_MATCH_COUNT }.size
            )
        )

        lottoResults.add(
            LottoResult(
                Prize.SECOND_PLACE,
                prizes.filter { it.matchCount == SECOND_PLACE_MATCH_COUNT }.size
            )
        )

        lottoResults.add(
            LottoResult(
                Prize.FIRST_PLACE,
                prizes.filter { it.matchCount == FIRST_PLACE_MATCH_COUNT }.size
            )
        )
        return lottoResults
    }

    companion object {
        private const val LOTTO_COUNT_LIMITS = 6
        private const val FOURTH_PLACE_MATCH_COUNT = 3
        private const val THIRD_PLACE_MATCH_COUNT = 4
        private const val SECOND_PLACE_MATCH_COUNT = 5
        private const val FIRST_PLACE_MATCH_COUNT = 6
    }
}
