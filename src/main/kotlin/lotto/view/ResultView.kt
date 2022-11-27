package lotto.view

import lotto.domain.Lotto
import lotto.domain.Rank
import lotto.domain.WinningStatistics
import java.math.BigDecimal

object ResultView {
    fun printNumberOfPurchases(amount: Int) {
        println("$amount 개를 구매했습니다.")
    }

    fun printRewardsStatistics(winningStatistics: WinningStatistics) {
        println("\n당첨 통계")
        println("---------")

        val result = Rank.values().filter { it != Rank.MISS }.sortedDescending()
        result.forEach {
            print("${it.numberOfMatch}개 일치")
            if (it == Rank.SECOND) print(", 보너스 볼 일치")
            print(" (${it.winningMoney}원)- ${winningStatistics.getNumberOfMatchCount(it)}개\n")
        }
    }

    fun printRateOfReturn(rateOfReturn: BigDecimal) {
        print("총 수익률은 $rateOfReturn 입니다.")
        if (rateOfReturn < BigDecimal(1)) println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }

    fun printPurchasedLotto(myLotteries: List<Lotto>) {
        myLotteries.forEach { lotto ->
            val sortedValue = lotto.lottoNumbers.sortedWith(compareBy { it.number })
            println("[${sortedValue.joinToString(", ")}]")
        }
    }
}
