package lotto.controller

import lotto.domain.LottoCalculator
import lotto.domain.LottoFactory
import lotto.domain.LottoResult
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.view.InputView
import lotto.view.ResultView
import java.math.BigDecimal

object LottoController {
    private val LOTTO_UNIT_PRICE = BigDecimal(1000)

    fun start() {
        val totalPurchaseAmount = InputView.readTotalPurchaseAmountAsBigDecimal()

        val totalLottoCount =
            LottoCalculator.calculateLottoCount(
                totalPurchaseAmount = totalPurchaseAmount,
                pricePerAmount = LOTTO_UNIT_PRICE,
            )
        // 총 구매 로또 개수
        ResultView.printTotalPurchaseCount(totalLottoCount)

        val myLottoList = createMyLottoList(totalLottoCount)
        // 나의 로또 번호 리스트 출력
        ResultView.printLottoNumbers(myLottoList)

        // 결과 출력
        val result = getLottoResult(myLottoList)
        ResultView.printLottoResult(resultMap = result.resultMap)
        ResultView.printProfitRate(
            profitRate =
            LottoCalculator.calculateProfitRate(
                result.getTotalProfit(),
                totalPurchaseAmount,
            ),
        )
    }

    private fun getLottoResult(myLottoList: List<Lotto>): LottoResult {
        val winningNumbers = InputView.readWinningLotto()
        val bonusLottoNumber = InputView.readBonusLotto()
        val result =
            LottoResult(
                winningLotto = LottoFactory.fromList(winningNumbers),
                bonusLottoNumber = LottoNumber(bonusLottoNumber),
                myLottos = myLottoList,
            )
        return result
    }

    private fun createMyLottoList(totalLottoCount: Int): List<Lotto> {
        val manualLottoCount = InputView.readManualLottoCount()
        val manualLottoNumberList = InputView.readManualLottoList(manualLottoCount)

        val myLottoList = LottoFactory(
            autoGeneratedLottoCount = totalLottoCount - manualLottoCount,
            manualLottoList = manualLottoNumberList
        ).createLottoList()
        return myLottoList
    }
}
