package lotto.controller

import lotto.domain.Cashier
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoRank
import lotto.domain.LottoTicket
import lotto.domain.ProfitStatus
import lotto.domain.Statistics
import lotto.domain.WinningLotto
import lotto.stretagy.RandomLottoNumberListGenerator
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(private val inputView: InputView, private val outputView: OutputView) {
    fun start() {
        val amount = inputView.purchaseAmount()
        val cashier = createCashier(amount)

        val lottos = purchaseLottos(cashier)
        outputView.printPurchaseResult(lottos.tickets)

        val winningLotto = inputWinningLotto()
        calculateAndPrintStatistics(winningLotto, lottos, amount)
    }

    private fun createCashier(amount: Int): Cashier {
        val randomNumberListGenerator = RandomLottoNumberListGenerator()
        return Cashier(amount, randomNumberListGenerator)
    }

    private fun purchaseLottos(cashier: Cashier): LottoTicket {
        return cashier.purchaseLotto2()
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
