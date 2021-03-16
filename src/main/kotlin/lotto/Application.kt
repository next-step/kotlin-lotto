package lotto

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottosMachine
import lotto.domain.Money
import lotto.domain.WinningLotto
import lotto.domain.lottogenerator.ManualLottoGenerator
import lotto.view.inputBonusNumber
import lotto.view.inputManualLottoCount
import lotto.view.inputManualLottoNumbers
import lotto.view.inputMoney
import lotto.view.inputWinningLottoNumbers
import lotto.view.printLottos
import lotto.view.printResult
import lotto.view.printStatistics

fun main() {
    val purchase = Money(inputMoney())

    val manualLottoCount = inputManualLottoCount()
    val manualLottoGenerators = (1..manualLottoCount).map { ManualLottoGenerator(inputManualLottoNumbers()) }

    val lottos = LottosMachine(purchase, manualLottoGenerators).create()
    printLottos(lottos)

    val winningNumbers = inputWinningLottoNumbers()
        .map { LottoNumber.of(it) }
        .toSet()
    val bonusNumber = inputBonusNumber()
    val winningLotto = WinningLotto(Lotto(winningNumbers), LottoNumber.of(bonusNumber))

    val result = lottos.match(winningLotto)
    printResult(result)

    val statistics = result.calculateStatistics(purchase)
    printStatistics(statistics)
}
