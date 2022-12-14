package com.nextstep.lotto.domain

class LottoTickets(private val lottoTickets: List<LottoTicket>) {
    fun size(): Int {
        return lottoTickets.size
    }

    fun getLottoTickets(): List<LottoTicket> {
        return lottoTickets.toList()
    }

    fun calculateResult(winningNumber: WinningNumber, bonusNumber: LottoNumber): LottoResult {
        val countByRank = lottoTickets.groupingBy { mapRank(it, winningNumber, bonusNumber) }.eachCount()
        return LottoResult(countByRank)
    }

    private fun mapRank(
        it: LottoTicket,
        winningNumber: WinningNumber,
        bonusNumber: LottoNumber
    ): Rank {
        val matchCount = it.matchCount(winningNumber)
        val isContainsBonus = it.containsBonus(bonusNumber)
        return Rank.from(matchCount, isContainsBonus)
    }
}
