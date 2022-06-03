package lotto.domain

import lotto.domain.enum.Priority

class LottoTicket(private val lottoNumber: LottoNumber) {
    val numbers: Set<Int> = lottoNumber.numbers

    fun priority(winningTicket: LottoTicket): Priority {
        val matchCount = numbers.filter { winningTicket.numbers.contains(it) }.size
        return if (isBonusTicket(matchCount, winningTicket.lottoNumber.bonusNumber)) Priority.SECOND else Priority.value(matchCount)
    }

    fun contains(number: Int?) {
        lottoNumber.contains(number)
    }

    private fun isBonusTicket(matchCount: Int, bonusNumber: Int): Boolean {
        return lottoNumber.hasBonusNumber(bonusNumber) && matchCount == BONUS_CANDIDATE_COUNT
    }

    companion object {
        private const val BONUS_CANDIDATE_COUNT = 4
    }
}
