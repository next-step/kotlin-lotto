package lotto

import lotto.domain.RandomLottoNumberFactory
import lotto.domain.Seller
import lotto.domain.WinningNumber
import lotto.view.InputView
import lotto.view.PrintOutput
import lotto.view.ReadInput
import lotto.view.ResultView

fun main() {
    // 구입할 로또 갯수 입력(View)
    val inputView = InputView(ReadInput())
    val purchaseAmount = inputView.askPurchaseAmount()

    // 로또 구입(Model)
    val seller = Seller(RandomLottoNumberFactory())
    val lottos = seller.sell(purchaseAmount)

    // 구입한 로또를 사용자에게 출력(View)
    val resultView = ResultView(PrintOutput())
    resultView.showLottos(lottos)

    // 지난 주 당첨 번호를 사용자에게 출력(View)
    val lastWeekWinningNumber = inputView.askLastWeekWinningNumber()

    // 로또 분석(Model)
    val winningNumber = WinningNumber(lastWeekWinningNumber)
    val result = winningNumber.match(purchaseAmount, lottos)

    // 당첨 통계를 사용자에게 출력(View)
    resultView.showAnalyzeResult(result)
}
