package step2Lotto.view

import step2Lotto.domain.dto.Lotto

class ResultView {
    fun showLottoTicketQuantity(lottoTicketQuantity: Int) {
        println("${lottoTicketQuantity}개를 구매했습니다.")
    }

    fun showLottoTickets(lottoTickets: List<Lotto>) {
        lottoTickets.forEach {
            println(it.numbers)
        }
    }
}
