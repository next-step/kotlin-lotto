package lotto.view

import lotto.Lotto

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
        var first = 0
        var second = 0
        var third = 0
        var fourth = 0

        lottos.forEach { lotto ->
            when (lotto.getContainLottoNumberSameCount(winningNumbers)) {
                Lotto.FOURTH_WINNING_NUMBER_SAME_COUNT -> fourth++
                Lotto.THIRD_WINNING_NUMBER_SAME_COUNT -> third++
                Lotto.SECOND_WINNING_NUMBER_SAME_COUNT -> second++
                Lotto.FIRST_WINNING_NUMBER_SAME_COUNT -> first++
            }
        }

        println("3개 일치 (5000원)- ${fourth}개")
        println("4개 일치 (50000원)- ${third}개")
        println("5개 일치 (1500000원)- ${second}개")
        println("6개 일치 (2000000000원)- ${first}개")
    }

    fun printWinningStatistics(fourth: Int = 0, third: Int = 0, second: Int = 0, first: Int = 0) {
        println("당첨 통계")
        println("---------")
        println("3개 일치 (5000원)- ${fourth}개")
        println("4개 일치 (50000원)- ${third}개")
        println("5개 일치 (1500000원)- ${second}개")
        println("6개 일치 (2000000000원)- ${first}개")
    }

    fun printRateOfReturn(rateOfReturn: Double) {
        println("총 수익률은 ${rateOfReturn}입니다.")
    }
}
