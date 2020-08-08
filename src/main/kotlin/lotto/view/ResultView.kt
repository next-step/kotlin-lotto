package lotto.view

import lotto.domain.Lottos
import lotto.domain.Rank
import java.math.BigDecimal

object ResultView {

    fun showPurchasedQuantity(amount: Int) {
        println("${amount}개를 구매했습니다.")
    }

    fun showLottosDetail(lottos: Lottos) {
        println(lottos)
    }

    fun showResults(result: Map<Rank, Int>) {
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
                println("${key.condition}개 일치 (${key.prizeMoney}원)- ${value}개")
            } else {
                println("${key.condition}개 일치, 보너스 볼 일치(${key.prizeMoney}원)- ${value}개")
            }
        }
    }
}
