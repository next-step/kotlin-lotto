package lotto

import lotto.domain.LottoChecker
import lotto.domain.LottoSeller
import lotto.domain.Lottos
import lotto.domain.WinNumbers
import lotto.io.InputView
import lotto.io.ResultView

class LottoGame {
    private val lottoSeller: LottoSeller

    init {
        val amount = InputView.getAmount()
        lottoSeller = LottoSeller(amount)
    }

    fun start() {
        val lottos = getLottos()
        ResultView.printLottos(lottos)
        val winNumbers = getWinNumbers()
        printResult(winNumbers, lottos)
    }

    private fun getWinNumbers(): WinNumbers {
        val winNumber = InputView.getWinNumbers()
        val bonusNumber = InputView.getBonusNumber()
        return WinNumbers(winNumber, bonusNumber)
    }

    private fun getLottos(): Lottos {
        val manualLottos = getManualLottos()
        val autoLottos = lottoSeller.sellAutoLottos()

        return Lottos(manualLottos, autoLottos)
    }

    private fun getManualLottos(): Lottos {
        val manualLottoSize = InputView.getManualLottoSize()
        return lottoSeller.sellManualLottos(manualLottoSize)
    }

    private fun printResult(winNumbers: WinNumbers, lottos: Lottos) {
        val result = LottoChecker.checkResult(lottos, winNumbers)
        ResultView.printResult(result)
    }
}
