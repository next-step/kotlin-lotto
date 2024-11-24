package lotto

fun main() {
    val lottoSystem = LottoSystem()

    val amount = InputView.getAmount()
    val order = lottoSystem.createOrder(amount)
    ResultView.printCreatedLottos(order.lottos)

    val winNumberInput = InputView.getWinNumberInput()
    val winNumbers = lottoSystem.createWinNumbers(winNumberInput)

    val result = lottoSystem.createWinningResult(order, winNumbers)
    ResultView.printResult(result)
}
