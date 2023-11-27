package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoResult

object OutputView {

    fun outputBuyResult(lottoCount: Int, lotteries: List<Lotto>) {
        println("${lottoCount}개를 구매했습니다.")
        lotteries.forEach {
            println(it.numbers)
        }
        println()
    }

    fun outputLottoResult(result: LottoResult, strategy: Map<Int, Int>) {
        println()
        println("당첨 통계")
        println("---------")
        strategy.entries
            .sortedBy { it.key }
            .map { "${it.key}개 일치 (${it.value}원)- ${result.earnResult[it.key] ?: 0}개" }
            .forEach { println(it) }
        println("총 수익률은 ${result.earningRate}입니다.")
    }
}
