package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoMachine
import lotto.domain.LottoNumber
import lotto.domain.WinningLotto
import lotto.ui.InputView.receiveBonusBall
import lotto.ui.InputView.receiveManualCount
import lotto.ui.InputView.receiveManualNumbers
import lotto.ui.InputView.receivePurchaseMoney
import lotto.ui.InputView.receiveWinningNumber
import lotto.ui.ResultView
import lotto.ui.UserInterface.showNumbers

class LottoStore {
    private val lottoMachine: LottoMachine = LottoMachine()

    fun lotto() {
        val money = receivePurchaseMoney()

        val manualCount = receiveManualCount()
        val manualNumbers = receiveManualNumbers(manualCount)

        val lottos = lottoMachine.purchase(money)
        showNumbers(lottos)

        val winningNumbers = receiveWinningNumber()
        val bonusBall = receiveBonusBall()

        val winLotto = Lotto(winningNumbers)
        val bonusNumber = LottoNumber.from(bonusBall)

        val winningLotto = WinningLotto(winLotto, bonusNumber)
        val matchLottosResult = winningLotto.matchLottosResult(lottos)
        ResultView.show(matchLottosResult, money)
    }
}

fun main() {
    LottoStore().lotto()
}
