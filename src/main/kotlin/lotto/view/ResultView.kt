package lotto.view

import lotto.model.Lottos
import lotto.model.WinningStatistics

interface ResultView {

    fun printLottoCount(customLottoCount: Int, randomLottoCount: Int)

    fun printTotalLottos(lottos: Lottos)

    fun printWinningStatistics(paymentPrice: Int, statistics: WinningStatistics)
}
