package lotto.ui

import lotto.domain.Lottos
import lotto.domain.Rank

object ResultView {

    private const val LOTTO_NUMBERS_DELIMITER = ", "
    private const val LOTTO_NUMBERS_PREFIX = "["
    private const val LOTTO_NUMBERS_POSTFIX = "]"

    fun printLottos(manualLottos: Lottos, autoLottos: Lottos) {
        println()
        println("수동으로 ${manualLottos.count()}장, 자동으로 ${autoLottos.count()}개를 구매했습니다.")
        for (lotto in manualLottos.lottos + autoLottos.lottos) {
            val lottoNumbers = lotto.numbers.sortedBy { it.value }
            println(lottoNumbers.map { it.value }.joinToString(LOTTO_NUMBERS_DELIMITER, LOTTO_NUMBERS_PREFIX, LOTTO_NUMBERS_POSTFIX))
        }
        println()
    }

    fun printResult(lottos: Map<Rank, Int>) {
        println()
        println("당첨 통계")
        println("---------")
        println("${Rank.FIFTH.matchCount}개 일치 (${Rank.FIFTH.winningMoney}원)- ${lottos.getOrDefault(Rank.FIFTH, 0)}개")
        println("${Rank.FOURTH.matchCount}개 일치 (${Rank.FOURTH.winningMoney}원)- ${lottos.getOrDefault(Rank.FOURTH, 0)}개")
        println("${Rank.THIRD.matchCount}개 일치 (${Rank.THIRD.winningMoney}원)- ${lottos.getOrDefault(Rank.THIRD, 0)}개")
        println("${Rank.SECOND.matchCount}개 일치, 보너스 볼 일치(${Rank.SECOND.winningMoney}원)- ${lottos.getOrDefault(Rank.SECOND, 0)}개")
        println("${Rank.FIRST.matchCount}개 일치 (${Rank.FIRST.winningMoney}원)- ${lottos.getOrDefault(Rank.FIRST, 0)}개")
    }

    fun printEarningRate(earningRate: Double) {
        print("총 수익률은 ${earningRate}입니다.")
        if (earningRate > 1) {
            println("(기준이 1이기 때문에 결과적으로 이득이라는 의미임)")
        } else if (earningRate < 1) {
            println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
        } else {
            println("(기준이 1이기 때문에 결과적으로 본전이라는 의미임)")
        }
    }
}
