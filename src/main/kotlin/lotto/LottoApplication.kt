package lotto

import lotto.domain.Cashier
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoRank
import lotto.domain.Statistics
import lotto.domain.WinningLotto
import lotto.stretagy.RandomLottoNumberListGenerator
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val randomNumberListGenerator = RandomLottoNumberListGenerator()
    val amount = InputView.purchaseAmount()

    val cashier = Cashier(amount, randomNumberListGenerator)
    val lottos = cashier.purchaseLotto()

    OutputView.printPurchaseResult(lottos)

    val winningNumbers = InputView.winningNumbers().map(::LottoNumber).toSet()
    val bonusBall = LottoNumber(InputView.bonusBall())
    val winningLotto = WinningLotto(Lotto(winningNumbers), bonusBall)

    val statistics = Statistics(winningLotto, lottos)
    val lottoResult: Map<LottoRank, Int> = statistics.lottoResultGroupByRank()
    val earningRatio = statistics.calculateEarningRatio(amount)
    val earningResult = statistics.getProfitStatus(earningRatio)

    OutputView.printLottoResult(lottoResult, earningRatio, earningResult)
}
