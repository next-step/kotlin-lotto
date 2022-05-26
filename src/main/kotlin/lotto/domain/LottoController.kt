package lotto.domain

import lotto.view.InputView
import lotto.view.PrintOutput
import lotto.view.ReadInput
import lotto.view.ResultView

class LottoController(private val readInput: ReadInput, private val printOutput: PrintOutput) {
    fun start() {
        // 구입할 로또 갯수 입력(View)
        val inputView = InputView(readInput)
        val purchaseAmount = inputView.askPurchaseAmount()

        // 로또 구입(Model)
        val seller = Seller(RandomLottoNumberFactory())
        val lottos = seller.sell(purchaseAmount)

        // 구입한 로또를 사용자에게 출력(View)
        val resultView = ResultView(printOutput)
        resultView.showLottos(lottos)

        // 지난 주 당첨 번호를 입력(View)
        val lastWeekWinningNumber = inputView.askLastWeekWinningNumber()

        // 보너스 볼을 입력(View)
        val bonusNumber = inputView.askBonusNumber()

        // 로또 분석(Model)
        val winningNumber = WinningNumber(lastWeekWinningNumber)
        val result = winningNumber.match(purchaseAmount, lottos)

        // 당첨 통계를 사용자에게 출력(View)
        resultView.showAnalyzeResult(result)
    }
}
