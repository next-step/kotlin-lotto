package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoResult
import lotto.domain.MatchCount

object OutputView {

    fun outputBuyResult(lottoCount: Int, lotteries: List<Lotto>) {
        println("${lottoCount}개를 구매했습니다.")
        lotteries.forEach {
            println(it.numbers.sorted())
        }
        println()
    }

    fun outputLottoResult(result: LottoResult, strategy: Map<MatchCount, Int>) {
        println()
        println("당첨 통계")
        println("---------")
        strategy.entries
            .sortedBy { it.key.matchCount }
            .map { outputLottoResultSeperate(it.key, it.value, result.earnResult) }
            .forEach { println(it) }
        println("총 수익률은 ${result.earningRate}입니다.")
    }

    private fun outputLottoResultSeperate(matchCount: MatchCount, amount: Int, earnResult: Map<MatchCount, Int>): String{
        if (matchCount.isMatchBonus) {
            return "${matchCount.matchCount}개 일치, 보너스 볼 일치(${amount}원)- ${earnResult[matchCount] ?: 0}개"
        }
        return "${matchCount.matchCount}개 일치 (${amount}원)- ${earnResult[matchCount] ?: 0}개"
    }
}
