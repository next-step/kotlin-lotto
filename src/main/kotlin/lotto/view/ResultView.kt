package lotto.view

import lotto.model.Lottos
import lotto.model.WinningRank

interface ResultView {

    fun printPurchasedLottoCount(lottoCount: Int)

    fun printPurchasedLottos(lottos: Lottos)

    fun printWinningStatistics(paymentPrice: Int, winningRanks: List<WinningRank>)
}
