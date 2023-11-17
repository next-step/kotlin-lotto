package lottoAuto.view

import lottoAuto.domain.Lotto
import lottoAuto.domain.LottoRank
import lottoAuto.domain.LottoStatsEngine

object OutputView {
    fun printNumOfLotto(numOfLotto: Int) {
        println("${numOfLotto}개를 구매했습니다.")
    }

    fun printLottoNumbers(lottos: List<Lotto>) {
        lottos.forEach {
            println(it.lottoNumbers.map { lottoNumber -> lottoNumber.number })
        }
    }

    fun printLottoStatistics(lottoRanks: List<LottoRank>) {
        println("\n당첨 통계")
        println("---------")
        val lottoRankGroup = LottoStatsEngine.groupByLottoRank(lottoRanks)
        lottoRankGroup
            .entries
            .filterNot { it.key == LottoRank.MISS }
            .forEach {
                println("${it.key.matchCount}개 일치 (${it.key.winningMoney}원) - ${it.value}개")
            }
    }

    fun printRateOfReturn(purchaseAmount: Int, lottoRanks: List<LottoRank>) {
        val totalWinningMoney = lottoRanks.sumOf { it.winningMoney }
        val rateOfReturn = LottoStatsEngine.calcRateOfReturn(purchaseAmount, totalWinningMoney)
        val profitOrNot = when {
            rateOfReturn > 1.00 -> "이익"
            rateOfReturn == 1.00 -> "본전"
            else -> "손해"
        }
        println("총 수익률은 ${rateOfReturn}입니다.(기준이 1이기 때문에 결과적으로 ${profitOrNot}(이)라는 의미임)")
    }
}
