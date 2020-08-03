package view

import model.Lotto
import model.LottoPrize

class ResultView {
    fun showLottoList(list: List<Lotto>) {
        for (lotto in list) {
            println(lotto.lottoNumber)
        }
        println()
    }

    fun showPrizeList(prizeStatList: List<Pair<LottoPrize, Int>>) {
        println(
            "당첨 통계\n" +
                "---------"
        )
        for (pair in prizeStatList) {
            println("${pair.first.grade}개 일치 (${pair.first.prizeMoney}원)- ${pair.second}개")
        }
    }

    fun showEarningRate(value: Double) {
        println("총 수익률은 ${value}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}
