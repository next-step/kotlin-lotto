package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.Lottos
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
        val manualLottos = Lottos.from(InputView.askManualLottos())
        val autoLottos = Lottos.of(
            purchase.calculateQuantity(Lotto.PRICE) - manualLottos.size(),
            RandomGeneratorFactory(LottoNumber.MIN, LottoNumber.MAX)
        )
        val lottos = manualLottos.merge(autoLottos)
        OutputView.printLottos(LottosDto.from(manualLottos.size(), autoLottos.size(), lottos))

        val winningLotto = Lotto.from(InputView.askWinningNumbers())
        val bonus = LottoNumber(InputView.askBonus())
        val statistics = Statistics(lottos.countMatches(winningLotto, bonus))
        OutputView.printResult(
            ResultDto.of(
                statistics.calculateRatio(purchase.purchasePrice),
                statistics.countedMatches
            )
        )
    }
}
