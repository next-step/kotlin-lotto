package lotto.ui

import lotto.domain.LottoNumber
import lotto.domain.Ranking
import lotto.domain.Ranking.*

object OutputViews {

    private const val SEPARATOR = ", "
    private const val PREFIX = "["
    private const val POSTFIX = "]"
    private const val PRINT_LOTTO_RESULT = "당첨 통계"

    fun printBoughtLottos(lotto: List<LottoNumber>) {
        repeat(lotto.size) {
            val lottery = lotto[it]
            println(lottery.value.joinToString(SEPARATOR, PREFIX, POSTFIX))
        }
    }

    fun printLottoMatchResult(matchResult: Map<Ranking, Int>) {
        println(PRINT_LOTTO_RESULT)
        println("---------")
        println("${FOURTH.matchCount}개 일치 (${FOURTH.winningMoney}원) - ${matchResult[FOURTH] ?: 0}개")
        println("${THIRD.matchCount}개 일치 (${THIRD.winningMoney}원) - ${matchResult[THIRD] ?: 0}개")
        println("${SECOND.matchCount}개 일치 (${SECOND.winningMoney}원) - ${matchResult[SECOND] ?: 0}개")
        println("${FIRST.matchCount}개 일치 (${FIRST.winningMoney}원) - ${matchResult[FIRST] ?: 0}개")
    }

    fun printProfitRate(profitRate: Double) {
        val result = if (profitRate >= 1.0) {
            "이득"
        } else {
            "손해"
        }

        println("총 수익률은 ${profitRate}입니다. (기준이 1이기 때문에 결과적으로 ${result}라는 의미임)")
    }
}
