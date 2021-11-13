package lotto.controller

import lotto.domain.BonusBall
import lotto.domain.Lotto
import lotto.domain.LottoGenerator
import lotto.domain.LottoGeneratorImpl
import lotto.domain.Lottos
import lotto.domain.Money
import lotto.view.InputView
import lotto.view.OutputView

object LottoController {

    fun start() {
        val money = Money.from(InputView.getMoney())
        val lottoGenerator: LottoGenerator = LottoGeneratorImpl(money)
        val lottos = Lottos.from(lottoGenerator)
        OutputView.showLottos(lottos)
        val winningLotto = Lotto.from(InputView.inputWinningNumbers())
        val bonusBall = BonusBall.of(InputView.inputBonusBall(), winningLotto)
        val lottoResult = lottos.match(winningLotto, bonusBall)
        OutputView.printOverview(lottoResult)
        OutputView.printProfitPercent(lottoResult, money)
    }
}
