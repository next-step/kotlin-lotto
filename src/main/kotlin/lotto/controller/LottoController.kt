package lotto.controller

import lotto.domain.Price
import lotto.view.inputPrice

class LottoController {
    fun start() {
        val price = Price(inputPrice())
    }

}
