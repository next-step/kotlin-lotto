package lotto

fun main() {
    val price = InputNumber.buy()
    val buyTicket = Ticket().buyTickets(price)
    val lotto = Ticket().apply { tickets(buyTicket) }
    ResultView.printBuyedLottoTicket(lotto.purchasedLotto)

    val winNumber = InputNumber.winningNumberInput()
}
