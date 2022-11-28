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

    fun printResult(ranks: Ranks) {
        println("당첨 통계")
        println("----------")
        println("${Rank.FIFTH.countOfMatch}개 일치 (${Rank.FIFTH.winningMoney}원)- ${ranks.rankCount(Rank.FIFTH)}개")
        println("${Rank.FOURTH.countOfMatch}개 일치 (${Rank.FOURTH.winningMoney}원)- ${ranks.rankCount(Rank.FOURTH)}개")
        println("${Rank.THIRD.countOfMatch}개 일치 (${Rank.THIRD.winningMoney}원)- ${ranks.rankCount(Rank.THIRD)}개")
        println("${Rank.SECOND.countOfMatch}개 일치, 보너스 볼 일치 (${Rank.SECOND.winningMoney}원)- ${ranks.rankCount(Rank.FIFTH)}개")
        println("${Rank.FIRST.countOfMatch}개 일치 (${Rank.FIRST.winningMoney}원)- ${ranks.rankCount(Rank.FIRST)}개")
    }

    fun printYield(yield: Double) {
        println("총 수익률은 ${`yield`}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}