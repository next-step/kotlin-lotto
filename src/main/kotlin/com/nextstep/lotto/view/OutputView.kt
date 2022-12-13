package com.nextstep.lotto.view

import com.nextstep.lotto.domain.Lottos

class OutputView {

    fun printLottoTicketCount(count: Int, lottos: Lottos) {
        println("${count}개를 구매했습니다.")
        lottos.lottos.forEach { println(it.getNumbers()) }
    }
}
