package lotto

import lotto.domain.*
import lotto.ui.InputView
import lotto.ui.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val lottoStore = LottoStore()
    val lottoResult = LottoResult()
    var purchasedManualLottoes: Lottoes = Lottoes(emptyList())
    var purchasedAutoLottoes: Lottoes? = Lottoes(emptyList())

    val money = Money(inputView.inputMoney())

    val numberOfManual = inputView.inputNumberOfManual()
    if (numberOfManual > 0) {
        val stringManualNumbers = inputView.inputManualNumbers(numberOfManual)
        val manualNumbers = stringManualNumbers.map { strings ->
            convertStringToInt(strings)
        }
        purchasedManualLottoes = lottoStore.purchaseManual(money, numberOfManual, manualNumbers)
    }

    purchasedAutoLottoes = lottoStore.purchaseAuto(money)
    outputView.printPurchasedLottoes(purchasedManualLottoes, purchasedAutoLottoes)

    val universalLottoes = Lottoes(purchasedManualLottoes.toList() + purchasedAutoLottoes.toList())

    val prizeNumbers = inputView.inputPrizeNumber().map {
        LottoNumber.from(it.toInt())
    }
    val bonusNumber = LottoNumber.from(inputView.inputBonusNumber())

    val ranks = lottoResult.getMyLottoesRanks(universalLottoes, WinningLotto(prizeNumbers, bonusNumber))
    outputView.printLottoesResult(money, ranks)
}

private fun convertStringToInt(strings: List<String>): List<Int> {
    return strings.map {
        it.toInt()
    }
}
