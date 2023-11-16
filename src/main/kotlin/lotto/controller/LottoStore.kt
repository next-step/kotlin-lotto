package lotto.controller

import lotto.domain.LottoMachine
import lotto.domain.LottoNumber
import lotto.domain.WinningLotto
import lotto.ui.InputView.receiveBonusBall
import lotto.ui.InputView.receivePurchaseMoney
import lotto.ui.InputView.receiveWinningNumber
import lotto.ui.ResultView
import lotto.ui.UserInterface.showNumbers

class LottoStore {
    private val lottoMachine: LottoMachine = LottoMachine()

    fun lotto() {
        val money = receivePurchaseMoney()
        val lottos = lottoMachine.purchase(money)
        showNumbers(lottos)

        val winningNumbers = receiveWinningNumber()
        val bonusBall = receiveBonusBall(winningNumbers)

        val bonusNumber = LottoNumber.from(bonusBall)

        val winningLotto = WinningLotto(winningNumbers, bonusNumber)
        val matchLottosResult = winningLotto.matchLottosResult(lottos)
        ResultView.show(matchLottosResult, money)
    }
}

fun main() {
    LottoStore().lotto()
}
