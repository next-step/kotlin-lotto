package lotto.controller

import lotto.domain.LottoMachine
import lotto.domain.Price
import lotto.view.inputPrice
import lotto.view.printBuyCount
import lotto.view.printLottoNumbers

class LottoController {
    fun start() {
        val price = Price(inputPrice())
        printBuyCount(price.value)
        val lottoMachine = LottoMachine(price)
        printLottoNumbers(lottoMachine.lottoNumbers())
    }

}
