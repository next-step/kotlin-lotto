package lotto.controller

import lotto.domain.Lotto
import lotto.domain.Lottos
import lotto.domain.Purchase
import lotto.domain.Statistics
import lotto.dto.LottosDto
import lotto.dto.ResultDto
import lotto.infra.RandomNumberGenerator
import lotto.view.InputView
import lotto.view.OutputView

object LottoGame {
    fun run() {
        val purchase = Purchase(InputView.askPurchase())
        val lottos = Lottos.from(purchase.calculateQuantity(), RandomNumberGenerator())
        OutputView.printLottos(LottosDto(lottos.exportLottos()))

        val winningLotto = Lotto.from(InputView.askWinningNumbers())
        val statistics = Statistics(lottos.countMatches(winningLotto))
        OutputView.printResult(
            ResultDto.from(
                statistics.calculateRatio(purchase.purchasePrice),
                statistics.countedMatches
            )
        )
    }
}
