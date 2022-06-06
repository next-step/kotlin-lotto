package lotto.view

import lotto.model.Lottos
import lotto.model.WinningStatistics

interface ResultView {

    fun printPurchasedLottoCount(lottoCount: Int)

    fun printPurchasedLottos(lottos: Lottos)

    fun printWinningStatistics(paymentPrice: Int, statistics: WinningStatistics)
}
