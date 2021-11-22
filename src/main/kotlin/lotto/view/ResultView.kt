package lotto.view

import lotto.domain.Statistics
import lotto.domain.lotto.Lotto
import lotto.domain.enums.PrizeType

object ResultView {

    private const val DEFAULT_MESSAGE = "당첨 통계"
    private const val LOTTO_PURCHASES_MESSAGE = "개를 구입 하였습니다."

    fun lottoPurchasesCount(purchasesCount: Int) {
        println("$purchasesCount $LOTTO_PURCHASES_MESSAGE")
    }

    fun printUserLotto(userLotto: List<Lotto>) {
        userLotto.forEach { println(it.lottoNumber.toString()) }
    }

    fun lottoResult(prizeResult: Map<Int, Int>) {
        println(DEFAULT_MESSAGE)
        println("-------------------------------")

        prizeResult
            .forEach { println("${it.key} 개 일치 (${PrizeType.findPrizeMoney(it.key)})ㅡ ${it.value} 개") }
    }

    fun statistics(prizeAllMoney: Int, lottoBuyMoney: Int) {
        println("총 수익률은 ${Statistics.calculation(prizeAllMoney, lottoBuyMoney)} 입니다.")
    }
}
