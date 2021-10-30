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
        val lottos = Lottos.of(
            purchase.calculateQuantity(Lotto.PRICE),
            RandomGeneratorFactory(LottoNumber.MIN, LottoNumber.MAX)
        )
        OutputView.printLottos(LottosDto.from(lottos))

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
