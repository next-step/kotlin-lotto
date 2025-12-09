package com.example.mylotto.service

import com.example.mylotto.constant.LottoConstant
import com.example.mylotto.enum.Rank
import com.example.mylotto.model.LottoTicket
import com.example.mylotto.model.LottoTicketOrder
import com.example.mylotto.model.LottoWinningNumbers

class LottoService {
    fun calculateCount(purchaseAmount: Long): Int {
        require(purchaseAmount > 0 && purchaseAmount % LottoConstant.LOTTO_TICKET_PRICE == 0L) {
            "Purchase amount must be a positive multiple of ${LottoConstant.LOTTO_TICKET_PRICE}."
        }
        return (purchaseAmount / LottoConstant.LOTTO_TICKET_PRICE).toInt()
    }

    fun generateLottoTickets(order: LottoTicketOrder): List<LottoTicket> {
        val manualTickets = order.manualTickets
        val automaticTickets = List(order.automaticCount) { LottoTicket.ofAutomatic() }
        return manualTickets + automaticTickets
    }

    fun matchLottoTicket(
        lottoTicket: LottoTicket,
        winningNumbers: LottoWinningNumbers,
    ): Rank {
        val matchedCount = lottoTicket.numbers.intersect(winningNumbers.numbers).size
        val isBonusMatched = winningNumbers.bonusNumber in lottoTicket.numbers
        return Rank.valueOf(matchedCount, isBonusMatched)
    }
}
