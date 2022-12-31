package com.nextstep.lotto.view

import com.nextstep.lotto.domain.LottoStat
import com.nextstep.lotto.domain.Lottos
import com.nextstep.lotto.domain.Rank

class OutputView {

    fun printLottoTicketCount(lottos: Lottos) {
        println("${lottos.getCount()}개를 구매했습니다.")
        lottos.lottos.forEach { println(it.getNumbers()) }
        println()
    }

    fun printResult(lottoStat: LottoStat) {
        println()
        println("당첨 통계")
        println("---------")

        (3..6).forEach {
            println("${it}개 일치(${Rank.from(it).prize}원) - ${lottoStat.lottoCountOf(it)}개")
        }

        val profitRate = lottoStat.profitRate()
        print("총 수익률은 $profitRate 입니다.")
        if (profitRate < 1) println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}
