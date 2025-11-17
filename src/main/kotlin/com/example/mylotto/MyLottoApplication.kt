package com.example.mylotto

import com.example.mylotto.model.LottoNumber
import com.example.mylotto.model.LottoResult
import com.example.mylotto.model.LottoTicket
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

    var lottoTickets: List<LottoTicket>

    while (true) {
        try {
            val purchaseAmount = inputView.readPurchaseAmount()
            lottoTickets = lottoService.generateLottoTickets(purchaseAmount)
            resultView.displayPurchasedTickets(lottoTickets)
            break
        } catch (e: Exception) {
            println("다시 입력해주세요")
        }
    }

    while (true) {
        try {
            val winningNumbers: LottoWinningNumbers = LottoWinningNumbers.of(inputView.readWinningNumbers().map(::LottoNumber))
            val result = LottoResult.of(lottoTickets.map { ticket -> lottoService.matchLottoTicket(ticket, winningNumbers) })
            resultView.displayWinningStatistics(result)
            break
        } catch (e: Exception) {
            println("다시 입력해주세요")
        }
    }

    println()
}
