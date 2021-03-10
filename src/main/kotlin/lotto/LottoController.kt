package lotto

import lotto.domain.LottoResult
import lotto.domain.LottoStore
import lotto.ui.InputView
import lotto.ui.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val lottoStore = LottoStore()
    val lottoResult = LottoResult()

    val money = inputView.inputMoney()
    val lottoes = lottoStore.purchaseAuto(money)

    outputView.printPurchasedQuantity(lottoes.toList().size)
    outputView.printPurchasedLottos(lottoes)
    val prizeNumbers = inputView.inputPrizeNumber()
    val bonusNumber = inputView.inputBonusNumber()

    val ranks = lottoResult.getMyLottoesRank(lottoes, prizeNumbers, bonusNumber)
    outputView.printLottoesResult(ranks)
    val prizeMoney = ranks.sumBy { rank ->
        rank.prizeMoney
    }

    outputView.printRateOfReturn(money, prizeMoney)
}
