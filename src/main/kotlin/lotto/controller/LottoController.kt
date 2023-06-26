package lotto.controller

import lotto.domain.LottoMachine
import lotto.domain.LottoNumbers
import lotto.domain.LottoResult
import lotto.domain.Price
import lotto.domain.WinningLotto
import lotto.model.LottoResultPrintModel
import lotto.view.inputPrice
import lotto.view.inputWinningNumbers
import lotto.view.printBuyCount
import lotto.view.printLottoNumbers
import lotto.view.printResult
import lotto.view.printResultMessage

class LottoController {
    fun start() {
        val price = Price(inputPrice())
        val priceValue = price.value
        printBuyCount(priceValue / 1000)

        val lottoMachine = LottoMachine(price)
        val lottoNumbers = lottoMachine.lottoNumbers()
        printLottoNumbers(lottoNumbers)

        val winningNumbers = LottoNumbers.from(inputWinningNumbers())
        val winningLotto = WinningLotto(winningNumbers)

        printResultMessage()
        val lottoResult = LottoResult()

        printResult(
            LottoResultPrintModel.ofList(lottoResult.lottoRanking(lottoNumbers, winningLotto)),
            lottoResult.rateOfReturn(priceValue)
        )
    }
}
