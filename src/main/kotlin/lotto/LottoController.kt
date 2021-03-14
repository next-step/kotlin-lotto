package lotto

import lotto.domain.LottoNumber
import lotto.domain.LottoResult
import lotto.domain.LottoStore
import lotto.domain.LottoStore.Companion.LOTTO_COST
import lotto.domain.LottoTicket
import lotto.domain.Lottoes
import lotto.domain.Money
import lotto.domain.WinningLotto
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
        if (numberOfManual * LOTTO_COST > money.currentMoney) throw RuntimeException("사고자 하는 수량이 현재 가진 돈보다 많습니다.")
        val stringManualNumbers = inputView.inputManualNumbers(numberOfManual)
        val manualNumbers = stringManualNumbers.map { strings ->
            convertStringToInt(strings)
        }
        purchasedManualLottoes = lottoStore.purchaseManual(money, numberOfManual, manualNumbers)
    }

    purchasedAutoLottoes = lottoStore.purchaseAuto(money)
    outputView.printPurchasedLottoes(purchasedManualLottoes, purchasedAutoLottoes)

    val universalLottoes = Lottoes(purchasedManualLottoes.toList() + purchasedAutoLottoes.toList())

    val winningNumbers = LottoTicket(inputView.inputPrizeNumber().map {
        LottoNumber.from(it.toInt())
    })
    val bonusNumber = LottoNumber.from(inputView.inputBonusNumber())

    val ranks = lottoResult.getMyLottoesRanks(universalLottoes, WinningLotto(winningNumbers, bonusNumber))
    outputView.printLottoesResult(money, ranks)
}

private fun convertStringToInt(strings: List<String>): List<Int> {
    return strings.map {
        it.toInt()
    }
}
