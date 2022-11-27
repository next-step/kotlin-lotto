package simulator.io

import simulator.lotto.Lottos
import simulator.lotto.Rank
import simulator.lotto.Ranks

class Output {
    fun printLottos(lottos: Lottos) {
        lottos.values.forEach {
            println("[$it]")
        }
    }

    fun printTimes(times: Int) {
        println("${times}개를 구매했습니다.")
    }

    fun printResultHeader() {
        println("당첨 통계")
        println("----------")
    }

    fun printResult(ranks: Ranks, rank: Rank) {
        println("${rank.match()}개 일치 (${rank.prize()}원)- ${ranks.rankCount(rank)}개")
    }

    fun printYield(yield: Double) {
        println("총 수익률은 ${`yield`}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}