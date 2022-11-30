package lotto.ui

import lotto.domain.*
import lotto.ui.view.InputView
import lotto.ui.view.ResultView

class LottoController {
    fun main(args: Array<String>) {
        val purchasePrice = chargePaymentAmount()
        val purchaseLotto = purchaseLotto(purchasePrice)
        val ticketingLottoList = ticketingLotto(purchaseLotto)

        val winningLottoNumbers = drawWinningLottoNumbers()
        validateWinningLottoNumbersCondition(winningLottoNumbers)
        val winningLotto = Lotto(winningLottoNumbers)

        printLottoResult()
    }

    private fun chargePaymentAmount(): Int {
        return InputView.getPurchasePrice()
    }

    private fun purchaseLotto(purchasePrice: Int): Int {
        return LottoSaleMachine.purchase(purchasePrice)
    }

    private fun ticketingLotto(purchaseLotto: Int): List<Lotto> {
        return MutableList(purchaseLotto) {
            Lotto(LottoNumbersGenerator.generate())
        }
    }

    private fun drawWinningLottoNumbers(): List<Int> {
        return InputView.getWinningLotto()
    }

    private fun validateWinningLottoNumbersCondition(winningLottoNumbers: List<Int>): Boolean {
        if(!LottoNumbersValidator.validate(winningLottoNumbers)) throw IllegalArgumentException("유효하지 않은 로또 번호입니다.")

        return true
    }

    private fun printLottoResult() {
        ResultView.printLottoResult()
    }
}