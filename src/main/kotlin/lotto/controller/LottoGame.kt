package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.ManualLottos
import lotto.domain.Purchase
import lotto.domain.Statistics
import lotto.dto.LottosDto
import lotto.dto.ResultDto
import lotto.infra.RandomGeneratorFactory
import lotto.view.InputView
import lotto.view.OutputView

object LottoGame {
    fun run() {
        val purchase = Purchase(InputView.askPurchase())
        val manualLottos = ManualLottos(
            InputView.askManualLottos().map { it.toLotto() },
            purchase.calculateQuantity(Lotto.PRICE)
        )
        val autoLottos = manualLottos.generateAutoLottos(
            RandomGeneratorFactory(LottoNumber.MIN, LottoNumber.MAX)
        )
        val lottos = manualLottos.merge(autoLottos)
        OutputView.printLottos(LottosDto.from(manualLottos.size(), autoLottos.size(), lottos))

        val winningLotto = InputView.askWinningLotto().toWinningLotto()
        val statistics = Statistics(lottos.countMatches(winningLotto))
        OutputView.printResult(
            ResultDto.of(
                statistics.calculateRatio(purchase.purchasePrice),
                statistics.countedMatches
            )
        )
    }
}
