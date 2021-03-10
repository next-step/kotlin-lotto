package lotto

import lotto.domain.LottoResult
import lotto.domain.LottoStore
import lotto.domain.WinningLotto
import lotto.ui.InputView
import lotto.ui.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val lottoStore = LottoStore()
    val lottoResult = LottoResult()

    val money = inputView.inputMoney()
    val lottoes = lottoStore.purchaseAuto(money)

    outputView.printPurchasedLottoes(lottoes)
    val prizeNumbers = inputView.inputPrizeNumber()
    val bonusNumber = inputView.inputBonusNumber()

    val ranks = lottoResult.getMyLottoesRank(lottoes, WinningLotto(prizeNumbers, bonusNumber))
    outputView.printLottoesResult(money, ranks)
}
