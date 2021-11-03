package lotto

fun main() {
    val tickets = LottoController.buyTickets()
    val winning = LottoController.getWinning()
    LottoController.getStatistics(tickets, winning)
}
