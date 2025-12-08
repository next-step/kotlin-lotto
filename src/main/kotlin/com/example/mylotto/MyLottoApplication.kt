package com.example.mylotto

import com.example.mylotto.model.LottoNumber
import com.example.mylotto.model.LottoNumbers
import com.example.mylotto.model.LottoResult
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

    val purchaseAmount = retryInput { inputView.readPurchaseAmount() }
    val manualCount = retryInput { inputView.readManualCount() }
    val manualLottoNumbers =
        retryInput {
            inputView.readManualLottoTickets(manualCount).map {
                LottoNumbers.of(it.map(::LottoNumber))
            }
        }
    val autoLottoNumbers = lottoService.generateAutoLottoNumbers(purchaseAmount, manualCount)

    resultView.displayPurchasedTickets(manualLottoNumbers, autoLottoNumbers)

    val winningNumbers = retryInput { LottoNumbers.of(inputView.readWinningNumbers().map(::LottoNumber)) }
    val bonusNumber = retryInput { inputView.readBonusNumber() }

    val result =
        LottoResult.of(
            (autoLottoNumbers + manualLottoNumbers).map { lottoNumbers ->
                lottoService.matchLottoTicket(
                    lottoNumbers,
                    winningNumbers,
                    bonusNumber,
                )
            },
        )
    resultView.displayWinningStatistics(result)
}

fun <T> retryInput(prompt: () -> T): T {
    while (true) {
        try {
            return prompt()
        } catch (_: Exception) {
            println("다시 입력해주세요")
        }
    }
}
