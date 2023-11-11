package lotto.controller

import lotto.domain.LottoMachine
import lotto.domain.LottoMoney
import lotto.domain.RandomLottoNumbersGenerator
import lotto.view.InputView

class LottoController {

    fun run() {
        val money = InputView.getBuyingMoney()
        val lottoMachine = LottoMachine(LottoMoney(money), RandomLottoNumbersGenerator)
    }
}
