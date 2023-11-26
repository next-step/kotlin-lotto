package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoPrize
import lotto.domain.LottoResult
import lotto.domain.Money

object ResultView {
    fun printLottoList(manual: List<Lotto>, auto: List<Lotto>): List<Lotto> {
        println("수동으로 ${manual.size}개,자동으로 ${auto.size}개를 구매했습니다.")
        val allLottos = manual + auto
        for (lotto in allLottos) {
            printLotto(lotto.lottoNumbers.toList())
        }
        return allLottos
    }

    private fun printLotto(numbers: List<LottoNumber>) {
        println("[${numbers.joinToString { it.number.toString() }}]")
    }

    fun outputResult(money: Money, result: LottoResult) {
        val resultString = buildString {
            appendLine("당첨 통계")
            appendLine("---------")
            for (rank in LottoPrize.rankOf()) {
                appendLine("${rank.text} (${rank.prizeMoney}원) - ${result.getResult(rank) ?: 0}개")
            }
            append("총 수익률은 %.2f입니다.".format(result.getProfitRate(money)))
        }

        println(resultString)
    }
}
