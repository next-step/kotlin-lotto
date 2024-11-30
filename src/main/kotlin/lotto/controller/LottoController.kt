package lotto.controller

import lotto.domain.LottoCalculator
import lotto.domain.LottoFactory
import lotto.domain.LottoResult
import lotto.domain.data.Lotto
import lotto.view.InputView
import lotto.view.ResultView
import java.math.BigDecimal

class LottoController {
    fun start() {
        val totalPurchaseAmount = InputView.readTotalPurchaseAmountAsInt().toBigDecimal()

        val calculator = LottoCalculator()
        val totalLottoCount = calculator.calculateLottoCount(
            totalPurchaseAmount = totalPurchaseAmount,
            pricePerAmount = BigDecimal(1000)
        )
        // 총 구매 로또 개수
        ResultView.printTotalPurchaseCount(totalLottoCount)

        // 나의 로또 번호 리스트 출력
        val myLottoList = LottoFactory(totalLottoCount).createLottoList()
        ResultView.printLottoNumbers(myLottoList)

        // 결과 출력
        val winningNumbers = InputView.readWinningLotto(InputView.ENTER_LAST_WINNING_NUMBER)
        val result = LottoResult(
            winningLotto = Lotto(winningNumbers),
            myLottoList = myLottoList,
        )
        ResultView.printLottoResult(resultMap = result.getResults())
        ResultView.printProfitRate(
            profitRate = calculator.calculateProfitRate(
                result.getTotalProfit(),
                totalPurchaseAmount,
            )
        )
    }
}
