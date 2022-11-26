package lotto.view

import lotto.domain.lotto.Lotto

class LottoView {
    fun printLottoView(lotto: Lotto) {
        println("${lotto.lottoTicketList.size}개를 구매했습니다.")

        lotto.lottoTicketList.forEach { println(it) }
    }
}