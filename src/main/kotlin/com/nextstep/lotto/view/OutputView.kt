package com.nextstep.lotto.view

import com.nextstep.lotto.domain.LottoStat
import com.nextstep.lotto.domain.Lottos

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
        println("3개 일치(5000원) - ${lottoStat.lottoCountOf(3)}개")
        println("4개 일치(50000원) - ${lottoStat.lottoCountOf(4)}개")
        println("5개 일치(1500000원) - ${lottoStat.lottoCountOf(5)}개")
        println("6개 일치(2000000000원) - ${lottoStat.lottoCountOf(6)}개")
        val profitRate = lottoStat.profitRate()
        print("총 수익률은 $profitRate 입니다.")
        if (profitRate < 1) println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}
