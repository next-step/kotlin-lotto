package lotto.controller

import lotto.domain.Money
import lotto.view.InputView

object LottoController {

    fun start() {
        val money = Money.of(InputView.getMoney())
    }
}
