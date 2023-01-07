package lottery

import lottery.controller.LotteryController
import lottery.service.CalculatorService
import lottery.service.ExchangeService
import lottery.service.LottoService
import lottery.service.WinningResultService
import lottery.ui.InputView
import lottery.ui.ResultView
import lottery.ui.ViewService

fun main() {
    val viewService = ViewService(InputView(), ResultView())
    val lottoService = LottoService(ExchangeService())
    val winningResultService = WinningResultService()
    val calculatorService = CalculatorService()

    val lotteryController = LotteryController(
        viewService,
        lottoService,
        winningResultService,
        calculatorService
    )

    lotteryController.run()
}