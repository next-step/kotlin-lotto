package lotto

import lotto.domain.LottoDrawMachine
import lotto.domain.LottoStore
import lotto.ui.LottoDrawResultPrinter
import lotto.ui.PurchaseAutoReader
import lotto.ui.PurchaseManualReader
import lotto.ui.PurchasedLottosPrinter
import lotto.ui.WinningNumberReader

fun main() {

    val purchaseAmount: Int = PurchaseAutoReader.auto()

    val auto = LottoStore.buy(purchaseAmount)

    val manual = PurchaseManualReader.manual()

    PurchasedLottosPrinter.print(auto, manual)

    println()

    val winningNumbers = WinningNumberReader.read()

    val lottoDrawMachine = LottoDrawMachine(winningNumbers)
    val lottoDrawResult = lottoDrawMachine.draw(listOf(auto, manual).flatten())

    LottoDrawResultPrinter.print(lottoDrawResult)
}
