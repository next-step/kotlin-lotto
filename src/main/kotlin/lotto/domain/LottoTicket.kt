package lotto.domain

import lotto.domain.enum.Priority

class LottoTicket(private val lottoNumbers: Set<LottoNumber>) {
    val numbers: Set<Int> = lottoNumbers.map { it.number }.toSet()

    fun priority(winningTicket: WinningTicket): Priority {
        val matchCount = numbers.filter { winningTicket.numbers.contains(it) }.size
        return if (isBonusTicket(matchCount, winningTicket.bonusNumber)) Priority.SECOND else Priority.value(matchCount)
    }

    private fun isBonusTicket(matchCount: Int, bonusNumber: Int): Boolean {
        return numbers.contains(bonusNumber) && matchCount == BONUS_CANDIDATE_COUNT
    }

    companion object {
        private const val BONUS_CANDIDATE_COUNT = 4
    }
}
