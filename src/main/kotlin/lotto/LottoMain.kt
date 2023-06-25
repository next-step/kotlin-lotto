package lotto

import lotto.domain.Lotto
import lotto.domain.LottoResult
import lotto.domain.LottoShop
import lotto.domain.Profit
import lotto.domain.WinningLotto
import lotto.domain.toLottoNumber
import lotto.view.InputView
import lotto.view.ResultView

fun main() {

    val money = InputView.getAmount()
    val manualLottoCount = InputView.getManualLottoCount()
    val manualLottos = InputView.getManualLottoNumbers(manualLottoCount)

    val lottos = LottoShop.getLottos(money, manualLottos)

    ResultView.printLottos(lottos)
    val lottoResult = Lotto(InputView.getWinningNumbers().map { it.toLottoNumber() })
    val bonus = InputView.getBonusNumber()

    val result = LottoResult.calculateResult(
        lottos,
        WinningLotto(
            lotto = lottoResult,
            bonusNumber = bonus
        )
    )
    val lottoProfit = Profit.calculateLottoProfit(result)
    val lottoProfitRatio = Profit.calculateLottoProfitRatio(lottoProfit, money)

    ResultView.printStatistics(result, lottoProfitRatio)
}
