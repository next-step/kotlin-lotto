package lotto

import lotto.store.LottoStore

fun main() {
    val request = inputPrice()
    val issuedLottoTickets = LottoStore.purchase(request)
    printLottoTickets(issuedLottoTickets)

    val winningTicket = inputWinningTicket()
    val result = issuedLottoTickets.match(winningTicket)
    printResultStatic(result = result, request = request)
}
