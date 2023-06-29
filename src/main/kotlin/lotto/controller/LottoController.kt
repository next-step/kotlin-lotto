package lotto.controller

import lotto.domain.LottoMachine
import lotto.domain.LottoMachine.Companion.LOTTO_PRICE
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.LottoResult
import lotto.domain.Price
import lotto.domain.WinningLotto
import lotto.model.LottoResultPrintModel
import lotto.view.inputBonusNumber
import lotto.view.inputManualBuy
import lotto.view.inputManualBuyCount
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

        val totalBuyCount = priceValue / LOTTO_PRICE
        val manualBuyCount = inputManualBuyCount()

        require(totalBuyCount >= manualBuyCount) {
            "총 구매 수보다 수동 구매 수가 많을 수 없습니다."
        }

        printBuyCount(manualBuyCount, totalBuyCount - manualBuyCount)
        val manualLottNumbers = inputManualBuy(manualBuyCount)

        val lottoMachine = LottoMachine(price, manualBuyCount)
        val lottoNumbers = lottoMachine.lottoNumbers(manualLottNumbers)
        printLottoNumbers(lottoNumbers)

        val stringNumbers = inputWinningNumbers()
        val bonusNumber = LottoNumber(inputBonusNumber())
        val winningNumbers = LottoNumbers.from(stringNumbers)
        val winningLotto = WinningLotto(winningNumbers, bonusNumber)

        printResultMessage()
        val lottoResult = LottoResult()

        printResult(
            LottoResultPrintModel.ofList(lottoResult.lottoRanking(lottoNumbers, winningLotto)),
            lottoResult.rateOfReturn(priceValue)
        )
    }
}
