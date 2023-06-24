package lotto

import lotto.domain.LottoShop
import lotto.domain.LottoStatistics
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchaseAmount = InputView.getPurchaseAmount()
    val lottoNumbersList = LottoShop.getLottoNumbers(LottoShop.getNumberOfPurchase(purchaseAmount))
    ResultView.printPurchaseResult(lottoNumbersList)
    val lastWinningNumbers = InputView.parseWinningNumbers(InputView.getLastWinningNumbers())
    val winnersMap = LottoStatistics.getLottoWinnerList(lastWinningNumbers, lottoNumbersList)
    ResultView.printWinningResultComment()
    ResultView.printWinningResultStatistics(winnersMap)
    ResultView.printRateOfReturn(LottoStatistics.getRateOfReturn(winnersMap, purchaseAmount))
}
