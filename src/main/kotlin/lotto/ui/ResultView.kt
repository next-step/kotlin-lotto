package lotto.ui

import lotto.domain.Lotto
import lotto.domain.Rank

object ResultView {

    private const val LOTTO_NUMBERS_DELIMITER = ", "
    private const val LOTTO_NUMBERS_PREFIX = "["
    private const val LOTTO_NUMBERS_POSTFIX = "]"

    fun printLottos(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        for (lotto in lottos) {
            val lottoNumbers = lotto.numbers.sortedBy { it.value }
            println(lottoNumbers.map { it.value }.joinToString(LOTTO_NUMBERS_DELIMITER, LOTTO_NUMBERS_PREFIX, LOTTO_NUMBERS_POSTFIX))
        }
        println()
    }

    fun printResult(lottos: Map<Rank, Int>) {
        println("당첨 통계")
        println("---------")
        println("${Rank.FIFTH.matchCount}개 일치 (${Rank.FIFTH.winningMoney}원)- ${lottos.getOrDefault(Rank.FIFTH, 0)}개")
        println("${Rank.FOURTH.matchCount}개 일치 (${Rank.FOURTH.winningMoney}원)- ${lottos.getOrDefault(Rank.FOURTH, 0)}개")
        println("${Rank.THREE.matchCount}개 일치 (${Rank.THREE.winningMoney}원)- ${lottos.getOrDefault(Rank.THREE, 0)}개")
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
