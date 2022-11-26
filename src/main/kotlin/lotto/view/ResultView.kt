package lotto.view

import lotto.domain.LottoNumbers
import lotto.domain.Rank
import lotto.domain.Rewards
import kotlin.math.floor

object ResultView {
    fun printPurchasedLotto(myLotto: List<LottoNumbers>) {
        myLotto.forEach {
            val sortedValue = it.value.sorted()
            println("[${sortedValue.joinToString(", ")}]")
        }
    }

    fun printNumberOfPurchases(amount: Int) {
        println("$amount 개를 구매했습니다.")
    }

    fun printRewardsStatistics(rewards: Rewards) {
        println("당첨 통계")
        println("---------")
        println("3개 일치 (5000원)- ${rewards.value.filter { it == Rank.FOURTH }.size}개")
        println("4개 일치 (50000원)- ${rewards.value.filter { it == Rank.THIRD }.size}개")
        println("5개 일치 (1500000원)- ${rewards.value.filter { it == Rank.SECOND }.size}개")
        println("6개 일치 (2000000000원)- ${rewards.value.filter { it == Rank.FIRST }.size}개")
    }

    fun printRateOfReturn(rateOfReturn: Double) {
        val value = floor(rateOfReturn * 100) / 100
        print("총 수익률은 $value 입니다.")
        if (value < 1.0) println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}
