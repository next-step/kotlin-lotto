package lotto.view

import lotto.domain.LottoPurchaseAmount
import lotto.domain.LottoUser

object ResultView {
    fun printLottoPurchaseAmount(purchaseAmount: LottoPurchaseAmount) {
        val totalLottoCount = purchaseAmount.calculateLottoCount()
        println("${totalLottoCount}개를 구매했습니다.")
    }

    fun printLotteries(lottoUser: LottoUser) {
        lottoUser.lotteries.forEach {
            println(it.values)
        }
        println()
    }
}
