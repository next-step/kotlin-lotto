package lotto.controller

import lotto.domain.LottoNumberGenerator
import lotto.domain.Lottos
import lotto.domain.Money
import lotto.view.InputView
import lotto.view.OutputView

object LottoController {

    fun start() {
        val money = Money.of(InputView.getMoney())
        val lottoNumberGenerator = LottoNumberGenerator()
        val lottos = Lottos.of(lottoNumberGenerator, money)
        OutputView.showLottos(lottos)
    }
}
