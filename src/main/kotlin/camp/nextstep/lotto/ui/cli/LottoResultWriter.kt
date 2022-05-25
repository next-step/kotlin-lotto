package camp.nextstep.lotto.ui.cli

import camp.nextstep.lotto.ui.LottoResult

object LottoResultWriter {

    fun write(result: LottoResult) {
        println("당첨 통계")
        println("---------")
        for ((winnings, count) in result.winningsCountMap) {
            println("${winnings.matchedCount}개 일치 (${winnings.winnings}원) - ${count}개")
        }

        val earningRate = result.totalEarn / result.seed
        val explainRate = "기준이 1이기 때문에 결과적으로 " + if (earningRate > 1) "이익을 보았다는 의미)" else if (earningRate == 0) "본전이라는 의미)" else "손해라는 의미"
        println("총 수익률은 ${earningRate}입니다. ($explainRate)")
    }
}
