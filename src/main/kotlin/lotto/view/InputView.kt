package lotto.view

import lotto.util.validateInputNumber

object InputView {
    private const val DELIMITER = ", "

    fun getBuyingMoney(): Int {
        OutputView.printRequestInputMoney()
        return readln().validateInputNumber().toInt()
    }

    fun getWinningLottoNumbers(): List<Int> {
        OutputView.printRequestInputWinningLotto()
        return readln().split(DELIMITER).map { it.trim().validateInputNumber().toInt() }
    }

    fun getBonusNumber(): Int {
        OutputView.printRequestInputBonusNumber()
        return readln().validateInputNumber().toInt()
    }
}
