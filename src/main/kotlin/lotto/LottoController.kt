package lotto

import lotto.domain.LottoNumber
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
    val prizeNumbers = inputView.inputPrizeNumber().map {
        LottoNumber.from(it.toInt())
    }
    val bonusNumber = LottoNumber.from(inputView.inputBonusNumber())

    val ranks = lottoResult.getMyLottoesRanks(lottoes, WinningLotto(prizeNumbers, bonusNumber))
    outputView.printLottoesResult(money, ranks)
}
