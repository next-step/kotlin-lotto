package lotto.view

import lotto.domain.LottoResult
import lotto.domain.Lottos
import lotto.domain.Prize

class ResultView {

    fun printBoughtResult(lottos: Lottos) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach {
            println(it.numbers)
        }
        println()
    }

    fun printLottoResult(result: LottoResult) {
        println("당첨 통계")
        println("---------")
        val prizes = Prize.all()
        for (prize in prizes) {
            val count = result.same(prize.matchCount)
            println("${prize.matchCount}개 일치 (${prize.money}원)- ${count}개")
        }
    }
}
