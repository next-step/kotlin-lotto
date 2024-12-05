package lotto.controller

import lotto.domain.Cashier
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoRank
import lotto.domain.Statistics
import lotto.domain.WinningLotto
import lotto.stretagy.RandomLottoNumberListGenerator
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(private val inputView: InputView, private val outputView: OutputView) {
    fun start() {
        val randomNumberListGenerator = RandomLottoNumberListGenerator()
        val amount = inputView.purchaseAmount()

        val cashier = Cashier(amount, randomNumberListGenerator)
        val lottos = cashier.purchaseLotto2()

        outputView.printPurchaseResult(lottos.tickets)

        val winningNumbers = inputView.winningNumbers().map(::LottoNumber).toSet()
        val bonusBall = LottoNumber(inputView.bonusBall())
        val winningLotto = WinningLotto(Lotto(winningNumbers), bonusBall)

        val statistics = Statistics(winningLotto, lottos.tickets)
        val lottoResult: Map<LottoRank, Int> = statistics.lottoResultGroupByRank()
        val earningRatio = statistics.calculateEarningRatio(amount)
        val earningResult = statistics.getProfitStatus(earningRatio)

        outputView.printLottoResult(lottoResult, earningRatio, earningResult)
    }
}
