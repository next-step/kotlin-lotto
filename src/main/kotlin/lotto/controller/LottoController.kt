package lotto.controller

import lotto.domain.LottoCalculator
import lotto.domain.LottoFactory
import lotto.domain.LottoResult
import lotto.domain.data.Lotto
import lotto.view.InputView
import lotto.view.ResultView

class LottoController {
    fun start() {
        val totalPurchaseAmount = InputView.readTotalPurchaseAmountAsInt()
        val calculator = LottoCalculator(totalPurchaseAmount, 1000)
        val totalLottoCount = calculator.calculateLottoCount()
        // 총 구매 로또 개수
        ResultView.printTotalPurchaseCount(totalLottoCount)

        // 나의 로또 번호 리스트 출력
        val myLottoList = LottoFactory(totalLottoCount).createLottoList()
        ResultView.printLottoNumbers(myLottoList)

        // 결과 출력
        val winningNumbers = InputView.readWinningLotto(InputView.ENTER_LAST_WINNING_NUMBER)
        val result = LottoResult()
        ResultView.printLottoResult(
            resultMap = result.getResults(
                winningLotto = Lotto(winningNumbers),
                myLottoList = myLottoList
            )
        )
        ResultView.printWinningRate(
            winningRate = calculator.calculateWinningRateFromResult(
                totalWinCount = result.getTotalWinCount()
            )
        )
    }
}
