package lotto

import lotto.domain.LottoDrawMachine
import lotto.domain.LottoStore
import lotto.ui.LottoDrawResultPrinter
import lotto.ui.PurchaseAmountReader
import lotto.ui.PurchasedLottosPrinter
import lotto.ui.WinningNumberReader

fun main() {

    val purchaseAmount = PurchaseAmountReader.read()

    val lottos = LottoStore.buy(purchaseAmount)

    PurchasedLottosPrinter.print(lottos)

    println()

    val winningNumbers = WinningNumberReader.read()

    val lottoDrawMachine = LottoDrawMachine(winningNumbers)
    val lottoDrawResult = lottoDrawMachine.draw(lottos)

    LottoDrawResultPrinter.print(lottoDrawResult)
}
