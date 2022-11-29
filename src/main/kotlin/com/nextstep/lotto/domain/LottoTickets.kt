package com.nextstep.lotto.domain

class LottoTickets(private val lottoTickets: List<LottoTicket>) {
    fun size(): Int {
        return lottoTickets.size
    }

    fun getLottoTickets(): List<LottoTicket> {
        return lottoTickets.toList()
    }

    fun calculateResult(winningNumber: WinningNumber): LottoResult {
        val eachCount = lottoTickets.map { it.matchCount(winningNumber.winningNumbers) }.groupingBy { Rank.from(it) }.eachCount()
        return LottoResult(eachCount)
    }
}
