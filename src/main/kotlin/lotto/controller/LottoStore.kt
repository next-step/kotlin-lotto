package lotto.controller

import lotto.domain.LottoMachine
import lotto.ui.InputView.receivePurchaseMoney
import lotto.ui.InputView.receiveWinningNumber

class LottoStore {
    private val lottoMachine: LottoMachine = LottoMachine()
//    private val lottoChecker: LottoChecker = LottoChecker()
    fun lotto() {
        val money = receivePurchaseMoney()
        val lottos = lottoMachine.purchase(money)
//        showNumbers(lottos)

        val winningNumbers = receiveWinningNumber()

//        val winNumStatistics = lottoChecker.getWinNumStatistics(lottos, winningNumbers)
//        show(winNumStatistics)
    }
}

fun main() {
    LottoStore().lotto()
}
