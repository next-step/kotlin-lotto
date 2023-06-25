package lotto.controller

import lotto.domain.*
import lotto.view.*

class LottoController {
    fun start() {
        val price = Price(inputPrice())
        val priceValue = price.value
        printBuyCount(priceValue)

        val lottoMachine = LottoMachine(price)
        val lottoNumbers = lottoMachine.lottoNumbers()
        printLottoNumbers(lottoNumbers)

        val winningNumbers = LottoNumbers(inputWinningNumbers())
        val winningLotto = WinningLotto(winningNumbers)

        printResultMessage()
        val lottoResult = LottoResult()
        printResult(
            lottoResult.lottoRanking(lottoNumbers, winningLotto),
            lottoResult.rateOfReturn(priceValue)
        )
    }

}
