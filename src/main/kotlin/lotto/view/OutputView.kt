package lotto.view

import lotto.domain.Lotto
import lotto.domain.Rank
import lotto.domain.Ranks

class OutputView {

    fun printLottos(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach(::printLotto)
        println()
    }

    fun printLotto(lotto: Lotto) {
        println("[${lotto.numbers.sorted().joinToString(", ")}]")
    }

    fun printResult(ranks: Ranks, payment: Int) {
        println("당첨 통계")
        println("---------")
        Rank.values().reversed().forEach { rank ->
            if(Rank.SECOND == rank) println("${rank.matchCount}개 일치, 보너스 볼 일치(${rank.prize}원)- ${ranks.ranks[rank]?:0}개")
            else if(Rank.NO_RANK != rank) println("${rank.matchCount}개 일치 (${rank.prize}원)- ${ranks.ranks[rank]?:0}개")
        }
        println("총 수익률은 ${ranks.rateOfReturn(payment)}입니다. ${hasBenefit(ranks.rateOfReturn(payment))}")
    }

    fun hasBenefit(rateOfReturn: Double): String {
        if (rateOfReturn < 1.0) {
            return "(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
        }
        return "개이득"
    }
}
