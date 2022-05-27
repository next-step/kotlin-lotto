package lotto.view

import lotto.Lotto
import lotto.LottoRank
import lotto.LottoStatistic

object LottoOutputView {
    fun printPurchaseLotto(lottoCount: Int) {
        println("${lottoCount}개를 구매했습니다.")
    }

    fun printLottoNumbers(lottos: List<Lotto>) {
        lottos.forEach { lotto ->
            println(lotto.numbers.sorted())
        }
    }

    fun printWinningStatistics(lottos: List<Lotto>, winningNumbers: List<Int>) {
        println("당첨 통계")
        println("---------")

        LottoRank.values().forEach { lottoRank ->
            val count = LottoStatistic.getLottoWinningCountOfLottoRank(
                lottos = lottos,
                winningNumbers = winningNumbers,
                lottoRank = lottoRank
            )
            println("${lottoRank.sameCount}개 일치 (${lottoRank.price}원)- ${count}개")
        }
    }

    fun printRateOfReturn(rateOfReturn: Double) {
        println("총 수익률은 ${rateOfReturn}입니다.")
    }
}
