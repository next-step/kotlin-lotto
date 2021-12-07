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

        println("3개 일치 (${PrizeType.FIFTH_PLACE.money}) - ${prizeResult[PrizeType.FIFTH_PLACE] ?: 0}")
        println("4개 일치 (${PrizeType.FOURTH_PLACE.money}) - ${prizeResult[PrizeType.FOURTH_PLACE] ?: 0}")
        println("5개 일치 (${PrizeType.THIRD_PLACE.money}) - ${prizeResult[PrizeType.THIRD_PLACE] ?: 0}")
        println("5개 일치, 보너스 볼 일치 (${PrizeType.SECOND_PLACE.money}) - ${prizeResult[PrizeType.SECOND_PLACE] ?: 0}")
        println("6개 일치 (${PrizeType.FIRST_PLACE.money}) - ${prizeResult[PrizeType.FIRST_PLACE] ?: 0}")
    }

    fun statistics(prizeAllMoney: Int, lottoBuyMoney: Int) {
        println("총 수익률은 ${Statistics.calculation(prizeAllMoney, lottoBuyMoney)} 입니다.")
    }
}
