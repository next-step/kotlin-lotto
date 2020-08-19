package lotto

fun main() {
    val ticket = InputNumber.buy()
    val lottos = Lottos(ticket)
    ResultView.printBuyedLottoTicket(lottos.purchasedLotto)

    val winNumber = InputNumber.winningNumberInput()
    val result = lottos.purchasedLotto.map { it.getPrize(winNumber) }
    ResultView.printWinnerStatistics(result)
    ResultView.printIncome(Result().getStatistics(ticket, result))
}
