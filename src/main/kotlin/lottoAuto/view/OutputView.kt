package lottoAuto.view

import lottoAuto.domain.*

object OutputView {
    fun printNumOfLotto(numOfLotto: Int) {
        println("${numOfLotto}개를 구매했습니다.")
    }

    fun printLottoNumbers(lottos: List<Lotto>) {
        lottos.forEach {
            println(it.lottoNumbers.map { lottoNumber -> lottoNumber.number })
        }
    }

    fun printLottoStatistics(lottoRanks: LottoRanks) {
        println("\n당첨 통계")
        println("---------")
        val lottoRankGroup = lottoRanks.groupByLottoRank()
        lottoRankGroup
            .entries
            .filterNot { it.key == LottoRank.MISS }
            .forEach {
                println("${it.key.matchCount}개 일치 (${it.key.winningMoney}원) - ${it.value}개")
            }
    }

    fun printRateOfReturn(purchaseAmount: Int, lottoRanks: LottoRanks) {
        val totalWinningMoney = lottoRanks.getTotalWinningMoney()
        val profit = LottoProfitCalculator.calcProfit(purchaseAmount, totalWinningMoney)
        println("총 수익률은 ${profit.rateOfReturn}입니다.(기준이 1이기 때문에 결과적으로 ${profit.resultMsg}(이)라는 의미임)")
    }
}
