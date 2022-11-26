package lotto.view

import lotto.domain.lotto.Lotto

class LottoView {
    fun printLottoView(lotto: Lotto) {
        println("${lotto.lottoTicketContainer.size}개를 구매했습니다.")

        lotto.lottoTicketContainer.forEach { println(it) }
        println()
    }
}