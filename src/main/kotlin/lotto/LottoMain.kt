package lotto

import lotto.domain.Lotto
import lotto.domain.LottoResult
import lotto.domain.LottoShop
import lotto.domain.Profit
import lotto.domain.WinningLotto
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val money = InputView.getAmount()
    val lottos = LottoShop.getLottos(money)
    ResultView.printLottos(lottos)
    val lottoResult = Lotto(InputView.getWinningNumbers())
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
