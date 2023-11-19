package lotto.view

import lotto.Lotto
import lotto.LottoNumber
import lotto.LottoPrize
import lotto.LottoResult

object ResultView {
    fun printLottoList(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        for (lotto in lottos) {
            printLotto(lotto.lottoNumbers)
        }
    }

    private fun printLotto(numbers: List<LottoNumber>) {
        println("[${numbers.joinToString { it.number.toString() }}]")
    }

    fun printWinningResult(result: LottoResult, purchaseAmount: Int) {
        println("당첨 통계")
        println("------------")
        val ranks = LottoPrize.values().filter { it != LottoPrize.MISS }
        for (rank in ranks) {
            if (rank.prizeMoney == 30000000) {
                println("${rank.matchCount}개 일치, 보너스 볼 일치 (${rank.prizeMoney}원)- ${result.count(rank)}개")
            } else {
                println("${rank.matchCount}개 일치 (${rank.prizeMoney}원)- ${result.count(rank)}개")
            }
        }
        println("총 수익률은 ${result.getProfitRate(purchaseAmount)}입니다.")
    }
}
