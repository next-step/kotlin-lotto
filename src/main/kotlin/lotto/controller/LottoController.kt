package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoMachine
import lotto.domain.LottoMachine.Companion.LOTTO_PRICE
import lotto.domain.LottoNumber
import lotto.domain.LottoResult
import lotto.domain.Lottos
import lotto.domain.Price
import lotto.domain.WinningLotto
import lotto.model.LottoResultPrintModel
import lotto.model.ManualLottoModel
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

        val manualLottNumbers = buyLotto(priceValue)
        val lottoNumbers = lottos(price, manualLottNumbers)
        val winningLotto = winningLotto()

        lottoResults(lottoNumbers, winningLotto, priceValue)
    }

    private fun buyLotto(priceValue: Int): ManualLottoModel {
        val totalBuyCount = priceValue / LOTTO_PRICE
        val manualBuyCount = inputManualBuyCount()

        require(totalBuyCount >= manualBuyCount) {
            "총 구매 수보다 수동 구매 수가 많을 수 없습니다."
        }

        printBuyCount(manualBuyCount, totalBuyCount - manualBuyCount)

        return ManualLottoModel(manualBuyCount, inputManualBuy(manualBuyCount))
    }

    private fun lottos(
        price: Price,
        manualLottNumbers: ManualLottoModel
    ): Lottos {
        val lottoMachine = LottoMachine(price, manualLottNumbers.manualBuyCount)
        val lottoNumbers = lottoMachine.lottoNumbers(manualLottNumbers.manualLottNumbers)
        printLottoNumbers(lottoNumbers)
        return lottoNumbers
    }

    private fun winningLotto(): WinningLotto {
        val winningNumbers = inputWinningNumbers()
        val bonusNumber = LottoNumber(inputBonusNumber())
        return WinningLotto(Lotto.from(winningNumbers), bonusNumber)
    }

    private fun lottoResults(
        lottoNumbers: Lottos,
        winningLotto: WinningLotto,
        priceValue: Int
    ) {
        printResultMessage()
        val lottoResult = LottoResult()

        printResult(
            LottoResultPrintModel.ofList(lottoResult.lottoRanking(lottoNumbers, winningLotto)),
            lottoResult.rateOfReturn(priceValue)
        )
    }
}
