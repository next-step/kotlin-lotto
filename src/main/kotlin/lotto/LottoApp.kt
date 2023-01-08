package lotto

import lotto.domain.BuyPrice
import lotto.domain.LottoResult
import lotto.domain.WinningLotto
import lotto.domain.strategy.LottoAutoGeneratorStrategy
import lotto.domain.strategy.LottoFactory
import lotto.ui.InputViews.inputPrice
import lotto.ui.InputViews.inputWinningNumber
import lotto.ui.OutputViews.printBoughtLotto
import lotto.ui.OutputViews.printBoughtLottos
import lotto.ui.OutputViews.printLottoMatchResult
import lotto.ui.OutputViews.printProfitRate

fun main() {
    val inputPrice = inputPrice()

    val buyPrice = BuyPrice(inputPrice)
    val lottoCount = buyPrice.getLottoCount()
    printBoughtLotto(lottoCount)

    val lottoFactory = LottoFactory()
    val generateStrategy = LottoAutoGeneratorStrategy()

    val lottos = lottoFactory.generate(lottoCount, generateStrategy)

    printBoughtLottos(lottos.value)

    val winningNumbers = WinningLotto.of(inputWinningNumber())
    val matching = lottos.matchWinningNumbers(winningNumbers)

    printLottoMatchResult(matching)
    printProfitRate(LottoResult(matching, inputPrice).calculate())
}
