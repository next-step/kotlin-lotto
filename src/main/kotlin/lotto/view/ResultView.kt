package lotto.view

import lotto.domain.Lotto
import lotto.domain.enums.PrizeType

object ResultView {

    private const val DEFAULT_MESSAGE = "당첨 통계"

    fun printUserLotto(userLotto: List<Lotto>) {
        userLotto.forEach { println(it.lottoNumber.toString()) }
    }

    fun lottoResult(prizeResult: MutableMap<Int, Int>) {
        println(DEFAULT_MESSAGE)
        println("-------------------------------")

        prizeResult
            .filter { it.key >= 3 }
            .forEach { println("${it.key} 개 일치 (${PrizeType.findPrizeMoney(it.key)})ㅡ ${it.value} 개") }
    }

    fun statistics(prizeAllMoney: Int, lottoBuyMoney: Int) {
        println("총 수익률은 (${prizeAllMoney.toDouble() / lottoBuyMoney.toDouble()}) 입니다.")
    }
}
