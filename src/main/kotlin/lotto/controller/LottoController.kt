package lotto.controller

import lotto.domain.LottoNumberGenerator
import lotto.domain.Money
import lotto.view.InputView

object LottoController {

    fun start() {
        val money = Money.of(InputView.getMoney())
        val lottoNumberGenerator = LottoNumberGenerator()
    }
}
