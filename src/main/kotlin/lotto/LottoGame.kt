package lotto

import lotto.domain.Lotto
import lotto.domain.LottoChecker
import lotto.domain.LottoNumber
import lotto.domain.LottoSeller
import lotto.domain.Lottos
import lotto.domain.LottosResult
import lotto.domain.WinNumbers
import lotto.io.InputView
import lotto.io.ResultView

class LottoGame {
    private var amount = InputView.getAmount()
    private val lottoSeller = LottoSeller { InputView.getManualLotto().map { LottoNumber(it) } }

    init {
        require(amount > Lotto.LOTTO_PRICE) { MORE_THAN_LOTTO_PRICE_MESSAGE }
    }

    fun start() {
        val lottoResult = getLottos()
        ResultView.printLottos(lottoResult)
        val winNumbers = getWinNumbers()
        printResult(winNumbers, lottoResult.lottos)
    }

    private fun getWinNumbers(): WinNumbers {
        val winNumber = InputView.getWinNumbers()
        val bonusNumber = InputView.getBonusNumber()
        return WinNumbers(winNumber, bonusNumber)
    }

    private fun getLottos(): LottosResult {
        val manualLottos = getManualLottos()
        val lottoResponse = lottoSeller.sellAutoLottos(amount)
        amount = lottoResponse.change
        return LottosResult(manualLottos, lottoResponse.lottos)
    }

    private fun getManualLottos(): Lottos {
        val manualLottoSize = InputView.getManualLottoSize()
        return lottoSeller.sellManualLottos(amount, manualLottoSize).lottos
    }

    private fun printResult(winNumbers: WinNumbers, lottos: Lottos) {
        val result = LottoChecker.checkResult(lottos, winNumbers)
        ResultView.printResult(result)
    }

    companion object {
        private const val MORE_THAN_LOTTO_PRICE_MESSAGE = "${Lotto.LOTTO_PRICE}이상의 금액을 입력해주세요"
    }
}
