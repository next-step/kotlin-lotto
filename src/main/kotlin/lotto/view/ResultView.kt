package lotto.view

import lotto.domain.Statistics
import lotto.domain.entity.user.Lotto
import lotto.domain.enums.PrizeType

object ResultView {

    private const val DEFAULT_MESSAGE = "당첨 통계"

    fun lottoPurchasesCount(manualCount: Int, purchasesCount: Int) {
        println("수동으로 ${manualCount}장, 자동으로 ${purchasesCount}개를 구매했습니다.")
    }

    fun printUserLotto(userLotto: List<Lotto>) {
        userLotto.forEach { println(it) }
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
