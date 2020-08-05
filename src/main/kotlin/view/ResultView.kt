package view

import model.Lotto
import model.PrizeEarn

object ResultView {
    fun showLottoList(list: List<Lotto>) {
        for (lotto in list) {
            println(lotto.lottoNumber)
        }
        println()
    }

    fun showPrizeList(prizeStatList: List<PrizeEarn>) {
        println(
            "당첨 통계\n" +
                "---------"
        )
        for (prizeEarn in prizeStatList) {
            println("${prizeEarn.grade}개 일치 (${prizeEarn.prizeMoney}원)- ${prizeEarn.count}개")
        }
    }

    fun showEarningRate(value: Double) {
        println("총 수익률은 ${value}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}
