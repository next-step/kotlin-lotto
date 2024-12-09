package lotto.controller

import lotto.domain.Cashier
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoRank
import lotto.domain.LottoTicket
import lotto.domain.ManualLotto
import lotto.domain.ProfitStatus
import lotto.domain.Statistics
import lotto.domain.WinningLotto
import lotto.stretagy.RandomLottoNumberListGenerator
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(private val inputView: InputView, private val outputView: OutputView) {
    fun start() {
        val amount = inputView.purchaseAmount()

        val manualLottoCount = inputView.manualLottoCount()
        val manualLottoNumbers = inputView.manualLottos(manualLottoCount)
        val manualLotto = ManualLotto(manualLottoNumbers)

        val cashier = createCashier(amount, manualLotto)
        val manualLottos = cashier.purchaseManualLottos()

        val lottos = cashier.purchaseAutoLottos()
        outputView.printPurchaseResult(lottos.tickets)

        val winningLotto = inputWinningLotto()
        calculateAndPrintStatistics(winningLotto, lottos, amount)
    }

    private fun createCashier(
        amount: Int,
        manualLotto: ManualLotto,
    ): Cashier {
        val randomNumberListGenerator = RandomLottoNumberListGenerator()
        return Cashier(amount, randomNumberListGenerator, manualLotto)
    }

    private fun inputWinningLotto(): WinningLotto {
        val winningNumbers = inputView.winningNumbers().map(::LottoNumber).toSet()
        val bonusBall = LottoNumber(inputView.bonusBall())
        return WinningLotto(Lotto(winningNumbers), bonusBall)
    }

    private fun calculateAndPrintStatistics(
        winningLotto: WinningLotto,
        lottos: LottoTicket,
        amount: Int,
    ) {
        val statistics = Statistics(winningLotto, lottos.tickets)
        val lottoResult: Map<LottoRank, Int> = statistics.lottoResultGroupByRank()
        val earningRatio = statistics.calculateEarningRatio(amount)
        val earningResult = ProfitStatus.of(earningRatio)

        outputView.printLottoResult(lottoResult, earningRatio, earningResult)
    }
}
