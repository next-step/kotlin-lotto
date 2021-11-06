package lotto.view

import lotto.domain.Lotto
import lotto.domain.Rank
import lotto.domain.Rank.FIFTH
import lotto.domain.Rank.FIRST
import lotto.domain.Rank.FOURTH
import lotto.domain.Rank.SECOND
import lotto.domain.Rank.THIRD

class OutputView {

    companion object {
        private const val SEPARATOR = ", "
        private const val PREFIX = "["
        private const val POSTFIX = "]"
        private const val PRINT_LOTTO_RESULT = "당첨 통계"

        fun printBoughtLottoCount(manualLottoCount: Int, autoLottoCount: Int) {
            println("수동으로 ${manualLottoCount}장, 자동으로 ${autoLottoCount}개를 구매했습니다.")
        }

        fun printBoughtLottos(lottos: List<Lotto>) {
            repeat(lottos.size) {
                val lotto: Lotto = lottos[it]
                println(lotto.getLottoNumbers().joinToString(SEPARATOR, PREFIX, POSTFIX))
            }
        }

        fun printLottoMatchResult(matchResult: Map<Rank, Int>) {
            println(PRINT_LOTTO_RESULT)
            println("---------")
            println("${FIFTH.matchCount}개 일치 (${FIFTH.winningMoney}원) - ${matchResult[FIFTH] ?: 0}개")
            println("${FOURTH.matchCount}개 일치 (${FOURTH.winningMoney}원) - ${matchResult[FOURTH] ?: 0}개")
            println("${THIRD.matchCount}개 일치 (${THIRD.winningMoney}원) - ${matchResult[THIRD] ?: 0}개")
            println("${SECOND.matchCount}개 일치, 보너스 볼 일치 (${SECOND.winningMoney}원) - ${matchResult[SECOND] ?: 0}개")
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
}
