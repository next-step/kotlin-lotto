package lotto.view

import lotto.domain.Statistics
import lotto.domain.entity.user.Lotto
import lotto.domain.enums.PrizeType

object ResultView {

    private const val DEFAULT_MESSAGE = "당첨 통계"
    private const val LOTTO_PURCHASES_MESSAGE = "개를 구입 하였습니다."

    fun lottoPurchasesCount(purchasesCount: Int) {
        println("$purchasesCount $LOTTO_PURCHASES_MESSAGE")
    }

    fun printUserLotto(userLotto: List<Lotto>) {
        userLotto.forEach { println(it.getLottoNumber().toString()) }
    }

    fun lottoResult(prizeResult: Map<PrizeType, Int>) {
        println(DEFAULT_MESSAGE)
        println("-------------------------------")

        prizeResult
            .forEach { println("${it.key.match} 개 일치 (${it.key.money})ㅡ ${it.value} 개") }
    }

    fun statistics(prizeAllMoney: Int, lottoBuyMoney: Int) {
        println("총 수익률은 ${Statistics.calculation(prizeAllMoney, lottoBuyMoney)} 입니다.")
    }
}
