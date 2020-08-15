package lotto.domain

class Buyer(pay: Int) {

    val purchasedCount = pay / LottoTicket.PRICE
}
