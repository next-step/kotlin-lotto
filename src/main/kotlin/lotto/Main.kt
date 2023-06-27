package lotto

import lotto.domain.Lotto
import lotto.domain.LottoDrawMachine
import lotto.domain.LottoNumber
import lotto.domain.LottoStore
import lotto.domain.WinningLotto
import lotto.ui.LottoDrawResultPrinter
import lotto.ui.PurchaseReader
import lotto.ui.PurchasedLottosPrinter
import lotto.ui.WinningLottoReader

fun main() {

    val purchaseAmount: Int = PurchaseReader.auto()

    val auto = LottoStore.auto(purchaseAmount)

    val manualNumbers: List<List<Int>> = PurchaseReader.manual()

    val manual = manualNumbers.map { LottoStore.manual(it) }

    PurchasedLottosPrinter.print(auto, manual)

    println()

    val winningNumbers = WinningLottoReader.winningNumbers().map { LottoNumber(it) }

    val bonusNumber = WinningLottoReader.bonusNumber()

    val winningLotto = WinningLotto(Lotto.from(winningNumbers), LottoNumber(bonusNumber))

    val lottoDrawMachine = LottoDrawMachine(winningLotto)
    val lottoDrawResult = lottoDrawMachine.draw(listOf(auto, manual).flatten())

    LottoDrawResultPrinter.print(lottoDrawResult)
}
