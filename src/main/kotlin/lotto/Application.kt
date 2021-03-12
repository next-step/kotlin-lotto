package lotto

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.Lottos
import lotto.domain.Money
import lotto.domain.RandomLottoGenerator
import lotto.domain.WinningLotto
import lotto.view.inputBonusNumber
import lotto.view.inputMoney
import lotto.view.inputWinningLottoNumbers
import lotto.view.printLottos
import lotto.view.printResult
import lotto.view.printStatistics

fun main() {
    val purchase = Money(inputMoney())
    val count = (purchase / Lotto.PRICE).toInt()

    val lottos = Lottos((1..count).map { RandomLottoGenerator.generate() })
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
