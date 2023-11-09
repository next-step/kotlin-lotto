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
        println("3개 일치 (${Rank.FOURTH.prize}원)- ${ranks.ranks[Rank.FOURTH]}개")
        println("4개 일치 (${Rank.THIRD.prize}원)- ${ranks.ranks[Rank.THIRD]}개")
        println("5개 일치 (${Rank.SECOND.prize}원)- ${ranks.ranks[Rank.SECOND]}개")
        println("6개 일치 (${Rank.FIRST.prize}원)- ${ranks.ranks[Rank.FIRST]}개")
        println("총 수익률은 ${ranks.rateOfReturn(payment)}입니다. ${hasBenefit(ranks.rateOfReturn(payment))}")
    }

    fun hasBenefit(rateOfReturn: Double): String {
        if (rateOfReturn < 1.0) {
            return "(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
        }
        return "개이득"
    }
}
