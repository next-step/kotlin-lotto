package lotto

import lotto.domain.BuyPrice
import lotto.domain.ProfitRate
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
    val inputPrice = inputPrice() ?: 0

    val buyPrice = BuyPrice(inputPrice)
    val lottoCount = buyPrice.getLottoCount()
    printBoughtLotto(lottoCount)

    val lottoFactory = LottoFactory()
    val generateStrategy = LottoAutoGeneratorStrategy()

    val lotto = lottoFactory.generate(lottoCount, generateStrategy)

    printBoughtLottos(lotto.value)

    val winningNumbers = WinningLotto(inputWinningNumber()).winningNumbers
    val matching = lotto.matchWinningNumbers(winningNumbers)

    printLottoMatchResult(matching)
    printProfitRate(ProfitRate(matching, lottoCount).calculate())
}
