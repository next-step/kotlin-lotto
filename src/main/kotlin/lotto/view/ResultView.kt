package lotto.view

import lotto.domain.*

object ResultView {
    fun printLottoList(lottos: Set<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        for (lotto in lottos) {
            printLotto(lotto.lottoNumbers.toList())
        }
    }

    private fun printLotto(numbers: List<LottoNumber>) {
        println("[${numbers.joinToString { it.number.toString() }}]")
    }

    fun outputResult(money: Money, result: LottoResult) {
        println("당첨 통계")
        println("---------")
        for (rank in LottoPrize.rankOf()) {
            println("${rank.text} (${rank.prizeMoney}원) - ${result.getResult(rank)}개")
        }
        println("총 수익률은 %.2f입니다.".format(result.getProfitRate(money)))
    }
}
