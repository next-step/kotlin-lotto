package com.example.mylotto

import com.example.mylotto.model.LottoNumber
import com.example.mylotto.model.LottoResult
import com.example.mylotto.model.LottoTicket
import com.example.mylotto.model.LottoTicketOrder
import com.example.mylotto.model.LottoWinningNumbers
import com.example.mylotto.service.LottoService
import com.example.mylotto.view.InputView
import com.example.mylotto.view.ResultView

fun main() {
    while (true) {
        doLotto()
    }
}

fun doLotto() {
    val lottoService = LottoService()
    val inputView = InputView()
    val resultView = ResultView()

    var lottoTickets: List<LottoTicket> = emptyList()

    var ticketCount = 0
    inputView.tryUntilSuccess {
        val purchaseAmount = inputView.readPurchaseAmount()
        ticketCount = lottoService.calculateCount(purchaseAmount)
    }

    inputView.tryUntilSuccess {
        val manualTicketCount = inputView.readManualTicketCount(ticketCount)
        val manualLottoTickets = inputView.readManualLottoNumbers(manualTicketCount)
        val lottoTicketOrder =
            LottoTicketOrder(
                manualTickets = manualLottoTickets,
                automaticCount = ticketCount - manualTicketCount,
            )
        lottoTickets = lottoService.generateLottoTickets(lottoTicketOrder)
        resultView.displayPurchasedTickets(lottoTicketOrder, lottoTickets)
    }

    inputView.tryUntilSuccess {
        val winningNumbersInt = inputView.readWinningNumbers().map(LottoNumber::of)
        val bonusNumber = inputView.readBonusNumber().let(LottoNumber::of)
        val winningNumbers: LottoWinningNumbers = LottoWinningNumbers.of(winningNumbersInt, bonusNumber)
        val result = LottoResult.of(lottoTickets.map { ticket -> lottoService.matchLottoTicket(ticket, winningNumbers) })
        resultView.displayWinningStatistics(result)
    }

    println()
}
