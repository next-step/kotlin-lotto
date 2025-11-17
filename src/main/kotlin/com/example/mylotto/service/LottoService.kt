package com.example.mylotto.service

import com.example.mylotto.enum.Rank
import com.example.mylotto.model.LottoTicket
import com.example.mylotto.model.LottoWinningNumbers

class LottoService {
    fun generateLottoTickets(purchaseAmount: Long): List<LottoTicket> {
        require(purchaseAmount > 0 && purchaseAmount % 1000 == 0L) { "Purchase amount must be a positive multiple of 1000." }
        val ticketCount = (purchaseAmount / 1000).toInt()
        return List(ticketCount) {
            LottoTicket()
        }
    }

    fun matchLottoTicket(
        lottoTicket: LottoTicket,
        winningNumbers: LottoWinningNumbers,
    ): Rank {
        val matchedCount = lottoTicket.numbers.intersect(winningNumbers.numbers).size
        return Rank.valueOf(matchedCount, false)
    }
}
