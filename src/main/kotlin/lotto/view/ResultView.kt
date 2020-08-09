package lotto.view

import lotto.domain.Lottos
import lotto.domain.Rank
import java.math.BigDecimal

object ResultView {
    fun showOrderDetail(manualOrder: Int, totalQuantity: Int) {
        println("\n수동으로 ${manualOrder}장, 자동으로 ${totalQuantity - manualOrder}장을 구매했습니다.")
    }

    fun showLottosDetail(lottos: Lottos) {
        println(lottos)
    }

    fun showResult(result: Map<Rank, Int>) {
        println("\n당첨 통계\n---------")
        printResult(result)
    }

    fun showProfitRatio(ratio: BigDecimal) {
        print("총 수익률은 ${ratio}입니다.(기준이 1이기 때문에 결과적으로 ")

        if (BigDecimal.ONE > ratio) {
            println("손해라는 의미임)")
        } else {
            println("이득이라는 의미임)")
        }
    }

    private fun printResult(result: Map<Rank, Int>) {
        result.forEach { (key, value) ->
            if (key != Rank.SECOND) {
                println("${key.matchCount}개 일치 (${key.prizeMoney}원)- ${value}개")
            } else {
                println("${key.matchCount}개 일치, 보너스 볼 일치(${key.prizeMoney}원)- ${value}개")
            }
        }
    }
}
