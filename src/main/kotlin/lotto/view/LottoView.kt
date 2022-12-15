package lotto.view

import lotto.domain.lotto.Lotto

class LottoView {
    fun printLottoView(lotto: Lotto) {
        println()
        println("수동으로 ${lotto.customLottoTicketCount}장, 자동으로 ${lotto.randomGeneratedLottoTicketCount}개를 구매했습니다.")

        lotto.lottoTicketContainer.forEach { println(it) }
        println()
    }
}
