package lotto

import lotto.domain.*
import lotto.view.inputMoney
import lotto.view.inputWinningLottoNumbers
import lotto.view.printLottos
import lotto.view.printResult

fun main() {
    val purchase = Money(inputMoney())
    val count = (purchase / Lotto.PRICE)

    val lottos = Lottos((0 until count)
        .map { RandomLottoGenerator.generate() })

    printLottos(lottos)

    val winningNumbers = inputWinningLottoNumbers()
        .map { LottoNumber.of(it) }
        .toSet()
    val winningLotto = Lotto(winningNumbers)

    val result = lottos.match(winningLotto)
    printResult(result)
}
