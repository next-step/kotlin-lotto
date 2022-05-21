package lotto.view

import lotto.LottoTicket

class ResultView {

    fun printPurchaseAmount(amount: Int) {
        println("${amount}개를 구입했습니다.")
    }

    fun printPurchaseLottoTickets(lottoTickets: List<LottoTicket>) {
        lottoTickets.map {
            println(it.numbers)
        }
    }
}
