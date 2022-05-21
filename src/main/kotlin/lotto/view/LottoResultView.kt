package lotto.view

import lotto.LottoTicket

object LottoResultView {

    fun printPurchasedLottoInfo(lottos: List<LottoTicket>) {
        println("${lottos.size}개를 구매했습니다.")
        for (lotto in lottos) {
            println(lotto.numbers)
        }
    }
}
