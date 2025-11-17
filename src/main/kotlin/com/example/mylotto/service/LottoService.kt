package com.example.mylotto.service

import com.example.mylotto.enum.Rank
import com.example.mylotto.model.LottoTicket
import com.example.mylotto.model.LottoWinningNumbers

class LottoService {
    fun generateLottoTickets(purchaseAmount: Long): List<LottoTicket> {
        // To be implemented: Generate tickets with random numbers
        return emptyList()
    }

    fun matchLottoTicket(
        lottoTicket: LottoTicket,
        winningNumbers: LottoWinningNumbers,
    ): Rank {
        // To be implemented: Compare ticket numbers and return the rank
        return Rank.FIRST
    }
}
