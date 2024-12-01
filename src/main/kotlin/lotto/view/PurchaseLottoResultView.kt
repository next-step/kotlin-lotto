package lotto.view

import lotto.domain.PurchasedLottoTickets

object PurchaseLottoResultView {
    fun view(purchasedLottoTickets: PurchasedLottoTickets) {
        println("${purchasedLottoTickets.purchasedCount}개를 구매했습니다.")
        purchasedLottoTickets.purchasedLottoTickets.forEach { lottoTicket -> println(lottoTicket.lottoNumbers) }
    }
}
