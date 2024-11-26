package lotto

import lotto.service.OrderService
import lotto.service.WinningLottoService
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val orderService = OrderService()
    val winningLottoService = WinningLottoService()

    val amount = InputView.getAmount()
    val order = orderService.makeOrder(amount)
    ResultView.printCreatedLottos(order.lottos)

    val winNumberInput = InputView.getWinNumberInput()
    val bonusNumber = InputView.getBonusNumber()
    val winNumbers = winningLottoService.createWinningLotto(winNumberInput, bonusNumber)

    val result = winningLottoService.checkAndGetResult(order, winNumbers)
    ResultView.printResult(result)
}
