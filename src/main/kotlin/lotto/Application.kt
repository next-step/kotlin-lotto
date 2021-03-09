package lotto

import lotto.domain.*
import lotto.view.*

fun main() {
    val purchase = Money(inputMoney())
    val count = (purchase / Lotto.PRICE).toInt()

    val lottos = Lottos(
        (0 until count).map { RandomLottoGenerator.generate() }
    )

    printLottos(lottos)

    val winningNumbers = inputWinningLottoNumbers()
        .map { LottoNumber.of(it) }
        .toSet()
    val winningLotto = Lotto(winningNumbers)

    val result = lottos.match(winningLotto)
    printResult(result)

    val yield = result.calculateYield(purchase)
    printYield(`yield`)
}
