package lotto

fun main() {
    val ticket = InputNumber.buy()
    val lottos = Lottos()

    InputNumber.buyLottos(lottos, ticket)
    ResultView.printBuyedLottoTicket(lottos.purchasedLotto)
    val winNumber = InputNumber.winningNumberInput()
    val bonusNumber = InputNumber.bonusNumber()
    val result = lottos.getLottoResultsWithBonus(winNumber, bonusNumber)
    ResultView.printWinnerStatistics(result)
    ResultView.printIncome(Result().getStatistics(ticket, result))
}
