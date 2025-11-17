package com.example.mylotto.service

import com.example.mylotto.constant.LottoConstant
import com.example.mylotto.enum.Rank
import com.example.mylotto.model.LottoTicket
import com.example.mylotto.model.LottoWinningNumbers

class LottoService {
    fun generateLottoTickets(purchaseAmount: Long): List<LottoTicket> {
        require(purchaseAmount > 0 && purchaseAmount % LottoConstant.LOTTO_TICKET_PRICE == 0L) {
            "Purchase amount must be a positive multiple of ${LottoConstant.LOTTO_TICKET_PRICE}."
        }
        val ticketCount = (purchaseAmount / LottoConstant.LOTTO_TICKET_PRICE).toInt()
        return List(ticketCount) {
            LottoTicket()
        }
    }

    fun matchLottoTicket(
        lottoTicket: LottoTicket,
        winningNumbers: LottoWinningNumbers,
    ): Rank {
        val matchedCount = lottoTicket.numbers.intersect(winningNumbers.numbers).size
        return Rank.valueOf(matchedCount)
    }
}
